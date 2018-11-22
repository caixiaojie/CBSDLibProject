package com.example.cbsdlib.ui.fragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.cbsdlib.R;
import com.example.cbsdlib.ui.adapters.MultiItemTypeAdapter;
import com.example.cbsdlib.ui.adapters.wrapper.EmptyWrapper;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *created by Damon on 2017/6/19 11:25
 *
 *description: 
 *
 */
public abstract class BaseRefreshLoadingFragment<T> extends BaseFragment implements SwipeRefreshHelper.OnSwipeRefreshListener,
        OnLoadMoreListener, RecyclerAdapterWithHF.OnItemClickListener {
    protected int FIRST_PAGE = 0;
    protected SwipeRefreshHelper mSwipeRefreshHelper;
    protected SwipeRefreshLayout mLayoutRefresh;
    protected RecyclerView mRecyclerView;

    protected List<T> mItems = new ArrayList<>();
    protected MultiItemTypeAdapter<T> mInnerAdapter;
    protected EmptyWrapper<T> mEmptyWrapper;
    protected RecyclerAdapterWithHF mAdapter;

    protected RecyclerView.LayoutManager mLayoutManager;
    protected int mCurrPage = FIRST_PAGE;




    @Override
    public void init(View rootView) {
        mLayoutRefresh = (SwipeRefreshLayout)rootView.findViewById(R.id.pre_refresh);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.pre_recycler_view);
        mLayoutRefresh.setColorSchemeResources(R.color.colorAccent);
        setupRecyclerView();
        setupRefreshAndLoadMore();
    }

    private void setupRecyclerView() {
        mRecyclerView.setLayoutManager(initLayoutManager());
        mRecyclerView.setAdapter(initAdapter());
        mAdapter.setOnItemClickListener(this);
        if (isShowDivider()) setDivider();
    }


    protected void setDivider() {
        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity())
                .color(getResources().getColor(R.color.black_divider))
                .sizeResId(R.dimen.spacing_divider)
                .build());
    }

    protected boolean isShowDivider() {
        return true;
    }

    protected RecyclerView.LayoutManager initLayoutManager() {
        mLayoutManager = getLayoutManager();
        return mLayoutManager;
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    private RecyclerAdapterWithHF initAdapter() {
        mInnerAdapter = getAdapter();
        mEmptyWrapper = new EmptyWrapper<>(mInnerAdapter);
        mEmptyWrapper.setEmptyView(getEmptyViewId());
        mEmptyWrapper.setIsLoading(true);
        mAdapter = new RecyclerAdapterWithHF(mEmptyWrapper);
        return mAdapter;
    }

    protected int getEmptyViewId() {
        return R.layout.ui_layout_empty;
    }

    private void setupRefreshAndLoadMore() {
        mSwipeRefreshHelper = new SwipeRefreshHelper(mLayoutRefresh);
        mSwipeRefreshHelper.setOnSwipeRefreshListener(this);
        mSwipeRefreshHelper.setOnLoadMoreListener(this);

        autoRefresh();
    }

    protected void autoRefresh() {
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshHelper.autoRefresh();
            }
        }, 100);
    }

    @Override
    public void onfresh() {
        mCurrPage = FIRST_PAGE;
        mEmptyWrapper.setIsLoading(true);
        loadData(mCurrPage);
    }

    @Override
    public void loadMore() {
        mEmptyWrapper.setIsLoading(true);
        loadData(++mCurrPage);
    }

    protected void refreshComplete(boolean loadSuccess) {
        mEmptyWrapper.setIsLoading(false);
        if (!loadSuccess && mCurrPage > FIRST_PAGE) {
            mCurrPage--;
        }
        mAdapter.notifyDataSetChanged();
        mSwipeRefreshHelper.refreshComplete();
        mSwipeRefreshHelper.setLoadMoreEnable(loadSuccess && mItems.size() >= 10 && (mItems.size() %10 ==0));
        if (mCurrPage > FIRST_PAGE) {
            mSwipeRefreshHelper.loadMoreComplete(true);
        }
    }

    @Override
    public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
//        Logger.d(position);
    }

    protected abstract MultiItemTypeAdapter<T> getAdapter();

    protected abstract void loadData(int page);
}
