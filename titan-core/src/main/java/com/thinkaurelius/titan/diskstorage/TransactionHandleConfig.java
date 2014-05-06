package com.thinkaurelius.titan.diskstorage;

import com.thinkaurelius.titan.util.time.Timepoint;
import com.thinkaurelius.titan.diskstorage.configuration.ConfigOption;
import com.thinkaurelius.titan.diskstorage.configuration.Configuration;

/**
 * @author Matthias Broecheler (me@matthiasb.com)
 * @author Dan LaRocque <dalaro@hopcount.org>
 */
public interface TransactionHandleConfig {

    /**
     * Returns the commit time of this transaction which is either a custom timestamp provided
     * by the user, the commit time as set by the enclosing operation, or the first time this method is called.
     *
     * @return commit timestamp for this transaction
     */
    public Timepoint getCommitTime();

    /**
     * Sets the commit time of this transaction. If a commit time has already been set, this method throws
     * an exception. Use {@link #hasCommitTime()} to check prior to setting.
     *
     * @param time
     */
    public void setCommitTime(Timepoint time);

    /**
     * Returns true if a commit time has been set on this transaction.
     *
     * @return
     */
    public boolean hasCommitTime();

    /**
     * Returns the timepoint at which this transaction was started
     * @return
     */
    public Timepoint getStartTime();

    /**
     * Returns the (possibly null) group name for this transaction.
     * Transactions are grouped under this name for reporting and error tracking purposes.
     *
     * @return group name prefix string or null
     */
    public String getGroupName();

    /**
     * True when {@link #getGroupName()} is non-null, false when null.
     */
    public boolean hasGroupName();

    /**
     * Get an arbitrary transaction-specific option.
     *
     * @param opt option for which to return a value
     * @return value of the option
     */
    public <V> V getCustomOption(ConfigOption<V> opt);

    /**
     * Return any transaction-specific options.
     *
     * @see #getCustomOption(ConfigOption)
     * @return options for this tx
     */
    public Configuration getCustomOptions();
}
