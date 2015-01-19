package top20.poc

import top20.entity.Artist
import top20.entity.Song;
import top20.entity.Vote;

class VoteController {

    static defaultAction = "list"
	
	def voteService
	
	def vote(){
		Vote vote = new Vote(params);
		voteService.saveVote(vote);
		
		redirect(controller: "song", action: "list");
	}
	
}
