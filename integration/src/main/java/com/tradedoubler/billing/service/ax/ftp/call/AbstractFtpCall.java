package com.tradedoubler.billing.service.ax.ftp.call;

import com.tradedoubler.billing.service.ax.ftp.FtpSetupServiceSetupImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Autowires the Setup class that is used in the different sub classed ftp calls */
@Component
public abstract class AbstractFtpCall {
    @Autowired
    protected FtpSetupServiceSetupImpl ftpSetup;


}
