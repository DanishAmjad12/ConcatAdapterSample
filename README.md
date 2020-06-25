# MergeAdapterSample
🛠 Implement multiple views in one recyclerView with MergeAdapter 

# Demo
![](result.gif)

# Description

In this Project I have a three sectoins.

* Top My Profile Section
* User Sections
* Banner Section.

# Note

* Currently the library is in the aplha channel

# Steps to Implement this

Add a dependency first for recyclerview
``` Java
implementation "androidx.recyclerview:recyclerview:1.2.0-alpha02"
```

* Create modles for every section.

* Create every section adapter with their layouts.

* Then In your mainActivity just create every adapter Instance also create a Instance for MergeAdapter and pass it to the recyclerView

# My Profile Section Adapter

``` Kotlin
class MyDetailAdapter(
    private val myDetail: MyDetail
) : RecyclerView.Adapter<MyDetailAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myDetail: MyDetail) {

            itemView.textViewUser.text = myDetail.name
            itemView.textViewEducation.text = myDetail.jobTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_my_detail, parent,
                false
            )
        )

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(myDetail)

}
```
# User Adapter

``` Kotlin
class UserAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<UserAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {

            itemView.textViewUserName.text = user.name

            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_user, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

}
```

# Banner Adapter

``` Kotlin
class FooterAdapter(
    private val footer: Footer
) : RecyclerView.Adapter<FooterAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(footer: Footer) {

            Glide.with(itemView.imageViewFooter.context)
                .load(footer.footerImage)
                .into(itemView.imageViewFooter)
            
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_footer, parent,
                false
            )
        )

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(footer)

}
```
# Main Activity class

``` Kotlin
class MainActivity : AppCompatActivity() {

    lateinit var adapter: MergeAdapter
    lateinit var myDetailAdapter: MyDetailAdapter
    lateinit var userAdapter: UserAdapter
    lateinit var footerAdapter: FooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataInRecyclerView()

    }

    private fun setDataInRecyclerView() {
        val userDetail = MyDetail(1, "Danish Amjad", "Software Engineer Android Developer")
        recycler.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(DataSource.getUser())
        footerAdapter = FooterAdapter(DataSource.getFooter())
        myDetailAdapter = MyDetailAdapter(userDetail)
        adapter = MergeAdapter(myDetailAdapter,  userAdapter,footerAdapter)
        recycler.adapter = adapter
    }
}
```

# For Image Downloading I Used Glide

``` Java
implementation 'com.github.bumptech.glide:glide:4.11.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
```

# Licence
Copyright 2020 Danish Amjad

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
