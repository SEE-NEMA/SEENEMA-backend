package com.example.SEENEMA.post.view.service;


import com.example.SEENEMA.post.view.dto.ViewPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ViewPostService {

    ViewPostDto.addResponse createViewPost(Long userId, Long theaterId, ViewPostDto.addRequest requestDto);
    ViewPostDto.detailResponse readViewPost(Long userId, Long theaterId, String title, Long viewNo);
    ViewPostDto.addResponse updateViewPost(Long theaterId, String title, Long viewNo, ViewPostDto.updateRequest requestDto);
    void deleteViewPost(Long theaterId, String title, Long viewNo);

    List<ViewPostDto.viewListResponse>  getListBySeat(Long theaterId, String seatName);
    List<ViewPostDto.viewListResponse>  getListByTheater(Long theaterId);

}