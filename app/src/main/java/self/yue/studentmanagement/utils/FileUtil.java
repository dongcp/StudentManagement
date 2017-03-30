package self.yue.studentmanagement.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by yue on 3/30/17.
 */

public class FileUtil {

    private Context mContext;

    private static FileUtil sInstance;

    private FileUtil() {
    }

    public static FileUtil getInstance() {
        if (sInstance == null) {
            synchronized (FileUtil.class) {
                if (sInstance == null) {
                    sInstance = new FileUtil();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        mContext = context;
    }

    public String getAppDir() {
        File directory = new File(Environment.getExternalStorageDirectory(), mContext.getPackageName());
        return directory.getAbsolutePath();
    }
}
