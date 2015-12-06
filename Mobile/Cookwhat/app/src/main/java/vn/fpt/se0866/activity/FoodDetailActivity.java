package vn.fpt.se0866.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import vn.fpt.se0866.manager.FoodManager;
import vn.fpt.se0866.model.Food;

public class FoodDetailActivity extends AppCompatActivity {
    private FoodManager manager;
    private String htmlDummy = "<div class=\"instructions\">\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 1 :</strong></span></p>\n" +
            " <p>- Xương ống sau khi mua về bạn chặt thành từng miếng &nbsp;vừa ăn và rửa sạch, rồi cho vào nồi nước đã hoà tan một chút muối trong đó, bạn đun trong 2 phút rồi đổ nước luộc đó đi. Đây là bước làm để lọc bỏ đi những chất bẩn trong xương.</p>\n" +
            " <p>- Bạn cho xương vào nước lạnh rửa sạch để loại đi chất bẩn và mùi hôi, sau đó tiếp tục cho vào nồi đun sôi để lấy nước dùng cho món lẩu.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-1.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16925\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 1\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-1.jpg\" width=\"500\" height=\"397\"></a></p>\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 2 :</strong></span></p>\n" +
            " <p>- Cá khoai sau khi mua về, bạn làm sạch và ngâm với muối trong thời gian là 30 phút để cho cá khi chúng ta chế biến không bị nát.</p>\n" +
            " <p>- Hết 30 phút, bạn vớt cá khoai ra rổ và để cho cá ráo nước sau đó cắt cá khoai thành 2 phần và để vào một cái đĩa.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-2.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16926\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 2\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-2.jpg\" width=\"500\" height=\"500\"></a></p>\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 3 :</strong></span></p>\n" +
            " <p>- Ở bước này chúng ta sẽ tiến hành làm mực. Mực tươi bạn cũng làm sạch, cho mực ngâm với rượu trắng trong khoảng thời gian 15-20 phút để cho cá bớt mùi tanh, rồi vớt ra rổ, để cho ráo.</p>\n" +
            " <p>- Sau đó bạn cắt mực tươi thành từng miếng và bày lên trên đĩa.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-3.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16927\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 3\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-3.jpg\" width=\"500\" height=\"331\"></a></p>\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 4 :</strong></span></p>\n" +
            " <p>- Với các loại rau để nhúng lẩu bạn có rất nhiều lựa chọn, bạn có thể dùng rau cần, rau cải cúc, lá ngải (ngải cứu), cải thảo, rau cải canh, cải thìa,...Nhưng loại rau nhúng lẩu mà theo cách ăn lẩu cá khoai của người Vũng Tàu đó là rau cải mầm.</p>\n" +
            " <p>- Rau bạn nhặt sạch và rửa sạch với nước, tiếp đó cho rau vào ngâm nước muối trong 20 phút cho rau thật sạch. Hết thời gian bạn vớt rau cải mầm ra rổ, để cho ráo. Khi ăn thì bày rau ra đĩa để nhúng lẩu.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-4.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16928\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 4\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-4.jpg\" width=\"500\" height=\"360\"></a></p>\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 5 :</strong></span></p>\n" +
            " <p>- Hành lá và thì là bạn nhặt bỏ hết rễ, những hành lá bị úa, lá bẩn dính vào, rửa sạch với nước sau đó chia một nửa số hành lá và thì là. Một nửa bạn xắt khúc, xắt thành 2- 3 khúc ; một nửa bạn thái nhỏ.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-5.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16929\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 5\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-5.jpg\" width=\"500\" height=\"512\"></a></p>\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 6 :</strong></span></p>\n" +
            " <p>- Cà chua bạn rửa sạch và thái thành hình những múi cau.</p>\n" +
            " <p>- Hành khô bóc bỏ vỏ,rửa sạch sau đó đập dập và băm nhuyễn ra.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-6.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16930\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 6\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-6.jpg\" width=\"500\" height=\"391\"></a></p>\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 7 :</strong></span></p>\n" +
            " <p>- Đối với me bạn ngâm trong nước nóng khoảng 5 phút cho mềm và dùng rây dầm lấy phần thịt me.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-7.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16931\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 7\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-7.jpg\" width=\"500\" height=\"521\"></a></p>\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 8 :</strong></span></p>\n" +
            " <p>- Bạn cho nồi lên bếp, đợi chảo nóng bạn cho 2 thìa dầu ăn vào. Khi dầu ăn nóng thì bạn cho hành khô đã băm nhuyễn vào phi thơm lên, tiếp đến là cho những múi cà chua vào, đảo đều, xào chín.</p>\n" +
            " <p>- Khi cà chua chín mềm, bạn cho nước xương ống đã ninh sôi trước đó vào nồi, đun sôi. Khi nước sôi bạn cho gia vị gồm mì chính, nước mắm, hạt nêm và phần thịt me, cùng với một chút ớt; nếm sao cho nước dùng có vị chua chua cay cay thì tắt bếp.</p>\n" +
            " <p>- Công đoạn chế biến nước nhúng lẩu đã xong, bạn cho nồi lên bếp lẩu và cho thêm hành lá và thì là đã xắt nhỏ vào nồi.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-8.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16932\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 8\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-8.jpg\" width=\"500\" height=\"362\"></a></p>\n" +
            " <p><span style=\"text-decoration: underline;\"><strong>Bước 9 :</strong></span></p>\n" +
            " <p>- Khi ăn bạn chuẩn bị những nguyên liệu để nhúng lẩu gồm : cá khoai, mực tươi, hành lá, thì lá xắt khúc, rau nhúng lẩu, nước mắm ớt vào bàn ăn.</p>\n" +
            " <p>- Đặt nồi lẩu ở giữa, khi thấy nước dùng sôi thì bạn cho cá và mực vào, đậy nắp, chờ nước sôi lần hai, cho rau vào nhúng chín và ăn là được.</p>\n" +
            " <p>- Bạn có thể cho thêm nấm kim châm, nấm hương, đậu phụ vào lẩu cùng để tăng thêm hương vị, ngoài ra chấm cá với tương hay tương ớt hay nước mắm ớt đều ngon cả.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-9.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16933\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời 9\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-buoc-9.jpg\" width=\"500\" height=\"442\"></a></p>\n" +
            " <p>Lẩu cá khoai sẽ cho bạn thưởng thức thịt cá khoai chín mềm, trong suốt, tan trên đầu lưỡi khi ăn, chưa hết còn có vị ngọt thanh của mực tươi, vị chua chua cay cay của me và ớt hoà quyện tạo nên một hương vị hấp dẫn khó quên.</p>\n" +
            " <p><a href=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-ket-qua.jpg\" rel=\"prettyPhoto[slides]\"><img class=\"aligncenter size-full wp-image-16934\" alt=\"Chào thu với món lẩu cá khoai thơm ngon tuyệt vời kết quả\" src=\"http://sotaynauan.com/wp-content/uploads/2015/09/chao-thu-voi-mon-lau-ca-khoai-thom-ngon-tuyet-voi-ket-qua.jpg\" width=\"500\" height=\"498\"></a></p>\n" +
            " <p>Chúc các bạn thành công và ngon miệng với món lẩu cá khoai này nhé!</p>\n" +
            "</div>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        manager = new FoodManager(this);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //get data
        Intent intent = getIntent();
        final Food food = (Food) intent.getSerializableExtra(SearchResultActivity.DATA_EXCHANGE_OBJECT);

