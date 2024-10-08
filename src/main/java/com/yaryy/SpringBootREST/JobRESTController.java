package com.yaryy.SpringBootREST;

import com.yaryy.SpringBootREST.model.JobPost;
import com.yaryy.SpringBootREST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // to return a data not a view
public class JobRESTController {

    @Autowired
    private JobService service;

    @GetMapping(path="jobPosts") // only json data /*, produces = {"application/json"}*/
    // @ResponseBody  // to return a data not a view
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }
    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "deleted";
    }

    @GetMapping("load")
    public void loadData(){
        service.load();
    }

}
