package top20.poc

import top20.entity.Artist;
import top20.entity.Song;
import top20.entity.Top;

class TopController {

   def topService
	
	def list() {
		
		Top top = new Top();
		top.artistOfTheWeek = topService.artistOfTheWeek();
		top.songOfTheWeek = topService.songOfTheWeek();
		top.mostPopulatArtist = topService.mostPopulatArtist();
		top.mostPopulatSong = topService.mostPopulatSong();
		
		respond  top, model:[top: top]
	}
}