        //load view
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(food.getFoodName());
        //TextView tvDetail = (TextView) findViewById(R.id.food_detail_tv);
        //tvDetail.setText(food.getDescription());
        WebView wvDetail = (WebView) findViewById(R.id.food_detail_wv);
        wvDetail.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        wvDetail.loadDataWithBaseURL(null, "<style>img{display: inline;height: auto;max-width: 100%;}</style>" + htmlDummy, "text/html", "UTF-8", null);
        wvDetail.getSettings().setLoadWithOverviewMode(true);
        wvDetail.getSettings().setUseWideViewPort(true);
        ImageView cover = (ImageView) findViewById(R.id.food_detail_cover_iv);
        Picasso.with(this).load(food.getAvatarLink()).placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(cover);

        //set bookmark
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (checkBookmarked(food)){
            fab.setTag(R.drawable.ic_star_yellow);
            fab.setImageResource(R.drawable.ic_star_yellow);
        }
        else fab.setTag(R.drawable.ic_star);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fabResourceId = (int) fab.getTag();
                if (fabResourceId == R.drawable.ic_star) {
                    fab.setImageResource(R.drawable.ic_star_yellow);
                    fab.setTag(R.drawable.ic_star_yellow);
                    manager.insert(food);
                }else {
                    fab.setImageResource(R.drawable.ic_star);
                    fab.setTag(R.drawable.ic_star);
                    manager.deleteById(food.getFoodId());
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private boolean checkBookmarked(Food f) {
        Food temp = manager.getById(f.getFoodId());

        return (temp != null) ? true : false;
    }
}
