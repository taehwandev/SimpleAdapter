### Version 1.1.0 (2020. 05. 23)
- Add two bindViewHolder extension.
  - Experimentally added samples using reflection and ViewBinding.
  - There is no way to initialize ViewBinding yet and reflection call. is Deprecated ...
  - Bast use DataBinding.
- Default on ViewBinding.
```
add kotlin kapt

viewBinding {
    enabled = true
}
```
- Remove Android Kotlin extension.

### Version 1.0.0 (2020. 04. 10)
- New release