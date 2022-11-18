# Mobile Applications 1 - Summary

## Introduction, Mobile Platform

*Native mobile applications*

- platform specific language, APIs and central app store

Pro:

- usually offer the best performance
- deepest integration
- best overall user experience

Con:

- most complex development option

Web based mobile application

- HTML, JavaScript, and CSS
- Do no rely on app store
- Try to emulate the look-and-feel of an app

Hybrid mobile application

- Frameworks can build a native wrapper around web apps
- Allow to revise content and feature without using the app stores

## Design and Development of Mobile Apps

### From idea to concept

Three aspects of successful app development

- human desirability (desire, value, user experience, etc.)
- financial viability (business model)
- technical feasibility (technology)

### Understand the problem

Describe the user's needs

- ...

Understand through observation

Interviews

- user interviews can lead to a deeper understanding
- interviews should not be power driven
- keep the conversations / interviews informal
- no leading questions

### Put the user into focus

Empathize Phase

- tasks
- feelings
- influences
- pain points
- overall goal

Good and bad habits 

- TODO:

(Prototype) Personas

- TODO:

User persona:

### Think about a solution

1. Find a lot of solutions
2. Find the best solution

### Storytelling design

- user narratives TODO
- user stories TODO

### Wireframe, prototype and mockup

- Forms of representation of the final product

*Wireframe*

- low fidelity representation of a design
- it should show
    - the main groups of content
    - the structure of information
    - a description and basic visualisation of the UI interaction

Usage TODO

Tools: TODO

How to: TODO

*Prototype*

- Middle to high fidelity representation of the final product
- allows to
    - experience content and interactions with the interface
    - test the main interactions in a way similar to the final product
- might not look exactly like the final product, but should be similar
- interdependence between the interface and backend is often omitted

Usage TODO

Tools: TODO

How to: TODO

*Mockup*

- Middle to high fidelity, static, design representation
- Visual design draft, or even the actual visual design
- Demonstrates the basic functionalities in a static way
- Encourages to review the visual side of the project
- Much quicker to create than prototypes

Tools: TODO

How to: TODO

*Summary*

|   | Fidelity  | Cost  | Use  | General traits  |
|---|---|---|---|---|
| Wireframe  | low  | low  | documentation, quick communication  | sketchy, black, white & grey representation of the interface  |
| Prototype  | middle to high | high  | user testing, reusable backbone of the interface  | interactive  |
| Mockup  | middle to high  | medium  | gathering feedback and getting buy-in from stakeholders  | static visualization  |

Proof-of-concept implementation

- another prototyping artifact
- focus on the risks in the project
- elaborate technical possibilities and boundaries

## Kotlin

Test your Kotlin code [here](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjIwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiLyoqXG4gKiBZb3UgY2FuIGVkaXQsIHJ1biwgYW5kIHNoYXJlIHRoaXMgY29kZS5cbiAqIHBsYXkua290bGlubGFuZy5vcmdcbiAqL1xuZnVuIG1haW4oKSB7XG4gICAgcHJpbnRsbihcIkhlbGxvLCB3b3JsZCEhIVwiKVxufSJ9) 

### Overview

...

*Variables*

```kotlin
// Variable 
var myVar : Int = 1

// Constant
val myConst : Int = 1

```

*Data Types*

- Long (64 Bit), Int (32 Bit), Short (16 Bit)
- Double (64 Bit), Float (32 Bit)
- Byte (8 Bit)
- Char, String (Immutable), CharSequence

```kotlin
// Strings
var s : String = "Hello"

val i : Int = 99
var s2 : String = "Johnny ${i}" // Johnny 99

val multiLine : String = """1st Line
2nd Line
3rd Line"""

// CharSequence
var cs : CharSequence = s.subsequence(0, 2) // = He
```

*Null safety*

```kotlin

var s : String = null  // Error
var s : String? = null // Okay

var i : Int? = s?.length // null if s is null

// Define optional value
var j : Int = i ?: 0 // 0 = default value

// Returns non-null value or throws exception
val l : b!!.length

// save downcasting with as?
s = "10"
var i = s as? CharSequence

```

*Type checking*

