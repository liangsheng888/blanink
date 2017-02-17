package com.blanink.oss;

import android.content.Context;
import android.util.Log;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blanink.utils.ExampleUtil;

/**
 * Created by Administrator on 2017/2/17.
 */

public class OssService {
    private static String AccessKey="LTAIekaAAtoKtE8s";
    private static String AccessKeySecret="1tav7M1OlqK5A2HmcbgQldgNwiWXuy";
    private String RoleArn="acs:ram::1717376254830967:role/aliyunosstokengeneratorrole";
    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

    public static OSSClient  getOSSClient(Context context){
    // 明文设置secret的方式建议只在测试时使用，更多鉴权模式请参考后面的`访问控制`章节
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(AccessKey, AccessKeySecret);
        OSSClient oss = new OSSClient(context, endpoint, credentialProvider);
        return  oss;
    }

public static PutObjectRequest upLoad(String bucketName,String objectKey,String path){
    PutObjectRequest put = new PutObjectRequest("blanink", objectKey,path);
    // 异步上传时可以设置进度回调
    put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
        @Override
        public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
            Log.d("TenderPublish", "currentSize: " + currentSize + " totalSize: " + totalSize);


        }
    });
   return  put;
}

}
