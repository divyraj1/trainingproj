package com.example.twitter.Controller;


import com.example.twitter.entity.*;
import com.example.twitter.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
class Car
{
    String color;
    String type;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Car()
    {

    }
    Car(String color,String type)
    {
        this.color=color;
        this.type=type;
    }

}
@RestController
public class HomeController
{
    @Autowired
    UserRepository userRepository;
    @Autowired

    TweetRepository tweetRepository;
    @Autowired
    UserFeedRepository userFeedRepository;
    @Autowired
    TweetLikeRepository tweetLikeRepository;
    @Autowired
    TweetCommentRepository tweetComment;
    @Autowired
    UserFolloweRepository userFolloweRepository;
    @GetMapping("/all")
    public List<User> findAllUser()
    {
        List<User> a=userRepository.findAll();
        return a;
    }
    @PostMapping("/signup")
    public User save(@RequestParam("retry_count") Integer u)
    {
         System.out.println(u+"" );
        // userRepository.save(u);
        //ObjectMapper objectMapper = new ObjectMapper();
        //String jsonCarArray =
          //      "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
       // List<Car> listCar=null;
       // try {
        //   listCar= objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {
         //   });
        //} catch (JsonProcessingException e) {
          //  e.printStackTrace();
       // }
      //  System.out.println(listCar);
        return new User();
    }

    @GetMapping("/alltweets")
    public List<Tweet> getalltweet()
    {
        List<Tweet> a = tweetRepository.findAll();
        return a;
    }
    @GetMapping("/allfollwer/{fid}")
   public List<UserFollower> getalltweett(@PathVariable("fid") long fid)
  {
      System.out.println("Hello");
       List<UserFollower> a = userFolloweRepository.findUserFollowersByUser_Userid(1);
        return a;
  }
  @PostMapping("/addlike/{tweetid}/{userid}")
  public void add(@PathVariable("tweetid")Long tweetid,@PathVariable("userid")Long userid)
  {

     Tweet t=tweetRepository.findTweetByTweetid(tweetid);
      User u=userRepository.findByUserid(userid);
     // System.out.println(t+""+u);
      TweetLike tw=TweetLike.builder().tweet(t).user(u).build();
      tweetLikeRepository.save(tw);
  }
  @PostMapping("/follow/{userid1}/{userid2}")
  public void follow(@PathVariable("userid1")Long userid1,@PathVariable("userid2")Long userid2)
  {
      User user1=(User) userRepository.findByUserid(userid1);
      User user2=(User) userRepository.findByUserid(userid2);
      //System.out.println(user1);
      //System.out.println(user2);
      UserFollower u=UserFollower.builder().user(user1).userr(user2).build();
      userFolloweRepository.save(u);
  }
  @GetMapping("/follower/{uid}")
  public List<UserFollower>follower(@PathVariable("uid")Long uid)
  {
     List<UserFollower>f=userFolloweRepository.findUserFollowersByUser_Userid(uid);
      return f;
  }
}
