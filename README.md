# MediaViewer-Android

![](preview.gif)

get the library

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  ```
  Step 2. Add the dependency
  ```
  dependencies {
	        implementation 'com.github.AhmMhd:MediaViewer-Android:1.0.1'
	}
  ```
  **************************************************************************************************************************************
  # USAGE

String type Arraylist with urls

```
val mediaList = ArrayList<String>()
        mediaList.add("https://worldsportlogos.com/wp-content/uploads/2018/02/Arsenal-logo.png")
        mediaList.add("https://sample-videos.com/video123/mp4/240/big_buck_bunny_240p_1mb.mp4")
        mediaList.add("https://upload.wikimedia.org/wikipedia/commons/a/ae/Warrenvillegrove.jpg")
        mediaList.add("http://img.phone.baidu.com/public/uploads/store_2/2/8/6/286c53ae56fa24f37d08d013de10d61c.png")

```

Open MediaViewer activity and pass the arraylist as intent extra
```
val intent = Intent(this,MediaViewer::class.java)
        intent.putExtra(Constant.MEDIA_LIST_EXTRA,mediaList)
        startActivity(intent)
```

