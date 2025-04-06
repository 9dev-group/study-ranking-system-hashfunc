SELECT
    message->request_uri,
    COUNT(*) AS cnt
FROM access_log_stream
WINDOW HOPPING (
  SIZE 30 SECONDS,
  ADVANCE BY 10 SECONDS
)
GROUP BY
    message->request_uri,
    message->remote_ip
EMIT CHANGES
;

CREATE STREAM access_log_stream (
       message STRUCT<
          request_uri VARCHAR
       >
) WITH (
    KAFKA_TOPIC='kubernetes_access_logs',
    VALUE_FORMAT='JSON'
)
;

CREATE TABLE access_ranking
WITH (
    KAFKA_TOPIC='access_ranking',
    VALUE_FORMAT='JSON'
) AS
SELECT
    message->request_uri,
    COUNT(*) AS cnt
FROM access_log_stream
WINDOW HOPPING (
  SIZE 300 SECONDS,
  ADVANCE BY 60 SECONDS
)
GROUP BY
    message->request_uri
EMIT FINAL
;