package com.codinglife.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.codinglife.service.VodService;
import com.codinglife.util.AliyunVodConfigConstant;
import com.codinglife.util.AliyunVodSDKUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @Description: 阿里云视频vod点播服务类
 * @author: CodingLifeVV
 * @date: 2022.04.12
 */
@Service
public class VodServiceImpl implements VodService {

    /**
     * 上传视频到阿里云端
     * @param file
     * @return
     */
    @Override
    public String uploadVideo(MultipartFile file) {
        try {
            //accessKeyId, accessKeySecret
            String fileName = file.getOriginalFilename();
            //title：上传之后显示名称
            String title = fileName.substring(0, fileName.lastIndexOf("."));
            //inputStream：上传文件输入流
            InputStream inputStream = file.getInputStream();
            UploadStreamRequest request = new UploadStreamRequest(AliyunVodConfigConstant.ACCESS_KEY_ID, AliyunVodConfigConstant.ACCESS_KEY_SECRET, title, fileName, inputStream);

            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);

            String videoId = response.getVideoId();
            // 如果设置回调URL无效,不影响视频上传,可以返回VideoId同时会返回错误码
            // 其他情况上传失败时,VideoId为空,此时需要根据返回错误码分析具体错误原因
            if (!response.isSuccess()) {
                String errorMessage = "阿里云上传错误：" + "code：" +
                        response.getCode() + ", message：" + response.getMessage();
                if(ObjectUtils.isEmpty(videoId)){
                    System.out.println(errorMessage);
                }
            }

            return videoId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void removeVideo(String videoId) {
        try {
            //初始化对象
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                    AliyunVodConfigConstant.ACCESS_KEY_ID,
                    AliyunVodConfigConstant.ACCESS_KEY_SECRET);
            //创建删除视频的request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            //向request中设置videoId
            request.setVideoIds(videoId);
            //调用删除方法
            DeleteVideoResponse response = client.getAcsResponse(request);

            System.out.println("RequestId = " + response.getRequestId() + "\n");

        } catch (ClientException e) {
            System.out.println("视频删除失败");
        }
    }
}
