# Android Simple Adapter
[![License](https://img.shields.io/hexpm/l/plug.svg)]()

This is Android Simple Adapter library.
Only kotlin library.

- SimpleBaseAdapter : Abstract BaseAdapter
- DataBinding : SimpleBaseAdapter can be used by extension library.
- ViewBinding : SimpleBaseAdapter can be used by extension library.

## Library version

It can be used jcenter(), as follows

### SimpleBaseAdapter - DataBinding

add Android DataBinding library and dependency

[ ![Download](https://api.bintray.com/packages/taehwandev/thdev.tech/simple-adapter/images/download.svg) ](https://bintray.com/taehwandev/thdev.tech/simple-adapter/_latestVersion)
[ ![Download](https://api.bintray.com/packages/taehwandev/thdev.tech/simple-adapter-databinding/images/download.svg) ](https://bintray.com/taehwandev/thdev.tech/simple-adapter-databinding/_latestVersion)

```
plugins {
    id 'kotlin-android'
    id 'kotlin-kapt'
}

dataBinding {
    enabled = true
}

dependencies {
    implementation "tech.thdev.recyclerview:simple-adapter:$lastVersion"
    implementation "tech.thdev.recyclerview:simple-adapter-databinding:$lastVersion"
}
```

#### Use DataBinding

Inherit SimpleDataBindingAdapterControl and use as below.

onCreateViewHolder, onCreateItems init.

setItem can set data class and ViewModel in group type.

```kotlin
class SimpleAdapterDataBindingSampleAdapterControl :
    SimpleDataBindingAdapterControl<AdapterDataBindingItemGroup>() {

    /**
     * CreateItem is parentView, viewType support.
     */
    override fun SimpleDataBindingAdapterCreateItem.onCreateViewHolder(): SimpleDataBindingViewHolder {
        return when (viewType) {
            else -> createDataBindingHolder(R.layout.item_data_binding_text_view)
        }
    }

    /**
     * add Item and ViewModel
     */
    override fun SimpleDataBindingAdapter.onCreateItems(
        item: AdapterDataBindingItemGroup,
        viewModel: ViewModel?
    ) {
        val startPosition = getItemSize()
        var newItem = 0
        // AddItem.
        item.itemList.forEach {
            newItem++
            addItem(0, it, viewModel)
        }
        notifyItemRangeInserted(startPosition, newItem)
    }
}

data class AdapterDataBindingItemGroup(
    val itemList: List<AdapterDataBindingItem>
)

data class AdapterDataBindingItem(
    val index: Int
)
```

### SimpleBaseAdapter - ViewBinding

add Android viewBinding library and dependency

[ ![Download](https://api.bintray.com/packages/taehwandev/thdev.tech/simple-adapter/images/download.svg) ](https://bintray.com/taehwandev/thdev.tech/simple-adapter/_latestVersion)
[ ![Download](https://api.bintray.com/packages/taehwandev/thdev.tech/simple-adapter-viewbinding/images/download.svg) ](https://bintray.com/taehwandev/thdev.tech/simple-adapter-viewbinding/_latestVersion)

```
plugins {
    id 'kotlin-android'
    id 'kotlin-kapt'
}

viewBinding {
    enabled = true
}

dependencies {
    implementation "tech.thdev.recyclerview:simple-adapter:$lastVersion"
    implementation "tech.thdev.recyclerview:simple-adapter-viewbinding:$lastVersion"
}
```

#### Use ViewBinding.

Inherit SimpleViewBindingAdapterControl and use as below.

onCreateViewHolder, setItem init. setItem should be used in group form.

```kotlin
class SimpleAdapterControlSampleAdapterControl(
    private val onClick: (item: Int) -> Unit
) : SimpleViewBindingAdapterControl<AdapterItemGroup>() {

    override fun SimpleViewBindingAdapterCreateItem.onCreateViewHolder(): SimpleViewBindingViewHolder<*, *> =
        createViewBindingHolder<ItemTextViewBinding, Int> { item ->
            textView.text = "Message $item"
            root.setOnClickListener {
                onClick(item)
            }
        }

    override fun setItem(item: AdapterItemGroup) {
        item.itemList.forEach {
            adapter.addItem(0, it)
        }
    }
}

data class AdapterItemGroup(
    val itemList: List<Int>
)
```

!!!! caution! There are two createViewBindingHolder extensions. When using the following code, use reflection because it uses reflection.

```kotlin
inline fun <reified BINDING : ViewBinding, reified ITEM : Any> SimpleViewBindingAdapterCreateItem.createViewBindingHolder(
    noinline onBindViewHolder: BINDING.(item: ITEM) -> Unit
): SimpleViewBindingViewHolder<BINDING, ITEM> {
    val method = BINDING::class.java.getDeclaredMethod(
        "inflate",
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    )
    val newBinding = method.invoke(
        null,
        LayoutInflater.from(parent.context),
        parent,
        false
    ) as BINDING

    // ...
}

inline fun <reified BINDING : ViewBinding, reified ITEM : Any> SimpleViewBindingAdapterCreateItem.createViewBindingHolder(
    viewBinding: BINDING,
    noinline onBindViewHolder: BINDING.(item: ITEM) -> Unit
): SimpleViewBindingViewHolder<BINDING, ITEM> =
    // ...
```

## License

```
Copyright 2020 Tae-hwan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
