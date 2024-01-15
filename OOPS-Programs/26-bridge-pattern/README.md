# Bridge Pattern

* used to decouple the abstraction from implementation
* useful when you have loads of classes and subclasses
* converts 'is' relation to 'has' relation


* example (without bridge pattern)
  * video
    * youtubeHD
    * netflixHD
    * youtube4K
    * netflix4K
    * youtube8K
    * netflix8K
  
* example (with bridge pattern)
  * video
    * youtube
    * netflix
  * video-processor
    * HD
    * 4K
    * 8K