```kotlin
if (obj is String) {
    // do something with the string
}

```

*Loops*

```kotlin
// Iterate over collection
for (item in collection) { ...}

// Iterate over chars of string
for (c in "hello world") { ... }

// Iterate over range
for (i in 0..5) { ... }

// While loop
while (i > 0) { ... }

```

*Switch*

```kotlin

when (api) {
    in 1..13 -> ...
    24, 25 -> ...
    26 -> ...
    else -> ...
}

```

*Collections*

- [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/), [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/), [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/)
- [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/), [MutableSet](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/), [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/)

```kotlin
// MutableList
var stringList : MutableList<String> = mutableListOf("a","b","c")
stringList.add("d")     // ["a","b","c","d"]
stringList.removeAt(1)  // ["a","c","d"]

// MutableSet
var stringSet : MutableSet<String> = mutableSetOf("a","b","c")
stringSet.contains("d") // false
stringSet.remove("c")   // [a, b]

// MutableMap
var dict : MutableMap<String, Int> = mutableMapOf("A" to 1, "B" to 2)
dict["C"] = 3
dict.remove("A")
dict.keys             // [B, C]
dict.containsKey("B") // true

```

*Functions*

```kotlin
fun functionName(msg: String, ...) {
    ...
}
```

## Android

AndroidManifest.xml defines the name of the App as well as the main entry point, the icons, style and many other things.

### Activity and Fragment

TODO

### Components

- Button
- Textview
- EditText

TODO

### Android Intents and Intent filters

Used for switching between Activities. It can be used for numerous other things...

Intent to switch activity

```kotlin
val intent = Intent(this, DetailActivity::class.java)
//add some data
intent.putExtra(USERNAME, "peter.muster");

startActivity(intent)
```

Intent without result

```kotlin	
//add onClick listener for our button
binding.urlButton.setOnClickListener {
    // Implicit Intent by specifying a URL
    val i = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("http://www.tagesanzeiger.ch")
    )
    // Starts Implicit
    startActivity(i)
}
```
Intent with result

```kotlin
var resultLauncher = registerForActivityResult(
ActivityResultContracts.StartActivityForResult()) { result ->
    if (result.resultCode == Activity.RESULT_OK) {
        // There are no request codes
        val bitmap = result.data?.extras!!.get("data") as Bitmap
        print(bitmap.byteCount)
        binding.imageView.setImageBitmap(bitmap)
    }
}
```

### Fragments

Create fragment

```kotlin
//delete the autogenerated code and copy this code
//(change the name and add a package)
class NewFragment : Fragment() { //inherit from Fragment
    private var _binding: FragmentNewBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
        //adapt also this name (the class will be autogenerated)
        _binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View,savedInstanceState: Bundle?){
    super.onViewCreated(view, savedInstanceState)
}}

```

- Hostfragment
- Hostfragment Navigation

### App Bar

Typically an application shows an App Bar on top.

Add the following code to your activity_layout.xml

```xml
<!-- The AppBarLayout expects a Toolbar widget -->
<com.google.android.material.appbar.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/AppTheme.AppBarOverlay">
    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        app:popupTheme="@style/AppTheme.PopupOverlay" />
</com.google.android.material.appbar.AppBarLayout>

```

```kotlin
//register the toolbar as your app bar in your onCreate method
setSupportActionBar(binding.toolbar)
```

### Resources

All resources are placed in the /res folder.

*Icons* are added to the res/drawable folder. Use them in your xml

```xml
<android.support.design.widget.FloatingActionButton
    ...
    app:srcCompat="@drawable/ic_time_to_leave_black_24dp"
/>
```

*Localizations*
Language dependent strings can be moved to `values/strings.xml`.

```xml
<string name="authenticate_button_text">Anmelden</string>
```
Use these strings in your xml layout

```xml
<button android:text="@string/authenticate_button_text" ...>
```

### Constraint Layout

Position one view relative to another
```xml
<Button android:id="@+id/right_button" ...
    app:layout_constraintLeft_toRightOf="@+id/left_button" />
```

Center element

