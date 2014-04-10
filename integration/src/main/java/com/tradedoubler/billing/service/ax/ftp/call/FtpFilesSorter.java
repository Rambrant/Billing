package com.tradedoubler.billing.service.ax.ftp.call;

import org.apache.commons.net.ftp.FTPFile;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sorts ftp files according to their timestamp
 */
@Deprecated
class FtpFilesSorter {



    public FTPFile[] getSortedList(FTPFile[] files) {
        Comparator<Object> comparator = new Comparator<Object>() {

            public int compare(Object o1, Object o2) {
                FTPFile f1 = (FTPFile) o1;
                FTPFile f2 = (FTPFile) o2;
                return f1.getTimestamp().getTime().compareTo(f2.getTimestamp().getTime());
            }

        };

        Arrays.sort(files, comparator);

        return files;
    }
}




