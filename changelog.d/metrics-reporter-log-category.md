### Fixes

- The default Iceberg metrics reporter no longer logs every scan and commit report at `INFO`. Since
  1.7.0 the reporter logs under `org.apache.polaris.service.metrics.LoggingMetricsReporter`, while
  the default configuration still turned off the old `org.apache.polaris.service.reporting`
  category. To see the reports, set the `org.apache.polaris.service.metrics.LoggingMetricsReporter`
  logger level to `INFO`.
