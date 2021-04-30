/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.pipeline.source.snapshot.incremental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.debezium.pipeline.signal.Signal;
import io.debezium.pipeline.signal.Signal.Payload;

public class CloseIncrementalSnapshotWindow implements Signal.Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloseIncrementalSnapshotWindow.class);

    public static final String NAME = "snapshot-window-close";

    private IncrementalSnapshotChangeEventSource<?> eventSource;

    public CloseIncrementalSnapshotWindow(IncrementalSnapshotChangeEventSource<?> eventSource) {
        this.eventSource = eventSource;
    }

    @Override
    public boolean arrived(Payload signalPayload) throws InterruptedException {
        eventSource.closeWindow(signalPayload.offsetContext);
        return true;
    }

}
