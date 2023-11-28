package com.heima.utils.common;

import com.heima.utils.properties.OssProperties;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data
@AllArgsConstructor
@Slf4j
@EnableConfigurationProperties(OssProperties.class)
public class OssUtil {

    private final OssProperties ossProperties;

    /**
     * 文件上传
     *
     * @param bytes
     * @param objectName
     * @return
     */
    public String upload(byte[] bytes, String objectName) {

        Auth auth = Auth.create(ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret());
        Configuration cfg = new Configuration(Region.region0());
        UploadManager uploadManager = new UploadManager(cfg);
        String Token = auth.uploadToken(ossProperties.getBucketName());
        try {
            Response response = uploadManager.put(bytes,objectName,Token);
        } catch (QiniuException e) {
            System.out.println("Error Message:" + e.getMessage());
        }


        //文件访问路径规则 https://BucketName.Endpoint/ObjectName
        StringBuilder stringBuilder = new StringBuilder("http://");
        stringBuilder
                .append(ossProperties.getEndpoint())
                .append("/")
                .append(objectName);
        log.info("文件上传到:{}", stringBuilder.toString());

        return stringBuilder.toString();
    }
}
