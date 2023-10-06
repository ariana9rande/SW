package com.hjh.movie.service;

import com.hjh.movie.model.Movie;
import com.hjh.movie.model.Review;
import com.hjh.movie.model.User;
import com.hjh.movie.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService
{
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository)
    {
        this.reviewRepository = reviewRepository;
    }

    public void register(Double rating, String comment, User user, Movie movie)
            throws Exception
    {
        if(reviewRepository.findByUserAndMovie(user, movie) != null)
        {
            throw new Exception("이미 리뷰를 작성한 영화입니다.");
        }

        if(user == null)
        {
            throw new Exception("로그인 이후 이용해주세요.");
        }

        Review review = new Review();
        review.setRating(rating);
        review.setComment(comment);
        review.setUser(user);
        review.setMovie(movie);

        reviewRepository.save(review);
    }

    public List<Review> getReviewList(Long id)
    {
        return reviewRepository.findByMovieId(id);
    }

    public Review getReview(Long id)
    {
        return reviewRepository.getById(id);
    }

    public void update(Review review)
    {
        reviewRepository.save(review);
    }
}
