# EasyAdapter
Android 通用适配器，适用于AbsLisViewt 和 RecyclerView.

Dependencies
```
// Not include recyclerview-v7,you should add the dependence of recyclerview-v7 in your modules.
implementation 'com.muse.easy.adapter:easy-adapter:1.0.0'
```

# Usage
+ The usage of AbsListView
   - step 1
   ```
   public class MyListAdapter extends BaseListViewAdapter<HomeItem> {
    public MyListAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    public void convert(BaseListViewHolder holder, int position, HomeItem homeItem) {
        holder.setText(R.id.content, homeItem.getContent());
        holder.setImageResource(R.id.icon, homeItem.getResId());
        holder.addOnClickListener(R.id.list_item);
    }
   }

   ```
   - step 2
   ```
    getHomeItems();
    MyListAdapter adapter = new MyListAdapter(R.layout.item_home, homeItems);
    adapter.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(ListTestActivity.this, "Click " + position, Toast.LENGTH_SHORT).show();
        }
    });

    mListView.setAdapter(adapter);
   ```
   
+ The usage of RecyclerView
   - step 1
   ```
   public class MyRecyclerViewAdapter extends BaseRecyclerViewAdapter<HomeItem> {


    public MyRecyclerViewAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseRecyclerViewHolder holder, HomeItem homeItem) {
        holder.setText(R.id.content, homeItem.getContent());
        holder.setImageResource(R.id.icon, homeItem.getResId());
        holder.addOnClickListener(R.id.list_item);
    }
   }
   
   ```
   - step 2
   ```
    getHomeItems();
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(R.layout.item_home, homeItems);
    adapter.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(RecyclerViewTestActivity.this, "Click " + position, Toast.LENGTH_SHORT).show();
        }
    });

    mRecyclerView.setAdapter(adapter);
   ```
