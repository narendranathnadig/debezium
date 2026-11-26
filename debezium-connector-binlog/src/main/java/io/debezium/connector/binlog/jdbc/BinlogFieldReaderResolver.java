/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.binlog.jdbc;

import io.debezium.common.annotation.Incubating;
import io.debezium.connector.binlog.BinlogConnectorConfig;
import io.debezium.service.Service;

/**
 * Contract for resolving the {@link BinlogFieldReader} a binlog connector uses to read column values from JDBC
 * result sets. Each connector registers its own default, which a {@link io.debezium.service.spi.ServiceProviderContributor}
 * can replace, for example to read values the way a different JDBC driver returns them.
 */
@Incubating
public interface BinlogFieldReaderResolver extends Service {
    /**
     * Resolve the field reader to use.
     *
     * @param connectorConfig the connector configuration, never {@code null}
     * @return the field reader, never {@code null}
     */
    BinlogFieldReader resolve(BinlogConnectorConfig connectorConfig);
}