```xml
<!--This button will be centered vertically within its parent-->
<!--With contraintHorizontail_bias != 0 one side can be favored -->
<Button android:id="@+id/button" ...
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent" 
    app:layout_constraintHorizontal_bias="0.3" />
```

### View Chains

A chain is a series of views that are linked via double directional connections. A chain is either vertically or horizontally.

```xml
<!-- A chain with two buttons -->
<Button android:id="@+id/button1" ...
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="@id/button2" />
<Button android:id="@+id/button2" ...
    app:layout_constraintLeft_toLeftOf="@id/button1"
    app:layout_constraintRight_toRightOf="parent" />

<!--Set this attribute on your first view -->
app:layout_constraintHorizontal_chainStyle="packed"
```

### ListView

Android provides a list view
- All elements usually have the same layout
- a user can interact with the list elements
- The connection between the data and the view is done using an adapter
- The list elements can be layouted in xml (but there are adapters that already offer you a layout)

```xml
<!--Add a listview to your layout-->
<ListView
    android:id="@+id/user_list"
    android:layout_width="0dp"
    android:layout_height="0dp">
</ListView>
```

```kotlin
val data = mutableListOf("1. Element", "2. Element", "3. Element", "4. Element")
val adapter : ArrayAdapter<String> = ArrayAdapter<String>(baseContext,android.R.layout.simple_list_item_1, android.R.id.text1, data);
user_list.adapter = adapter
```

```kotlin
//you can use a class to store your model
class Person(val name: String, val street : String) {}
```


```kotlin
class PersonAdapter(var persons: MutableList<Person>,
    val context : Context) : BaseAdapter() {
        var layoutInflater : LayoutInflater
        private var _binding: PersonCellBinding? = null
        private val binding get() = _binding!!
        private var bindings = mutableMapOf<View,PersonCellBinding>()
        init {
        layoutInflater = LayoutInflater.from(context)
    }
    override fun getCount(): Int { //number of elements to display
        return persons.size}
    override fun getItem(index: Int): Person { //item at index
        return persons.get(index)}
    override fun getItemId(index: Int): Long { //itemId for index
        return index.toLong()

    override fun getView(index: Int, oldView: View?, viewGroup: ViewGroup?): View {
        var view : View
        if (oldView == null) { //check if we get a view to recycle
            _binding = PersonCellBinding.inflate(layoutInflater,
            viewGroup, false)
            view = binding.root;bindings[binding.root] = binding
        }
        else { //if yes, use the oldview
            view = oldView
            _binding = bindings[view]
        }
        val person = getItem(index) //get the data for this index
        binding.name.text = person.name
        binding.street.text = person.street
        return view
    }

}

```
### RecyclerView

- The `RecyclerView` works in a similar way to ListView.
- It has been introduced with Material Design and provides some optimizations.
- Using a `RecyclerView` is a bit more complex as you need to define a holder class.

```xml
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/recyclerView"
    android:layout_width="0dp"
    android:layout_height="0dp" />
```

```kotlin
//create the data to display
class Person(val name: String, val street : String) {}
val data = mutableListOf(Person(name="Peter Muster", street="Musterstrasse 1"),...)

//add the adapter
recyclerView.adapter = PersonAdapter(data)

//and a layout manager (needed!). This layout defines the
//positioning of the cells
recyclerView.layoutManager = LinearLayoutManager(requireContext())
```

```kotlin
class PersonViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.person_cell,
parent, false)) {
    private var nameView: TextView? = null
    private var streetView: TextView? = null
    init {
        nameView = itemView.findViewById(R.id.name)
        streetView = itemView.findViewById(R.id.street)
    }
    fun bind(person: Person) {
        nameView?.text = person.name
        streetView?.text = person.street
    }
}
```

```kotlin
//now the adapter
class PersonAdapter(private val list : List<Person>)
: RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PersonViewHolder(inflater, parent)
    }
    override fun onBindViewHolder(holder: PersonViewHolder,
    position: Int) {
        val movie: Person = list[position]
        holder.bind(movie)
    }
    override fun getItemCount(): Int = list.size
}
```

