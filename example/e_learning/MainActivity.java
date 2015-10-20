package com.example.e_learning;

import java.util.ArrayList;

import com.example.database.*;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements OnClickListener {
	private ImageButton imgVol,imgExer;
	private MySQLiteOpenHelper database;
	private ArrayList<Vocabulary> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database=new MySQLiteOpenHelper(this);
		arr=database.getAllVol();
		imgVol=(ImageButton)findViewById(R.id.imgVol);
		imgVol.setOnClickListener(this);
		
		imgExer=(ImageButton)findViewById(R.id.imgExer);
		imgExer.setOnClickListener(this);
		if(arr.size()==0){
			addDatabase();
			
			
		}
    }
    
    @Override
	public void onClick(View v) {
		Intent intent =  new Intent();
		switch (v.getId()) {
		case R.id.imgVol:
		intent =  new Intent(MainActivity.this, vocabulary.class);
			startActivity(intent);
			finish();
			break;
		case R.id.imgExer:
			intent =  new Intent(MainActivity.this, exercise.class);
			startActivity(intent);
			finish();
			break;
		default:
			break;
			
		}
		
    }
    
    @Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
    
    
    void addDatabase(){
    	Vocabulary v1 =new Vocabulary("Lesson 1","abandon", "/ə'bændən/", "(v) bỏ, từ bỏ", "We had to abandon the car and walk the rest of the way.");
		Vocabulary v2 =new Vocabulary("Lesson 1","abandoned", "/ə'bændənd/", "(adj) bị bỏ rơi, bị ruồng bỏ", "He was abandoned by his mother as a baby.");
		Vocabulary v3 =new Vocabulary("Lesson 1","ability", "/ə'biliti/", "(n) khả năng, năng lực", "I have the ability to draw cartoons.");
		Vocabulary v4 =new Vocabulary("Lesson 1","able", "/'eibl/", "(adj) có năng lực, có tài", "He is able to come with me.");
		Vocabulary v5 =new Vocabulary("Lesson 1","about", "/ə'baut/", "(adv/prep) khoảng, về", "There's something nice about him");
		Vocabulary v6 =new Vocabulary("Lesson 1","above", "/ə'bʌv/", "(adv/prep) ở trên, lên trên", "They were all men of fifty and above");
		Vocabulary v7 =new Vocabulary("Lesson 1","abroad", "/ə'brɔ:d/", "(adv)ra nước ngoài", "These pornographic publications were brought from abroad");
		Vocabulary v8 =new Vocabulary("Lesson 1","absence", "/'æbsəns/", "(n) sự vắng mặt", "To carry out production in the absence of necessary machines");
		Vocabulary v9 =new Vocabulary("Lesson 1","absent", "/'æbsənt/", "(adj) vắng mặt, nghỉ", "He answers in an absent way");
		Vocabulary v10=new Vocabulary("Lesson 1","absolute", "/'æbsəlu:t/", "(adj) tuyệt đối, hoàn toàn", "She has an absolute evidence");
		Vocabulary v11=new Vocabulary("Lesson 2","back", "/bæk/", "(n/adj/adv/v) lưng, về phía sau, trở lại", "animation");
		Vocabulary v12=new Vocabulary("Lesson 2","background", "/'bækgraund/", "(n) phía sau, nền", "b");
		Vocabulary v13=new Vocabulary("Lesson 2","backward", "/'bækwəd/", "(adj) về phía sau, lùi lại", "a");
		Vocabulary v14=new Vocabulary("Lesson 2","bacteria", "/bæk'tiəriəm/", "(n) vi khuẩn", "b");
		Vocabulary v15=new Vocabulary("Lesson 2","bad", "/bæd/", "(adj) xấu, tồi", "b");
		Vocabulary v16=new Vocabulary("Lesson 2","badly", "/'bædli/", "(adv)  xấu, tồi", "c");
		Vocabulary v17=new Vocabulary("Lesson 2","bad-tempered", "/'bæd'tempəd/", "(adj) xấu tính, dễ nổi cáu", "a");
		Vocabulary v18=new Vocabulary("Lesson 2","bag", "/bæg/", "(n) bao, túi, cặp xách", "b");
		Vocabulary v19=new Vocabulary("Lesson 2","baggage", "/bæɳk/", "(n) hành lý", "c");
		Vocabulary v20=new Vocabulary("Lesson 2","bank", "/'æbsəlu:t/", "(n) bờ sông, đê", "a");
		Vocabulary v21=new Vocabulary("Lesson 3","cabinet", "/'kæbinit/", "(n) tủ có nhiều ngăn đựng đồ", "animation");
		Vocabulary v22=new Vocabulary("Lesson 3","campaign", "/kæmˈpeɪn/ ", "(n) chiến dịch, cuộc vận động", "b");
		Vocabulary v23=new Vocabulary("Lesson 3","candidate", "/'kændidit/", "(n) người ứng cử, thí sinh, người dự thi", "a");
		Vocabulary v24=new Vocabulary("Lesson 3","capable", "/'keipәb(ә)l/", "(adj) có năng lực, có tài", "b");
		Vocabulary v25=new Vocabulary("Lesson 3","capacity", "/kə'pæsiti/", "(n) năng lực, khả năng tiếp thu", "b");
		Vocabulary v26=new Vocabulary("Lesson 3","capital", "/ˈkæpɪtl/", "(n/adj) thủ đô, tiền vốn, chủ yếu", "c");
		Vocabulary v27=new Vocabulary("Lesson 3","capture", "/'kæptʃə/", "(v/n) bắt giữ, bắt, sự bắt giữ", "a");
		Vocabulary v28=new Vocabulary("Lesson 3","combination", "/,kɔmbi'neiʃn/", "(n) sự kết hợp, sự phối hợp", "b");
		Vocabulary v29=new Vocabulary("Lesson 3","commission", "/kəˈmɪʃən/", "(n/v) hội đồng, ủy ban, sự ủy nhiệm", "c");
		Vocabulary v30=new Vocabulary("Lesson 3","careful", "/'keəful/", "(adj) cẩn thận, cẩn trọng", "a");
		Vocabulary v31=new Vocabulary("Lesson 4","daily", "/'deili/", "(adj) hàng ngày", "animation");
		Vocabulary v32=new Vocabulary("Lesson 4","damp", "/dæmp/", "(adj) ẩm, ẩm ướt", "b");
		Vocabulary v33=new Vocabulary("Lesson 4","dance", "/dɑ:ns/", "(n/v) sự nhảy múa, sự khiêu vũ", "a");
		Vocabulary v34=new Vocabulary("Lesson 4","danger", "/'deindʤə/", "(n) sự nguy hiểm, mối hiểm nghèo", "b");
		Vocabulary v35=new Vocabulary("Lesson 4","dark", "/dɑ:k/", "(n/adj)  tối, tối tăm; bóng tối", "b");
		Vocabulary v36=new Vocabulary("Lesson 4","daughter", "/ˈdɔtər/", "(n/adj) con gái", "c");
		Vocabulary v37=new Vocabulary("Lesson 4","deal", "/di:l/", "(v/n) phân phát, phân phối", "a");
		Vocabulary v38=new Vocabulary("Lesson 4","debate", "/dɪˈbeɪt/", "(n/v) cuộc tranh luận, cuộc tranh cãi", "b");
		Vocabulary v39=new Vocabulary("Lesson 4","decade", "/'dekeid/", "(n) thập kỷ, bộ mười", "c");
		Vocabulary v40=new Vocabulary("Lesson 4","decide", "/di'said/", "(v) quyết định, giải quyết", "a");
		Vocabulary v41=new Vocabulary("Lesson 5","early", "/´ə:li/", "(adj/adv) sớm", "animation");
		Vocabulary v42=new Vocabulary("Lesson 5","easily", "/'i:zili/", "adv) dễ dàng", "b");
		Vocabulary v43=new Vocabulary("Lesson 5","east", "/i:st/", "(n/adv/adj) hướng đông, phía đông", "a");
		Vocabulary v44=new Vocabulary("Lesson 5","economic", "/¸i:kə´nɔmik/", "(adj) kinh tế", "b");
		Vocabulary v45=new Vocabulary("Lesson 5","electronic", "/ɪlɛkˈtrɒnɪk/", "(adj) điện tử", "b");
		Vocabulary v46=new Vocabulary("Lesson 5","exhibition", "/ˌɛksəˈbɪʃən/", "( n) cuộc triển lãm, trưng bày", "c");
		Vocabulary v47=new Vocabulary("Lesson 5","expand", "/iks'pænd/", "(v) mở rộng, phát triển", "a");
		Vocabulary v48=new Vocabulary("Lesson 5","expectation", "/,ekspek'tei∫n/", "(n) sự mong chờ, sự chờ đợi", "b");
		Vocabulary v49=new Vocabulary("Lesson 5","emerge", "/i´mə:dʒ/", "(v) nổi lên, hiện ra", "c");
		Vocabulary v50=new Vocabulary("Lesson 5","emotion", "/i'moƱʃ(ә)n/", "(n) sự xúc động, sự cảm động", "a");
		Vocabulary v51=new Vocabulary("Lesson 6","face", "/feis/", "(n) mặt, thể diện, đương đầu, đối phó", "animation");
		Vocabulary v52=new Vocabulary("Lesson 6","facility ", "/fəˈsɪlɪti/ ", "(n) điều kiện dễ dàng, sự dễ dàng, thuận lợi", "b");
		Vocabulary v53=new Vocabulary("Lesson 6","fact", "/fækt/", "(n) / việc, sự việc, sự kiện", "a");
		Vocabulary v54=new Vocabulary("Lesson 6","factory", "/'fæktəri/", "(n) nhà máy, xí nghiệp, xưởng", "b");
		Vocabulary v55=new Vocabulary("Lesson 6","faintly", "/'feintli/", "(adv) nhút nhát, yếu ớt", "b");
		Vocabulary v56=new Vocabulary("Lesson 6","fair", "/feə/", "(adj) hợp lý, công bằng, thuận lợi", "c");
		Vocabulary v57=new Vocabulary("Lesson 6","famous", "/'feiməs/", "(adj) nổi tiếng", "a");
		Vocabulary v58=new Vocabulary("Lesson 6","fashion", "/'fæ∫ən/", "(n) mốt, thời trang", "b");
		Vocabulary v59=new Vocabulary("Lesson 6","feature", "/'fi:tʃə/", "(n/v) nét đặt biệt, điểm đặc trưng", "c");
		Vocabulary v60=new Vocabulary("Lesson 6","feeling", "/'fi:liɳ/", "(n) sự cảm thấy, cảm giác", "a");
		Vocabulary v61=new Vocabulary("Lesson 7","gain", "/geɪn/", "(n/v) lợi, lợi ích", "animation");
		Vocabulary v62=new Vocabulary("Lesson 7","gather", "/'gæðə/", "(v) hái, lượm, thu thập", "b");
		Vocabulary v63=new Vocabulary("Lesson 7","general", "/'ʤenər(ə)l/", "(adj) chung, chung chung", "a");
		Vocabulary v64=new Vocabulary("Lesson 7","generation", "/ˌdʒɛnəˈreɪʃən/", "(n) sự sinh ra, sự phát sinh ra", "b");
		Vocabulary v65=new Vocabulary("Lesson 7","generous", "/´dʒenərəs/", "(adv) rộng lượng, hào phóng", "b");
		Vocabulary v66=new Vocabulary("Lesson 8","habit", "/´hæbit/", "( n) thói quen, tập quán", "c");
		Vocabulary v67=new Vocabulary("Lesson 8","hand", "/'kæptʃə/", "(n/v) tay, bàn tay; trao tay, truyền cho", "a");
		Vocabulary v68=new Vocabulary("Lesson 8","happiness", "/'hæpinis/", "(n) sự sung sướng, hạnh phúc", "b");
		Vocabulary v69=new Vocabulary("Lesson 8","harmful", "/´ha:mful/", "adj) gây tai hại, có hại", "c");
		Vocabulary v70=new Vocabulary("Lesson 8","headache", "/'hedeik/", "(n) chứng nhức đầu", "a");
		Vocabulary v71=new Vocabulary("Lesson 9","ideal", "/aɪˈdiəl/", "(adj/n) quan niệm, tư tưởng; lý tưởng", "animation");
		Vocabulary v72=new Vocabulary("Lesson 9","imagination", "/i,mædʤi'neiʃn/ ", "(n) trí tưởng tượng, sự tưởng tượng", "b");
		Vocabulary v73=new Vocabulary("Lesson 9","impatient", "/im'pei∫зns/", "(adj) thiếu kiên nhẫn, nóng vội", "a");
		Vocabulary v74=new Vocabulary("Lesson 9","importance", "/im'pɔ:təns/", "(n) sự quan trọng, tầm quan trọng", "b");
		Vocabulary v75=new Vocabulary("Lesson 9","impossible", "/im'pɔsəbl/", "(adj) không thể làm được, không thể xảy ra", "b");
		Vocabulary v76=new Vocabulary("Lesson 10","kind", "/kaind/", "( n/adj) loại, giống; tử tế, có lòng tốt", "c");
		Vocabulary v77=new Vocabulary("Lesson 10","knowledge ", "/''nɒliʤ/", "(n) sự hiểu biết, tri thức", "a");
		Vocabulary v78=new Vocabulary("Lesson 10","knitted ", "/´nitiη/ ", "(n) việc đan; hàng dệt kim", "b");
		Vocabulary v79=new Vocabulary("Lesson 10","kitchen ", "/´kitʃin/", "(n) bếp", "c");
		Vocabulary v80=new Vocabulary("Lesson 10","knot", "/nɔt/", "(n) cái nơ, điểm nút", "a");
		Vocabulary v81=new Vocabulary("Lesson 11","laboratory", "/ˈlæbrəˌtɔri/", "(n) phòng thí nghiệm", "animation");
		Vocabulary v82=new Vocabulary("Lesson 11","large", "/la:dʒ/", "(adj) rộng, lớn, to", "b");
		Vocabulary v83=new Vocabulary("Lesson 11","latest", "/leitist/", "(n/adj) muộn nhất, chậm nhất, gần đây nhất", "a");
		Vocabulary v84=new Vocabulary("Lesson 11","laugh", "/lɑ:f/", "(adj) ccười; tiếng cười", "b");
		Vocabulary v85=new Vocabulary("Lesson 11","leader", "/´li:də/", "(n) người lãnh đạo, lãnh tụ", "b");
		Vocabulary v86=new Vocabulary("Lesson 12","machine", "/mə'ʃi:n/", "( n) máy, máy móc", "c");
		Vocabulary v87=new Vocabulary("Lesson 12","maintain", "/mein´tein/", "(v) giữ gìn, duy trì, bảo vệ", "a");
		Vocabulary v88=new Vocabulary("Lesson 12","major", "/ˈmeɪdʒər/", "(adj) lớn, nhiều hơn, trọng đại, chủ yếu", "b");
		Vocabulary v89=new Vocabulary("Lesson 12","manager", "/'mæniʤ/", "(v) quản lý, trông nom, điều khiển", "c");
		Vocabulary v90=new Vocabulary("Lesson 12","market", "/'mɑ:kit/", "(n) chợ, thị trường", "a");
		Vocabulary v91=new Vocabulary("Lesson 13","narrow", "/'nærou/", "(adj) hẹp, chật hẹp", "animation");
		Vocabulary v92=new Vocabulary("Lesson 13","national", "/'næʃən(ə)l/", "(n) quốc gia, dân tộc", "b");
		Vocabulary v93=new Vocabulary("Lesson 13","necessary", "/'nesəseri/ ", "(adj) cần, cần thiết, thiết yếu", "a");
		Vocabulary v94=new Vocabulary("Lesson 13","neighbour", "/'neibə/", "(n) hàng xóm", "b");
		Vocabulary v95=new Vocabulary("Lesson 13","noisy", "/´nɔizi/", "(adj) ồn ào, huyên náo", "b");
		Vocabulary v96=new Vocabulary("Lesson 14","offer", "/ˈkæpɪtl/", "( n/v) biếu, tặng, cho; sự trả giá", "c");
		Vocabulary v97=new Vocabulary("Lesson 14","office", "/'ɔfis/", "(n) cơ quan, văn phòng, bộ", "a");
		Vocabulary v98=new Vocabulary("Lesson 14","opinion", "/ə'pinjən/", "(n) ý kiến, quan điểm", "b");
		Vocabulary v99=new Vocabulary("Lesson 14","organize", "/´ɔ:gə¸naiz/", "(v) tổ chức, thiết lập", "c");
		Vocabulary v100=new Vocabulary("Lesson 14","overcome", "/ˌoʊvərˈkʌm/", "(v) thắng, chiến thắng, khắc phục", "a");
		Vocabulary v101=new Vocabulary("Lesson 15","page", "/peidʒ/", "( n) trang", "c");
		Vocabulary v102=new Vocabulary("Lesson 15","palace", "/ˈpælɪs/", "(n) cung điện, lâu đài", "a");
		Vocabulary v103=new Vocabulary("Lesson 15","party", "/ˈpɑrti/", "(n) tiệc, buổi liên hoan", "b");
		Vocabulary v104=new Vocabulary("Lesson 15","passport", "/´pa:spɔ:t/", "(n) hộ chiếu", "c");
		Vocabulary v105=new Vocabulary("Lesson 15","patient", "/'peiʃənt/", "(n) /  bệnh nhân; kiên nhẫn, nhẫn nại, bền chí", "a");
		Vocabulary v106=new Vocabulary("Lesson 16","capital", "/ˈkæpɪtl/", "( n/adj) thủ đô, tiền vốn; chủ yếu", "c");
		Vocabulary v107=new Vocabulary("Lesson 16","capture", "/'kæptʃə/", "(v/n) bắt giữ, bắt; sự bắt giữ", "a");
		Vocabulary v108=new Vocabulary("Lesson 16","combination", "/,kɔmbi'neiʃn/", "(n) sự kết hợp, sự phối hợp", "b");
		Vocabulary v109=new Vocabulary("Lesson 16","commission", "/kəˈmɪʃən/", "(n/v) hội đồng, ủy ban, sự ủy nhiệm", "c");
		Vocabulary v110=new Vocabulary("Lesson 16","complicate", "/'komplikeit/", "(v) làm phức tạp, rắc rối", "a");
		Vocabulary v111=new Vocabulary("Lesson 17","qualification", "/,kwalifi'keiSn/", "(n) phẩm chất, năng lực; khả năng chuyên môn", "c");
		Vocabulary v112=new Vocabulary("Lesson 17","qualify", "/'´kwɔli¸fai/", "(v) đủ khả năng, đủ tư cách, điều kiện", "a");
		Vocabulary v113=new Vocabulary("Lesson 17","quality", "/'kwɔliti/", "(n) chất lượng, phẩm chất", "b");
		Vocabulary v114=new Vocabulary("Lesson 17","quantity", "/ˈkwɒntɪti/", "(n) hlượng, số lượng", "c");
		Vocabulary v115=new Vocabulary("Lesson 17","question", "/ˈkwɛstʃən/", "(n) câu hỏi; hỏi, chất vấn", "a");
		Vocabulary v116=new Vocabulary("Lesson 18","rain", "/rein/", "(n/v) mưa, cơn mưa; mưa", "c");
		Vocabulary v117=new Vocabulary("Lesson 18","reality", "/ri:'æliti/", "(n) sự thật, thực tế, thực tại", "a");
		Vocabulary v118=new Vocabulary("Lesson 18","reason", "/'ri:zn/", "(n) lý do, lý lẽ", "b");
		Vocabulary v119=new Vocabulary("Lesson 18","reception", "/ri'sep∫n/", "(n) sự nhận, sự tiếp nhận, sự đón tiếp", "c");
		Vocabulary v120=new Vocabulary("Lesson 18","reduce", "/ri'dju:s/", "(v) giảm, giảm bớt", "a");
		Vocabulary v121=new Vocabulary("Lesson 19","safe", "/seif/", "(adj) an toàn, chắc chắn, đáng tin", "c");
		Vocabulary v122=new Vocabulary("Lesson 19","sailor", "/seilə/", "(n) thủy thủ", "a");
		Vocabulary v123=new Vocabulary("Lesson 19","satisfy", "/'sætisfai/", "(v) làm thỏa mãn, hài lòng", "b");
		Vocabulary v124=new Vocabulary("Lesson 19","scare", "/skɛə/", "(v) làm kinh hãi, sợ hãi, dọa; sự sợ hãi", "c");
		Vocabulary v125=new Vocabulary("Lesson 19","scheme", "/ski:m/", "(n) sự sắp xếp, sự phối hợp", "a");
		Vocabulary v126=new Vocabulary("Lesson 20","table", "/'teibl/", "( n) cái bàn", "c");
		Vocabulary v127=new Vocabulary("Lesson 20","task", "/tɑːsk/", "(n) nhiệm vụ, nghĩa vụ", "a");
		Vocabulary v128=new Vocabulary("Lesson 20","technology", "/tek'nɔlədʤi/", "(n) kỹ thuật học, công nghệ học", "b");
		Vocabulary v129=new Vocabulary("Lesson 20","together", "/tə'geðə/", "(adv) cùng nhau, cùng với", "c");
		Vocabulary v130=new Vocabulary("Lesson 20","towards", "/tə´wɔ:dz/", "(prep) theo hướng, về hướng", "a");
		Vocabulary v131=new Vocabulary("Lesson 21","ultimate", "/ˈʌltəmɪt/", "(adj) cuối cùng, sau cùng", "c");
		Vocabulary v132=new Vocabulary("Lesson 21","umbrella", "/ʌm'brelə/", "(n) ô, dù", "a");
		Vocabulary v133=new Vocabulary("Lesson 21","understanding", "/ˌʌndərˈstændɪŋ/", "(n) trí tuệ, sự hiểu biết", "b");
		Vocabulary v134=new Vocabulary("Lesson 21","uniform", "/ˈjunəˌfɔrm/", "(n/adj) đồng phục; đều, giống nhau", "c");
		Vocabulary v135=new Vocabulary("Lesson 21","university", "/¸ju:ni´və:siti/", "(n) trường đại họci", "a");
		Vocabulary v136=new Vocabulary("Lesson 22","valid", "/'vælɪd/", "(adj) chắc chắn, hiệu quả, hợp lý", "c");
		Vocabulary v137=new Vocabulary("Lesson 22","value", "/'vælju:/", "(n/v) giá trị, ước tính, định giá", "a");
		Vocabulary v138=new Vocabulary("Lesson 22","venture", "/'ventʃə/", "(n/v) sự án kinh doanh, công việc kinh doanh", "b");
		Vocabulary v139=new Vocabulary("Lesson 22","victory ", "/'viktəri/", "(n) chiến thắng", "c");
		Vocabulary v140=new Vocabulary("Lesson 22","visitor", "/'vizitə/", "(n) khách, du khách", "a");
		Vocabulary v141=new Vocabulary("Lesson 23","wage", "/weiʤ/", "(n) tiền lương, tiền công", "c");
		Vocabulary v142=new Vocabulary("Lesson 23","wander", "/'wɔndə/", "(v/n) đi lang thang; sự đi lang thang", "a");
		Vocabulary v143=new Vocabulary("Lesson 23","wave", "/weɪv/", "(n/v) sóng, gợn nước; gợn sóng, uốn thành sóng", "b");
		Vocabulary v144=new Vocabulary("Lesson 23","weather", "/'weθə/", "(n) thời tiết", "c");
		Vocabulary v145=new Vocabulary("Lesson 23","wind", "/wind/", "(n) gió", "a");
		Vocabulary v146=new Vocabulary("Lesson 24","yellow", "/'jelou/", "(adj/n) vàng; màu vàng", "c");
		Vocabulary v147=new Vocabulary("Lesson 24","yesterday", "/'jestədei/", "(n) hôm qua", "a");
		Vocabulary v148=new Vocabulary("Lesson 24","young", "/jʌɳ/", "(adj) trẻ, trẻ tuổi, thanh niên", "b");
		Vocabulary v149=new Vocabulary("Lesson 24","yawn", "/jɔ:n/", "(v) há miệng", "c");
		Vocabulary v150=new Vocabulary("Lesson 24","youth", "/ju:θ/ ", "(n) tuổi trẻ, tuổi xuân, tuổi thanh niên", "a");
		Vocabulary v151=new Vocabulary("Lesson 25","wish", "/wi∫/", "(v/n) ước, mong muốn; sự mong ước", "c");
		Vocabulary v152=new Vocabulary("Lesson 25","within", "/wɪθaʊt/", "(prep) không, không có", "a");
		Vocabulary v153=new Vocabulary("Lesson 25","witness", "/'witnis/ ", "(n) sự làm chứng, bằng chứng", "b");
		Vocabulary v154=new Vocabulary("Lesson 25","woman", "/'wʊmən/", "(n) đàn bà, phụ nữ", "c");
		Vocabulary v155=new Vocabulary("Lesson 25","wood", "/wud/", "(c) gỗ", "a");
		Vocabulary v156=new Vocabulary("Lesson 26","work", "/wɜ:k/", "(v) làm việc, sự làm việc", "c");
		Vocabulary v157=new Vocabulary("Lesson 26","wrist", "/rist/", "(n) cổ tay", "a");
		Vocabulary v158=new Vocabulary("Lesson 26","worried", "/´wʌrid/", "(adj) bồn chồn, lo nghĩ, tỏ ra lo lắng", "b");
		Vocabulary v159=new Vocabulary("Lesson 26","wool", "/wul/", "(n) len", "c");
		Vocabulary v160=new Vocabulary("Lesson 26","world", "/wɜ:ld/", "(n) thế giới", "Heal the world.");
		database.insertVol(v1); database.insertVol(v2); database.insertVol(v3); database.insertVol(v4); database.insertVol(v5); database.insertVol(v6); database.insertVol(v7); database.insertVol(v8); database.insertVol(v9); database.insertVol(v10);
		database.insertVol(v11); database.insertVol(v12); database.insertVol(v13); database.insertVol(v14); database.insertVol(v15); database.insertVol(v16); database.insertVol(v17); database.insertVol(v18); database.insertVol(v19); database.insertVol(v20);
		database.insertVol(v21); database.insertVol(v22); database.insertVol(v23); database.insertVol(v24); database.insertVol(v25); database.insertVol(v26); database.insertVol(v27); database.insertVol(v28); database.insertVol(v29); database.insertVol(v30);
		database.insertVol(v21); database.insertVol(v22); database.insertVol(v23); database.insertVol(v24); database.insertVol(v25); database.insertVol(v26); database.insertVol(v27); database.insertVol(v28); database.insertVol(v29); database.insertVol(v30);
		database.insertVol(v21); database.insertVol(v22); database.insertVol(v23); database.insertVol(v24); database.insertVol(v25); database.insertVol(v26); database.insertVol(v27); database.insertVol(v28); database.insertVol(v29); database.insertVol(v30);
		database.insertVol(v21); database.insertVol(v22); database.insertVol(v23); database.insertVol(v24); database.insertVol(v25); database.insertVol(v26); database.insertVol(v27); database.insertVol(v28); database.insertVol(v29); database.insertVol(v30);
		database.insertVol(v31); database.insertVol(v32); database.insertVol(v33); database.insertVol(v34); database.insertVol(v35); database.insertVol(v36); database.insertVol(v37); database.insertVol(v38); database.insertVol(v39); database.insertVol(v40);
		database.insertVol(v41); database.insertVol(v42); database.insertVol(v43); database.insertVol(v44); database.insertVol(v45); database.insertVol(v46); database.insertVol(v47); database.insertVol(v48); database.insertVol(v49); database.insertVol(v50);
		database.insertVol(v51); database.insertVol(v52); database.insertVol(v53); database.insertVol(v54); database.insertVol(v55); database.insertVol(v56); database.insertVol(v57); database.insertVol(v58); database.insertVol(v59); database.insertVol(v60);
		database.insertVol(v61); database.insertVol(v62); database.insertVol(v63); database.insertVol(v64); database.insertVol(v65); database.insertVol(v66); database.insertVol(v67); database.insertVol(v68); database.insertVol(v69); database.insertVol(v70);
		database.insertVol(v71); database.insertVol(v72); database.insertVol(v73); database.insertVol(v74); database.insertVol(v75); database.insertVol(v76); database.insertVol(v77); database.insertVol(v78); database.insertVol(v79); database.insertVol(v80);
		database.insertVol(v81); database.insertVol(v82); database.insertVol(v83); database.insertVol(v84); database.insertVol(v85); database.insertVol(v86); database.insertVol(v87); database.insertVol(v88); database.insertVol(v89); database.insertVol(v90);
		database.insertVol(v91); database.insertVol(v92); database.insertVol(v93); database.insertVol(v94); database.insertVol(v95); database.insertVol(v96); database.insertVol(v97); database.insertVol(v98); database.insertVol(v99); database.insertVol(v100);
		database.insertVol(v101); database.insertVol(v102); database.insertVol(v103); database.insertVol(v104); database.insertVol(v105); database.insertVol(v106); database.insertVol(v107); database.insertVol(v108); database.insertVol(v109); database.insertVol(v110);
		database.insertVol(v111); database.insertVol(v112); database.insertVol(v113); database.insertVol(v114); database.insertVol(v115); database.insertVol(v116); database.insertVol(v117); database.insertVol(v118); database.insertVol(v119); database.insertVol(v120);
		database.insertVol(v121); database.insertVol(v122); database.insertVol(v123); database.insertVol(v124); database.insertVol(v125); database.insertVol(v126); database.insertVol(v127); database.insertVol(v128); database.insertVol(v129); database.insertVol(v130);
		database.insertVol(v131); database.insertVol(v132); database.insertVol(v133); database.insertVol(v134); database.insertVol(v135); database.insertVol(v136); database.insertVol(v137); database.insertVol(v138); database.insertVol(v139); database.insertVol(v140);
		database.insertVol(v141); database.insertVol(v142); database.insertVol(v143); database.insertVol(v144); database.insertVol(v145); database.insertVol(v146); database.insertVol(v147); database.insertVol(v148); database.insertVol(v149); database.insertVol(v150);
		database.insertVol(v151); database.insertVol(v152); database.insertVol(v153); database.insertVol(v154); database.insertVol(v155); database.insertVol(v156); database.insertVol(v157); database.insertVol(v158); database.insertVol(v159); database.insertVol(v160);
		
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
