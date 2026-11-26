/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.mysql.jdbc;

import io.debezium.config.Configuration;
import io.debezium.connector.binlog.jdbc.BinlogFieldReaderResolver;
import io.debezium.connector.mysql.MySqlConnectorConfig;
import io.debezium.service.spi.ServiceProvider;
import io.debezium.service.spi.ServiceRegistry;

/**
 * Provides MySQL's default {@link BinlogFieldReaderResolver}, which delegates to {@link MySqlFieldReaderResolver}.
 */
public class MySqlFieldReaderResolverServiceProvider implements ServiceProvider<BinlogFieldReaderResolver> {
    @Override
    public Class<BinlogFieldReaderResolver> getServiceClass() {
        return BinlogFieldReaderResolver.class;
    }

    @Override
    public BinlogFieldReaderResolver createService(Configuration configuration, ServiceRegistry serviceRegistry) {
        return connectorConfig -> MySqlFieldReaderResolver.resolve((MySqlConnectorConfig) connectorConfig);
    }
}
