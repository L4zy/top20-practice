package top20.entity

class Song {

	Long id;
	String name;
	static hasMany = [vots: Vote]
	
	static belongsTo = [artist: Artist]
	
	static mapping = {
		vots cascade: 'all-delete-orphan'
	}

	static constraints = { name(brank: false) }
}