```xml
<!-- Finally, the cell layout -->
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">
    <TextView
        android:id="@+id/name"
        ...></TextView>
    <TextView
        android:id="@+id/street"
        ...></TextView>
```

TODO

### Klaxon

### Server Calls

In order to retrieve data from a server, you need to have Internet permission. This is added in your manifest file:

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="zhaw.ch.gsontest">
    <uses-permission android:name="android.permission.INTERNET" />
    <application ...
</manifest>
```
### Permissions

- All permissions need an entry in the manifest
- TODO normal vs dangerous permissions

```kotlin
val permissionLauncher = registerForActivityResult(
ActivityResultContracts.RequestPermission()){
    if (it) {
        readContacts()
    } else {
        //show error message...
    }
}
```

```kotlin
binding.buttonFirst.setOnClickListener {
    permissionLauncher.launch(Manifest.permission.READ_CONTACTS)
}
```

### File sharing

### ViewModel

- Android supports the MVVM pattern: A ViewModel connects the View with the model.
- The ViewModel can restore and save state as well as react on lifecycle events.
- Make sure that you never reference UI components in a ViewModel.

```kotlin
//Create a ViewModel for storing the name
class UserDataViewModel() : ViewModel() {
    var name = MutableLiveData<String>()
    init {
        name.value = "Peter Muster"
    }
}
```

```kotlin
//Use the ViewModel in a Fragment
val model: UserDataViewModel by activityViewModels()
model.name.observe(viewLifecycleOwner, Observer<String>{newVal ->
    // update UI
    binding.textviewFirst.text = newVal
})
//whenever the name changes, the UI will be updated
//automatically
model.name.value = "Paul Muster" //will update the UI
```

The ViewModel instance is stored in the activity and can be retrieved using "activityViewModels()"

```kotlin
override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
        R.id.action_settings -> {
            val model: UserDataViewModel by viewModels()
            Log.i("TAG", "${model.name}") //"Peter Muster"
            true 
        }
    }
}
```

### ViewModel delegate

- A delegate handles the request of an assigned object see (here)[https://kotlinlang.org/docs/delegated-properties.html]
- it is a class that needs to define the methods `getValue()` and `setValue`.
- it is automatically called whenever p is accessed

```kotlin
import kotlin.reflect.KProperty
class Example {
    var p1: String by Delegate()} //a delegate example
class Delegate {
    operator fun getValue(thisRef: Any?,
    property: KProperty<*>): String {
        return "${thisRef} ${property.name}"}
    operator fun setValue(thisRef: Any?,
    property: KProperty<*>, value: String) {
        println("$value, assigned to '${property.name}' in $thisRef")}}
@Test
fun delegateTest() {
    val e = Example()
    e.p1 = "Hallo Welt" //will print Hallo Welt, assigned to 'p1' in
    //ExampleUnitTest$Example@5a42bbf4
    print(e.p1) } // will print ExampleUnitTest$Example@5a42bbf4 p1
```

```kotlin
//the following definition
val model: UserDataViewModel by viewModels()
//will in fact call the method "viewModels":
inline fun <reified VM : ViewModel> ComponentActivity.viewModels(
    noinline factoryProducer: (() -> Factory)? = null): Lazy<VM> {
    //create a default factory if the parameter is null
    val factoryPromise = factoryProducer ?: {
        defaultViewModelProviderFactory
    }
    //return the ViewModel (Note the viewModelStore reference. This
    //returns a store that's created as an activity's member variable:
    //private ViewModelStore mViewModelStore)
    return ViewModelLazy(VM::class, { viewModelStore }, factoryPromise)
}
```

### LiveData

LiveData propagates changes from the model to the view. LiveData provides the "observe-interface". By registering an Observer instance a view can be informed when the data changes.

```kotlin
model.name.observe(this, Observer<String>{
    // update UI
    nameTextView.text = model.name
})
```

It's lifecycle-aware, it doesn't push changes if the observer is not in an active state.

The subscription will automatically be removed when the component is destroyed. There is no need to unregister.

Due to the lifecycle-aware feature, a recreated component will automatically receive the newest data.

When using LiveData with a ListView adapter, observe is:
- not called when the content of a collection changes
- called when a new List is assigned to the model value

```kotlin
//init the adapter with an empty list
adapter = ArrayAdapter<Person>(..., mutableListOf<Person>())
...
model.persons.observe(viewLifecycleOwner,
    //note that the observer sends the new value as parameter
    Observer<MutableList<Person>>{ newVal ->
    adapter?.clear()
    adapter?.addAll(newVal) //addAll will call notifyDatasetChanged
})
... //this changing will call the observer
persons.value = mutableListOf<Person>()
```

### Lazy Initialization

In the example the observed model was statically initialized with a literal:

```kotlin
var name = MutableLiveData<String>()
init {
    name.value = "Peter Muster"
}
```

- In practice it is often needed to move the initialization to a later point in time. This can be accomplished by an optional value. Another option is the lazy initialization.

Lazy initialization has a number of advantages:

- no optional attribute
- no initialization until the data is really needed
- no initialization if the data is already is not needed at all

```kotlin
// optional value
var name : MutableLiveData<String>? = null

