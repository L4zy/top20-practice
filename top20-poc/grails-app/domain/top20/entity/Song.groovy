package top20.entity

class Song {

	Long id;
	String name;

	    static constraints = {
		name(brank: false)
    }
}
