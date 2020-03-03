package com.utils.card;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utils.card.CardMenu.CardSwitchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡片Fragment
 *
 * @author xmuSistone
 */
@SuppressLint({"HandlerLeak", "NewApi", "InflateParams"})
public class CardFragment extends Fragment {

    private TextView mIndex;
    private CardSwitchListener cardSwitchListener;
    private String imagePaths[] = {
            "asset:///wall01.jpeg", "asset:///wall02.jpeg",
            "asset:///wall03.jpg", "asset:///wall04.jpg"}; //图片资源名称
    private List<CardBean> dataList = new ArrayList<CardBean>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_layout, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        mIndex= (TextView) rootView.findViewById(R.id.index);
        CardMenu slidePanel = (CardMenu) rootView
                .findViewById(R.id.image_slide_panel);
        cardSwitchListener = new CardSwitchListener() {
            @Override
            public void onShow(int index) {
                int temp=index%4;
                switch (temp){
                    case 0:
                        mIndex.setText("ANGELES y DEMONIOS");
                        break;
                    case 1:
                        mIndex.setText("THOR");
                        break;
                    case 2:
                        mIndex.setText("FAREWELL MY CONCUBINE THE BEIJING OPERA");
                        break;
                    case 3:
                        mIndex.setText("FIND YOUR BREAKING POINT");
                        break;

                }
            }

            @Override
            public void onCardVanish(int index, int type) {
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);

        prepareDataList();
        slidePanel.fillData(dataList);
    }

    private void prepareDataList() {
        int num = imagePaths.length;

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < num; i++) {
                CardBean dataItem = new CardBean();
                dataItem.imagePath = imagePaths[i];
                dataItem.likeNum = (int) (Math.random() * 10);
                dataItem.imageNum = (int) (Math.random() * 6);
                dataList.add(dataItem);
            }
        }
    }

}