// lazy method
val name : MutableLiveData<String> by lazy {
    loadName() //will be called when name is first accessed
}
```

### Persistence

The easiest way to store data locally is by using SharedPreferences:

```kotlin
val settings = context.getSharedPreferences("prefsfile", Context.MODE_PRIVATE)
//it is important that you get an editor reference!
val editor = settings.edit()
//save strings, booleans, floats, ints, longs, stringsets
editor.putString("USER_NAME", "john.ford@hollywood.com")
//and commit your changes
editor.commit()
```

Reading preferences is a two liner:

```kotlin
val settings = getSharedPreferences("prefsfile", Context.MODE_PRIVATE)
val defaultUser = settings.getString("USER_NAME", "no-user@no-domain.com")
```

### Database attachement

__SQLLite__

SQLLite is an SQL database deveoped for smaller devices/scenarios:

- It only needs one file to store the data
- It is self-contained and serverless
- It supports transactions
...

Google recommends to use the library Room for accessing SQLLite.

```gradle
plugins {
    ...
    id 'kotlin-kapt'
}
...
dependencies {...
    def room_version = "2.4.3"
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
}
```

```kotlin
@Entity
class Person(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)
```

```kotlin
//DAO: Database Access Object
@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAll(): List<Person>
    
    @Query("SELECT * FROM person WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Person>
    
    @Query("SELECT * FROM person WHERE first_name IN (:names)")
    fun loadAllByFirstName(names: List<String>): List<Person>
    
    @Query("SELECT * FROM person WHERE first_name LIKE :first AND " +
    "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Person
    
    @Insert
    fun insertAll(vararg persons: Person)
    
    @Delete
    fun delete(person: Person)
}

```

```kotlin
@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false) 
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}
```

```kotlin
val db = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java,
    "database-name"
).build()
```

### Coroutines

It is not allowed to access the database in the main thread (same goes for internet connections). Coroutines solve this task in a more elegant way than AsyncTasks.

Add the following lines to `build.gradle`:

```gradle
def lifecycle_version = "2.5.1"
implementation 
    "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"
```

```kotlin
suspend fun insertUsers() {
    db?.personDao()?.insertAll(
    Person(firstName="Peter", lastName="Muster"),
    Person(firstName="Paul", lastName="Muster"))
}
suspend fun readUsers() {
    //we are in a background thread and need to call postValue
    persons.postValue(db?.personDao()?.getAll()?.toMutableList())
}
```

```kotlin
//lifecycleScope is an attribute from the Activity/Fragment
//Note that you need to define the default dispatcher explicitly
//otherwise the method will be called on the main thread
lifecycleScope.launchWhenStarted {
    withContext(Dispatchers.Default) {
        model.insertUsers()
    }
}
//readData is now executed in a different thread and won't block
//the main ui thread

