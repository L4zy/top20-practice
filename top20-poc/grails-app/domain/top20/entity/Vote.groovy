package top20.entity

class Vote {

	Long id;
	Date votDate = new Date();
	static belongsTo = [song: Song]
	
    static constraints = {
    }
}
