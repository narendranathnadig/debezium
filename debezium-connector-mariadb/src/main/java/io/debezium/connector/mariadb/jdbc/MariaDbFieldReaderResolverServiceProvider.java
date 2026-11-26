/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.mariadb.jdbc;

import io.debezium.config.Configuration;
import io.debezium.connector.binlog.jdbc.BinlogFieldReaderResolver;
import io.debezium.connector.mariadb.MariaDbConnectorConfig;
import io.debezium.service.spi.ServiceProvider;
import io.debezium.service.spi.ServiceRegistry;

/**
 * Provides MariaDB's default {@link BinlogFieldReaderResolver}, which always uses the {@link MariaDbFieldReader}.
 */
public class MariaDbFieldReaderResolverServiceProvider implements ServiceProvider<BinlogFieldReaderResolver> {
    @Override
    public Class<BinlogFieldReaderResolver> getServiceClass() {
        return BinlogFieldReaderResolver.class;
    }

    @Override
    public BinlogFieldReaderResolver createService(Configuration configuration, ServiceRegistry serviceRegistry) {
        return connectorConfig -> new MariaDbFieldReader((MariaDbConnectorConfig) connectorConfig);
    }
}
