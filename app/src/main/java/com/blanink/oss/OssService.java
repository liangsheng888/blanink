package com.blanink.oss;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.DeleteObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteObjectResult;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */

public class OssService {
    public static String AccessKey = "LTAIekaAAtoKtE8s";
    public static String AccessKeySecret = "1tav7M1OlqK5A2HmcbgQldgNwiWXuy";
    public String RoleArn = "acs:ram::1717376254830967:role/aliyunosstokengeneratorrole";
    public static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    public static String OSS_URL = "http://blanink.oss-cn-hangzhou.aliyuncs.com/";
    //初始化得到OSS
    public static OSSClient getOSSClientInstance(Context context){
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(OssService.AccessKey, OssService.AccessKeySecret);
        OSSClient oss = new OSSClient(context, OssService.endpoint, credentialProvider);
        return oss;
    }

    public static boolean uploadFiles(OSSClient oss,List<String> urls) {
        if (null == urls || urls.size() == 0) {
            return false;
        } // 上传文件
        Boolean success=ossUpload(oss,urls);
        return success;
    }
    //递归上传支持多文件上传

    public static boolean ossUpload(final OSSClient oss, final List<String> urls) {
        Boolean isSucess = false;

        if (urls.size() <= 0) {
            isSucess=true;
            // 文件全部上传完毕，这里编写上传结束的逻辑，如果要在主线程操作，最好用Handler或runOnUiThead做对应逻辑
            return isSucess;// 这个return必须有，否则下面报越界异常，原因自己思考下哈
        }
        final String url = urls.get(0);
        if (TextUtils.isEmpty(url)) {
            urls.remove(0);
            // url为空就没必要上传了，这里做的是跳过它继续上传的逻辑。
            ossUpload(oss, urls);
            return isSucess;
        }

        File file = new File(url);
        if (null == file || !file.exists()) {
            urls.remove(0);
            // 文件为空或不存在就没必要上传了，这里做的是跳过它继续上传的逻辑。
            ossUpload(oss, urls);
            return isSucess;
        }
        // 文件后缀
        String fileSuffix = "";
        if (file.isFile()) {
            // 获取文件后缀名
            fileSuffix = file.getName().substring(file.getName().lastIndexOf("."));
        }
        // 文件标识符objectKey
        final String objectKey = "alioss_" + System.currentTimeMillis() + fileSuffix;
        // 下面3个参数依次为bucket名，ObjectKey名，上传文件路径
        PutObjectRequest put = new PutObjectRequest("blanink", objectKey, url);

        // 设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                // 进度逻辑
            }
        });

        // 异步上传
        OSSAsyncTask task = oss.asyncPutObject(put,
                new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                    @Override
                    public void onSuccess(PutObjectRequest request, PutObjectResult result) { // 上传成功
                        urls.remove(0);
                        ossUpload(oss, urls);// 递归同步效果
                    }

                    @Override
                    public void onFailure(PutObjectRequest request, ClientException clientExcepion,
                                          ServiceException serviceException) { // 上传失败

                        // 请求异常
                        if (clientExcepion != null) {
                            // 本地异常如网络异常等
                            clientExcepion.printStackTrace();
                        }
                        if (serviceException != null) {
                            // 服务异常
                            Log.e("ErrorCode", serviceException.getErrorCode());
                            Log.e("RequestId", serviceException.getRequestId());
                            Log.e("HostId", serviceException.getHostId());
                            Log.e("RawMessage", serviceException.getRawMessage());
                        }
                    }
                });
        // task.cancel(); // 可以取消任务
        // task.waitUntilFinished(); // 可以等待直到任务完成
        return isSucess;
    }

//删除文件
    public static void deleteFile(OSSClient oss,String bucketName,String objectKey){
        try {
            boolean isExist = oss.doesObjectExist(bucketName, objectKey);//判断是否存在该文件
            if(isExist){
                 oss.asyncDeleteObject(new DeleteObjectRequest(bucketName, objectKey), new OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult>() {
                     @Override
                     public void onSuccess(DeleteObjectRequest deleteObjectRequest, DeleteObjectResult deleteObjectResult) {

                     }

                     @Override
                     public void onFailure(DeleteObjectRequest deleteObjectRequest, ClientException e, ServiceException e1) {

                     }
                 });
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}