```

## Android Services

- The Play service is executed as background task.
- New service versions are delivered by the Play Store. This ensures that the newest version is available.

### Setup
Add the desired service to your `build.gradle`
```gradle
implementation 'com.google.android.gms:play-services-vision:11.
```

Check if the service is available: 

```kotlin
val googleAPI = GoogleApiAvailability.getInstance()
val isAvailable = googleAPI.isGooglePlayServicesAvailable(applicationContext)
if (isAvailable != ConnectionResult.SUCCESS) {
    //show an error message if it is not available
}
```

Use the service client API.

__Barcode Example__

```kotlin
//CAMERA permission is needed!
val detector = BarcodeDetector.Builder(activity.applicationContext)
    .setBarcodeFormats(Barcode.EAN_13)
    //Barcode.DATA_MATRIX | Barcode.QR_CODE)
    .build()
val cameraSource = CameraSource.Builder(activity.applicationContext, detector)
    .setFacing(CameraSource.CAMERA_FACING_BACK)
    .setRequestedFps(15.0f)
    .setAutoFocusEnabled(true)
    .build()
if (!detector.isOperational) {
    return "Could not set up the detector!"
}
```

```kotlin
detector.setProcessor(object : Detector.Processor<Barcode> {
    override fun release() {}
    override fun receiveDetections(detections: Detections<Barcode>) {
    if (detections.detectedItems.size() > 0) {
        val barcode = detections.detectedItems.valueAt(0)
        val value = barcode.rawValue
        Log.i("MainActivity", "found barcode: $value")
        activity.runOnUiThread { //stop the camera
            cameraSource.stop()
            Log.i("MainActivity", "camera stopped")
        }
        } else {
            Log.i("MainActivity", , "scanning...")
        }
    }
})
```

__Android Activity Recognition__

- Recognizes the user's activity changes
- Uses device sensors to detect activity. The data is processed using machine learning models.
- Provides two different APIs: The Activity Recognition Transition API and the Activity Recognition Sample API.

__Setup__

Gradle:
```gradle
    implementation 'com.google.android.gms:play-services-location:
```

Add the needed permission
```
= API 28:
com.google.android.gms.permission.ACTIVITY_RECOGNITION
> API 28:
android.permission.ACTIVITY_RECOGNITION
```
Check if the service is available
```kotlin
val googleAPI = GoogleApiAvailability.getInstance()
val isAvailable = googleAPI.isGooglePlayServicesAvailable(applicationContext)
if (isAvailable != ConnectionResult.SUCCESS) {
    //show an error message if it is not available
}

```

```kotlin
//store the client as member variable so that it won't be deleted
activityRecognitionClient = ActivityRecognition.getClient(context)
//create a request by specifying all transitions (next slide)
val request = ActivityTransitionRequest(createAcitivtyTransitions())
//create an Intent and set a unique action
//string (RECOGNITION_ACTION)
val intent = Intent("RECOGNITION_ACTION")
//start the recognition
val task = activityRecognitionClient?.requestActivityUpdates(0,
PendingIntent.getBroadcast(context, 0, intent, 0)
```

```kotlin
fun createAcitivtyTransitions() : MutableList<ActivityTransition> {
    val transitions = mutableListOf<ActivityTransition>()
    transitions += ActivityTransition.Builder()
        .setActivityType(DetectedActivity.IN_VEHICLE)
        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
        .build()
    transitions += ActivityTransition.Builder()
        .setActivityType(DetectedActivity.IN_VEHICLE)
        .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
        .build()
    return transitions
}
```

__Retrieve Recognitions__

- The service will send an intent to the app. Therefore, a `BroadcastReceiver`is needed to retrieve the intent.
- The `BroadcastReceiver` has to implementat the `onReceive`method.

```kotlin
class MyBroadcastReceiver() : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent != null && intent.getAction() == "RECOGNITION_ACTION") {
            if (ActivityRecognitionResult.hasResult(intent)) {
                val intentResult = ActivityRecognitionResult.extractResult(intent);
                val detectedActivity = intentResult?.mostProbableActivity
                //do something
}}}
```

```kotlin
//finally, register the broadcast receiver
val intentFilter = IntentFilter("RECOGNITION_ACTION")
broadcastReceiver = MyBroadcastReceiver(logger)
context.registerReceiver(broadcastReceiver, intentFilter)
```

## Beacons

## Mobile Web

### Overview and Basics

### Style and Layout

### Device APIs, Cordova/Capacitor
