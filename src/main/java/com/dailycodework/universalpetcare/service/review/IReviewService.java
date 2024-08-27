package com.dailycodework.universalpetcare.service.review;

import com.dailycodework.universalpetcare.model.Review;
import com.dailycodework.universalpetcare.requests.ReviewUpdateRequest;
import org.springframework.data.domain.Page;

public interface IReviewService {
    Review saveReview(Review review, Long reviewerId, Long veterinarianId);
    double getAverageRatingForVet(Long veterinarianId);
    Review updateReview(Long reviewId, ReviewUpdateRequest review);
    Page<Review> findAllReviewsByUserId(Long userId, int page, int size);
    void deleteReview(Long reviewerId);
}
