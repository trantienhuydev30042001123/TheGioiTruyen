package com.it1k10.thegioitruyen.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.it1k10.thegioitruyen.model.Taikhoan;
import com.it1k10.thegioitruyen.model.Truyen;

public class databasedoctruyen extends SQLiteOpenHelper {

    // Cơ sở dữ liệu

    // Tên database
    private static String DATABASE_NAME = "doctruyen";
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private static int VERSION = 1;

    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";


    private Context context;

    private String SQLQuery = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_TAI_KHOAN+" TEXT UNIQUE, "
            +MAT_KHAU+" TEXT, "
            +EMAIL+" TEXT, "
            + PHAN_QUYEN+" INTEGER) ";

    private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
            +TEN_TRUYEN+" TEXT UNIQUE, "
            +NOI_DUNG+" TEXT, "
            +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";

    private String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'admin','admin','admin@gmail.com',1)";
    private String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'huy','huy','Huy@gmail.com',2)";

    private String SQLQuery4 = "INSERT INTO truyen VALUES (null,' THẦN ĐẠO ĐAN TÔN','Chương 1:Sống lại\n" +
            "\n" +
            "Vũ Quốc, Lăng Gia ở Thương Vân Trấn, trăng treo giữa trời.\n" +
            "\n" +
            "Lăng Hàn bỏ ra ròng rã mười giây, mới rốt cục khẳng định, hắn xác thực chuyển thế sống lại.\n" +
            "\n" +
            "Đối với một cường giả Thiên Nhân Cảnh mà nói, cần mất mười giây mới có thể khẳng định một chuyện, đây tuyệt đối khó mà tin nổi, nhưng cũng đồng dạng chứng minh, sự tình phát sinh ở trên người hắn, là khó mà tin nổi cỡ nào.\n" +
            "\n" +
            "Đời trước, hắn đứng trên đỉnh cao của võ đạo, ở đan đạo cũng có thành tựu cổ kim chưa thấy, khai sáng Tam Hỏa Dẫn thuật, gợi ra một hồi cách mạng ở Luyện Đan giới, được người tôn là Đan Đế.\n" +
            "\n" +
            "Nhưng hắn vẫn chưa thỏa mãn, còn muốn tiến thêm một bước, đạt đến Phá Hư Cảnh, Phá Toái Hư Không, hóa Phàm thành Thần trong truyền thuyết. Vì thế, hắn thăm dò vô số di tích, cuối cùng tiến vào Hắc Huyết Cốc, trải qua tầng tầng nguy hiểm, sau đó tìm tới một Cổ Tháp thần bí.\n" +
            "\n" +
            "Không có để hắn thất vọng, trên Cổ Tháp có văn tự màu vàng, chính là một bộ công pháp vô thượng, tên là Bất Diệt Thiên Kinh, luyện đến cảnh giới tối cao, thân thể bất hư bất hủ, cùng thiên địa đồng thọ!\n" +
            "\n" +
            "Nhưng cho dù lấy tu vi Thiên Nhân Cảnh của Lăng Hàn, vẫn cảm thấy Bất Diệt Thiên Kinh kia khó hiểu mịt mờ, thật giống như xem một quyển thiên thư, hoàn toàn không có manh mối.\n" +
            "\n" +
            "Hắn mạnh mẽ ghi nhớ bản công pháp kia, đang muốn nghiên cứu Cổ Tháp một chút, thì Cổ Tháp lại chấn động, bắn ra một đạo thần quang vô lượng, trong nháy mắt liền đánh nát cơ thể của hắn. Nhưng quái lạ chính là, linh hồn của hắn lại không tiêu tan, rơi vào một loại trạng thái tỉnh tỉnh mê mê, kéo dài hơn vạn năm.\n" +
            "\n" +
            "Ở chỗ này vạn năm, linh hồn của hắn vẫn suy diễn Bất Diệt Thiên Kinh, ngoại trừ chuyện đó, thì hắn không làm được chuyện gì, mười ngàn năm sau, hắn rốt cục lĩnh ngộ tầng thứ nhất của công pháp.\n" +
            "\n" +
            "Một cường giả Thiên Nhân Cảnh, bỏ ra 10000 năm, mới lĩnh ngộ được tầng thứ nhất của một môn công pháp, khái niệm này nghĩa là gì?\n" +
            "\n" +
            "Phải biết cường giả Thiên Nhân Cảnh, tuổi thọ cũng không tới ngàn năm, bình thường mà nói, thế gian căn bản không ai có thể tu thành Bất Diệt Thiên Kinh, bởi vì còn chưa có bắt đầu đã chết già.\n" +
            "\n" +
            "Nhưng Lăng Hàn lại lấy loại phương thức quái lạ này, nắm giữ tầng thứ nhất của Bất Diệt Thiên Kinh, sau đó, hắn lại đột nhiên trùng sinh, chuyển thế sống lại ở trên người một thiếu niên mười sáu tuổi, đồng dạng tên là Lăng Hàn.\n" +
            "\n" +
            "Khó mà tin nổi!\n" +
            "\n" +
            "- Mặc kệ xảy ra chuyện gì, nói chung ta đã sống lại!\n" +
            "\n" +
            "- Tuy bộ thân thể này mới chỉ là Luyện Thể tầng hai, phế vật đến không thể lại phế vật, nhưng ta đã từng là cường giả Thiên Nhân Cảnh, đứng ở đỉnh phong của võ đạo, lại là đan đạo đại sư, tư chất kém thì dùng đan dược tu bổ, không tin không thể trở lại đỉnh cao.\n" +
            "\n" +
            "- Hơn nữa, ta rốt cục có thể tu luyện Bất Diệt Thiên Kinh, đây là một công pháp vô thượng, thậm chí... Khả năng không phải ở Phàm Giới, mà đến từ Thần giới trong truyền thuyết, bằng không làm sao có khả năng cần mười ngàn năm mới có thể hiểu được tầng thứ nhất?\n" +
            "\n" +
            "- Đời này, ta nhất định có thể vượt qua tiền nhân, thành tựu Thần vị!\n" +
            "\n" +
            "- Còn có, thân thể này đến tột cùng là xảy ra chuyện gì, mười sáu tuổi mới tu luyện tới Luyện Thể tầng hai, lẽ nào là bởi vì võ đạo bây giờ quá mức héo tàn?\n" +
            "\n" +
            "Oanh, vô số ký ức tràn vào trong đầu, đây là ký ức thuộc về một Lăng Hàn khác, mà trong quá trình này, hai người hoàn toàn khác nhau đã dung hợp làm một.\n" +
            "\n" +
            "- Ta đã rõ ràng.\n" +
            "\n" +
            "Lăng Hàn gật đầu, sở dĩ hiện tại hắn mới là Luyện Thể tầng hai, nguyên nhân ở chỗ linh căn của hắn quá kém.\n" +
            "\n" +
            "Muốn tu luyện thành Võ Giả, có một điều kiện tiên quyết, chính là nhất định phải nắm giữ linh căn. Có linh căn, mới có thể hấp thu linh khí trong trời đất, rèn luyện bản thân, hóa thành nguyên lực của bản thân.\n" +
            "\n" +
            "Có linh căn hấp thu linh khí nhanh, có linh căn thì chậm, bởi vậy linh căn chia làm bốn đẳng cấp Thiên Địa Huyền Hoàng, mỗi đẳng cấp lại chia làm ba phẩm giai thượng trung hạ, lấy Thiên Cấp thượng phẩm tốt nhất, Hoàng Cấp hạ phẩm kém nhất.\n" +
            "\n" +
            "Phán đoán linh căn ưu khuyết, then chốt ở trình độ tinh khiết, càng tinh khiết càng tốt, mà linh căn của Lăng Hàn, lại là Ngũ hành đủ cả, thuộc loại hỗn độn nhất, ở thế giới võ đạo, đây là loại linh căn kém nhất, tính vào Hoàng Cấp hạ phẩm cũng chỉ có thể nói miễn cưỡng, bởi vậy năm nay hắn đã mười sáu tuổi, nhưng chỉ tu luyện đến Luyện Thể tầng hai, mà bạn cùng lứa tuổi, kém nhất cũng đạt đến Luyện Thể tầng bốn, tầng năm.\n" +
            "\n" +
            "Đời trước, Lăng Hàn là Thiên linh căn, hơn nữa còn là Cửu Dương Hỏa Linh Căn Thiên Cấp thượng phẩm, lại thêm thiên phú đan đạo không ai bằng, lấy đan phụ vũ, vẻn vẹn chỉ dùng hai trăm năm, liền đạt đến Thiên Nhân Cảnh, đây là kỷ lục cổ kim chưa có.\n" +
            "\n" +
            "- Ngũ Hành Tạp Linh Căn, đây là linh căn thấp nhất a, chẳng trách, tuy tiền thân cực kỳ nỗ lực, nhưng chỉ có thể tới Luyện Thể tầng hai.\n" +
            "\n" +
            "- Với ta mà nói, tuy Ngũ Hành Tạp Linh Căn có chút vướng tay chân, nhưng dựa vào đan dược, nhiều nhất bốn trăm năm, ta lại tới đỉnh cao!\n" +
            "\n" +
            "- Ồ!\n" +
            "\n" +
            "Trong lòng Lăng Hàn kinh ngạc thốt lên, trên mặt lộ ra vẻ khiếp sợ khó có thể tin tưởng, hắn sửng sốt một hồi lâu, mới lấy hồn lực mạnh mẽ quan sát linh căn ở đan điền, vẻ mặt kinh ngạc nhất thời biến thành mừng như điên.\n" +
            "\n" +
            "- Cái này không phải Ngũ Hành Tạp Linh Căn, Ngũ hành hoàn toàn cân đối, hình thành một đóa Đạo Liên! Đây là Ngũ Hành Hỗn Độn Liên, cực phẩm trong cực phẩm, so với Cửu Dương Hỏa Linh Căn còn quý hiếm, có thể coi là Linh Căn Thần Cấp!\n" +
            "\n" +
            "- Tiền thân tu luyện chậm, là bởi vì Linh Căn Thần Cấp, đều cần công pháp đặc biệt mới có thể phát huy ra uy năng chân chính.\n" +
            "\n" +
            "- Mà ta... lại nắm giữ Ngũ Hành Thiên Cực Công, xứng đôi với Ngũ Hành Hỗn Độn Liên!\n" +
            "\n" +
            "- Một trăm năm! Không, chỉ cần năm mươi năm, ta liền có thể đạt đến Thiên Nhân Cảnh lần nữa!\n" +
            "\n" +
            "Dù lấy tu vi Thiên Nhân Cảnh kiếp trước, Lăng Hàn cũng không nhịn được lộ vẻ vui mừng, linh căn khi sinh ra đã định, hậu thiên không cách nào thay đổi. Kiếp trước hắn vì Phá Hư thành Thần, thăm viếng qua vô số di tích, được lượng lớn công pháp bí thuật, Ngũ Hành Thiên Cực Công chính là một loại trong đó.\n" +
            "\n" +
            "Đời trước, hắn đứng ở đỉnh cao võ đạo, đời này, hắn lại lập huy hoàng, viết ra thần thoại bất hủ.\n" +
            "\n" +
            "- Tiền thân là chết như thế nào?\n" +
            "\n" +
            "Lăng Hàn lật tìm ký ức, rất nhanh hắn liền lộ ra vẻ giận dữ.\n" +
            "\n" +
            "Tiền thân là con trai độc nhất của Lăng gia gia chủ Lăng Đông Hành, mẫu thân, ông nội bà nội đã mất sớm. Mà Lăng gia là thế gia võ đạo, mỗi một tộc nhân đều luyện võ, cũng lấy võ vi tôn, tại sao Lăng Đông Hành có thể ngồi lên vị trí gia chủ? Là vì thực lực của hắn mạnh nhất, dùng nắm đấm đánh ra được.\n" +
            "\n" +
            "Nhưng Lăng Hàn, bởi vì vấn đề linh căn, từ nhỏ bị coi là phế vật, ăn hết khinh thường.\n" +
            "\n" +
            "Vì cho con trai một tương lai tươi sáng, Lăng Đông Hành và Hổ Dương Học Viện có thỏa thuận, Hổ Dương Học Viện sẽ chiêu thu Lăng Hàn trở thành đệ tử, toàn lực bồi dưỡng, mà coi như trao đổi, Lăng Đông Hành sẽ tiến vào Tử Quang Địa cốc, thay Hổ Dương Học Viện tìm kiếm một đồ vật thất lạc đã lâu.\n" +
            "\n" +
            "Hổ Dương Học Viện do Vũ Quốc Hoàng Triều xây dựng, tài nguyên vô số, nếu toàn lực bồi dưỡng, dù lại phế vật, cũng có thể tăng lên tới Tụ Nguyên Cảnh.\n" +
            "\n" +
            "Người của Hổ Dương Học Viện cũng không phải ngớ ngẩn, nếu dễ lấy được vật kia, sao chịu cho điều kiện hậu đãi như vậy?\n" +
            "\n" +
            "Tử Quang Địa cốc, nguy hiểm tầng tầng, đi nhầm một bước cũng có thể chết, nhưng vì con trai, Lăng Đông Hành ở bảy ngày trước liền xuất phát.\n" +
            "\n" +
            "Ngày hôm qua, người của Hổ Dương Học Viện đến, cũng thông báo Lăng Gia, hôm nay sẽ dựa theo ước định tới đón người. Nhưng lúc này, Lăng Gia Đại chấp sự Lăng Trọng Khoan lại chạy tới thương lượng với tiền thân, muốn hắn nhường lại tiêu chuẩn quý giá kia, cho cháu trai của hắn Lăng Mộ Vân.\n" +
            "\n" +
            "Lý do, Lăng Mộ Vân là thiên tài, tiền đồ vô hạn, cơ hội như vậy không thể cho một phế vật đi lãng phí.\n" +
            "\n" +
            "Tiền thân đương nhiên sẽ không đáp ứng, đây là cơ hội mà phụ thân hắn dùng mạng đổi lấy! Nhưng Lăng Trọng Khoan nói thương lượng, kỳ thực chỉ là thông báo cho tiền thân mà thôi, căn bản không để ý kiến của hắn ở trong lòng.\n" +
            "\n" +
            "Tiền thân không nhịn được ra tay, nhưng Lăng Trọng Khoan là cường giả Tụ Nguyên Cảnh, một ngón tay liền có thể trấn áp hắn, hắn há là đối thủ?\n" +
            "\n" +
            "Chỉ một quyền, tiền thân liền bị trọng thương, sau đó bị nhốt vào trong phòng của mình, hiển nhiên không muốn hắn quấy rối ở trước mặt người của Hổ Dương Học Viện, đợi lúc Lăng Đông Hành trở lại, thì ván đã đóng thuyền.\n" +
            "\n" +
            "Mà tiền thân trọng thương, thì bị tức chết rồi.\n" +
            "\n" +
            "Lăng Hàn hừ một tiếng, thực sự là khinh người quá đáng, cha của mình liều mạng đổi lấy tiêu chuẩn này, lại bị ông cháu của Lăng Trọng Khoan cướp đi?\n" +
            "\n" +
            "Đôi cẩu vật vô liêm sỉ tới cực điểm!\n" +
            "\n" +
            "Không thể nhẫn nhịn!\n" +
            "\n" +
            "Hắn bò dậy khỏi giường, nhất thời cảm thấy toàn thân đau nhức, hắn là sống lại, nhưng vết thương trên người sẽ không vô duyên vô cớ chuyển biến tốt.\n" +
            "\n" +
            "- Hả? Linh căn còn bị thương tích!\n" +
            "\n" +
            "Lăng Hàn hơi nhướng mày, một đòn này của Lăng Trọng Khoan, đã tạo thành thương tổn cho linh căn của hắn, mà linh căn bị thương, đây là một chuyện cực kỳ phiền phức, trị liệu phổ thông là vô hiệu.\n" +
            "\n" +
            "- Theo ta biết, có bảy loại đan dược có thể chữa trị linh căn, có điều bốn loại trong đó quá đắt, dù bán sạch Lăng Gia cũng không đổi được, hơn nữa, linh căn của ta chỉ bị thương nhẹ, không cần đan dược cao cấp như thế.\n" +
            "\n" +
            "- Còn lại ba loại, có hai loại muốn luyện chế thành đan, bằng vào tu vi Luyện Thể tầng hai của ta hiện tại, quá miễn cưỡng. Vậy chỉ còn một lựa chọn, là Nguyên Tâm linh dịch, chỉ cần điều phối dược liệu theo tỉ lệ, nấu thành linh dịch liền được.\n" +
            "\n" +
            "- Trước tiên chửa khỏi tổn thương, lại đi ngăn cản ông cháu Lăng Trọng Khoan, tuy ta không thèm cái tiêu chuẩn kia, nhưng tuyệt không thể để cho cơ hội mà phụ thân dùng mạng đổi lấy, tiện nghi hai ông cháu không biết xấu hổ kia!\n" +
            "\n" +
            "Hắn khoanh chân ngồi xuống, bắt đầu vận chuyển Bất Diệt Thiên Kinh.\n" +
            "\n" +
            "Đây là lần thứ nhất hắn vận chuyển công pháp có khả năng là Thần cấp này, nhưng bởi vì đã suy diễn hơn vạn năm, nên hiện tại điều khiển rất thong dong. Ong ong ong,… trong cơ thể hắn phát ra sinh cơ mạnh mẽ, nguyên lực tiêu hao lượng lớn, nhưng thương thế lại khôi phục cấp tốc.\n" +
            "\n" +
            "Vẻn vẹn mấy phút, thương thế của hắn đã lành hết.\n" +
            "\n" +
            "- Không hổ là Bất Diệt Thiên Kinh, ta vừa bắt đầu tu luyện liền kỳ hiệu như thế. Chỉ là cái này hoàn toàn khác những công pháp khác, công pháp bình thường là lợi dụng linh căn chuyển hóa thiên địa linh khí thành nguyên lực, mà Bất Diệt Thiên Kinh thì ngược lại, lấy nguyên lực rèn luyện thân thể, cũng có thể trị liệu thương thế.\n" +
            "\n" +
            "- Luyện đến cảnh giới tối cao, Bất Tử Bất Diệt cũng không phải là không thể.\n" +
            "\n" +
            "- Cho nên mới có thể xưng là Thiên Kinh!\n" +
            "\n" +
            "- Đáng tiếc hiện tại cấp độ không đủ, bằng không ta có thể lấy Bất Diệt Thiên Kinh chữa trị linh căn.\n" +
            "\n" +
            "Lăng Hàn mở hai mắt ra, nhìn sắc trời dần rõ ràng ngoài cửa sổ, lẩm bẩm nói:\n" +
            "\n" +
            "- Hiện tại, nên đi gặp lão già không biết xấu hổ Lăng Trọng Khoan kia một lần, cho hắn một niềm vui bất ngờ.\n" +
            "\n" +
            "Hắn mang giày, đi tới cửa, mở ra.\n" +
            "\n" +
            "Ngoài cửa lập tức xuất hiện một bóng người cao to, ngăn đường đi của hắn, người này gọi Trương Viễn, là chó săn của Lăng Trọng Khoan.\n" +
            "\n" +
            "- Hàn thiếu gia, Đại chấp sự dặn dò, ngày hôm nay ngươi chờ ở trong phòng!\n" +
            "\n" +
            "Trương Viễn cười hắc hắc nói, mặc dù người đối diện là con trai của Gia chủ, nhưng lại phế vật, ở trong mắt hắn chính là một chuyện cười.\n" +
            "\n" +
            "Ánh mắt của Lăng Hàn phát lạnh, nói:\n" +
            "\n" +
            "- Ngươi dám cản ta?\n" +
            "\n" +
            "Cản chính là ngươi, Đại chấp sự nói rồi, ngày hôm nay ngàn vạn lần không thể để cho Lăng Hàn đi quấy rối, lúc cần thiết dù đánh một trận cũng được! Trương Nguyên ngoài cười nhưng trong không cười nói:\n" +
            "\n" +
            "- Đây là mệnh lệnh của Đại chấp sự, kính xin Hàn thiếu gia không nên làm khó dễ ta.\n" +
            "\n" +
            "Con chó già Lăng Trọng Khoan này cũng thật cẩn thận, đánh hắn trọng thương vẫn không yên lòng, còn phái người giữ cửa, mà chuyện này cũng có thể nhìn ra, để cháu trai tiến vào Hổ Dương Học Viện, đối với Lăng Trọng Khoan mà nói nặng đến đâu, bất quá thời điểm cái hi vọng này phá diệt, Lăng Trọng Khoan thất vọng, căm tức cũng có thể tưởng tượng được.\n" +
            "\n" +
            "- Cút ngay!\n" +
            "\n" +
            "Lăng Hàn lạnh lùng nói.\n" +
            "\n" +
            "- Hàn thiếu gia, đây chính là Đại…\n" +
            "\n" +
            "Đùng!\n" +
            "\n" +
            "Lăng Hàn giơ tay quất tới, lạnh lùng nói:\n" +
            "\n" +
            "- Ngươi là thứ gì, bảo ngươi cút ngươi còn không cút?\n" +
            "\n" +
            "Cái gì, mình lại bị một phế vật tát tai? Trương Viễn không thể tin tưởng sờ mặt của mình, phế vật kia lại dám ra tay với hắn, hơn nữa còn đánh trúng, đây là chuyện cười gì a?\n" +
            "\n" +
            "Hắn giận tím mặt, nghĩ đến trước đó, Lăng Trọng Khoan nói lúc cần thiết có thể động thủ, không khỏi sinh ác tâm, điềm nhiên nói:\n" +
            "\n" +
            "- Hàn thiếu gia, đây là ngươi buộc ta…\n" +
            "\n" +
            "Đùng!\n" +
            "\n" +
            "Lăng Hàn phất tay lần thứ hai, lại vững vàng đánh hắn một cái tát.\n" +
            "\n" +
            "\n" +
            "\n" +
            "Chương 2: Cường thế \n" +
            "\n" +
            "Trương Viễn sắp điên rồi, hắn lại bị một phế vật tát liền hai cái! Trong cơn giận dữ, hắn cũng không suy nghĩ, dựa vào cái gì một phế vật Luyện Thể tầng hai, có thể quất Luyện Thể tầng bốn như hắn hai bạt tai, hét lớn một tiếng, nhào tới Lăng Hàn.\n" +
            "\n" +
            "Hiện tại hắn chỉ có một ý nghĩ, chính là tàn nhẫn đánh tên rác rưởi này một trận.\n" +
            "\n" +
            "Hắn đấm ra một quyền, sức mạnh mười phần, có tiếng kình phong vang lên.\n" +
            "\n" +
            "Lăng Hàn rất bình tĩnh, ở kiếp trước, hắn chỉ gảy ngón tay liền có thể giải quyết 10 ngàn tên Trương Viễn, nhưng bây giờ hắn chỉ là Luyện Thể tầng hai. Có chút phiền phức, nhưng cũng chỉ là một chút phiền toái nhỏ mà thôi, dù sao hiện tại chủ đạo thân thể này, cũng đã từng là cường giả Thiên Nhân Cảnh, tầm mắt còn ở đó!\n" +
            "\n" +
            "Chỉ cần Trương Viễn vừa nhấc tay, chân hơi động, Lăng Hàn liền có thể suy đoán ra cú đấm này đánh về nơi nào, bước chân sẽ đi tới đâu, bởi vậy, trong nháy mắt cú đấm của Trương Viễn đánh đến, Lăng Hàn đã có phản ứng.\n" +
            "\n" +
            "Hô, cú đấm này đánh tới, Trương Viễn không khỏi lộ ra nụ cười gằn đáng sợ, hắn thấy nếu một quyền này oanh trúng, thì trong nháy mắt có thể khiến Lăng Hàn mất đi năng lực phản kháng, chỉ có thể mặc hắn đánh.\n" +
            "\n" +
            "Đánh trúng rồi!\n" +
            "\n" +
            "Hả?\n" +
            "\n" +
            "Trương Viễn lộ vẻ kinh ngạc, bởi vì cú đấm này nhìn như đánh vào mặt Lăng Hàn, nhưng thực tế lại lệch một chút, Lăng Hàn lui về phía sau môt bước, vừa đúng tránh qua cú đấm này.\n" +
            "\n" +
            "Không dư một phần, không thiếu một phân, thật giống như dùng thước đo ra, vừa vặn đứng ở trước chóp mũi của Lăng Hàn.\n" +
            "\n" +
            "Nhất định là đúng dịp, Trương Viễn nói ở trong lòng.\n" +
            "\n" +
            "Đúng lúc này, Lăng Hàn lại tát tới.\n" +
            "\n" +
            "Đùng, thanh âm lanh lảnh vang lên, Trương Viễn lại trúng một cái tát.\n" +
            "\n" +
            "- Đáng chết!\n" +
            "\n" +
            "Trương Viễn nhổ mấy bãi nước miếng, hét lớn một tiếng, sau đó hắn lại vung quyền đánh tới Lăng Hàn.\n" +
            "\n" +
            "Lăng Hàn như chuyển động cùng lúc, người hơi ngửa ra sau, hô, cú đấm của Trương Viễn lại đánh hụt. Hắn phất tay, chân phải thuận thế đá ra, phốc, đá vào giữa hai chân của Trương Viễn.\n" +
            "\n" +
            "- Gào…\n" +
            "\n" +
            "Coi như là Luyện Thể tầng bốn thì lại làm sao, vẫn không thể luyện thành Thiết Đản công, ăn một cước này, Trương Viễn quỳ xuống đất, hai tay ôm đũng quần, trên mặt chảy ra mồ hôi lạnh.\n" +
            "\n" +
            "- Ngươi thật âm hiểm!\n" +
            "\n" +
            "Trương Viễn co giật nói, khuôn mặt vặn vẹo đến không thành hình người.\n" +
            "\n" +
            "Đùng!\n" +
            "\n" +
            "Lăng Hàn lại quất tới một bạt tai, Trương Viễn phun ra mấy cái răng gãy. Lăng Hàn đương nhiên sẽ không đồng tình, nói:\n" +
            "\n" +
            "- Chó chính là chó, quả nhiên không thể mọc ngà voi.\n" +
            "\n" +
            "Trương Viễn giận dữ, hắn lại quỳ trên mặt đất, bị một Luyện Thể tầng hai tát tai, đây là nhục nhã thế nào? Hắn muốn phản kích, nhưng một cước kia, đã đánh tan năng lực phản kháng của hắn, hơi động liền đau “bi” đến đòi mạng.\n" +
            "\n" +
            "Nhưng tuyệt không thể để cho Lăng Hàn phá hỏng chuyện tốt của Lăng Trọng Khoan, bằng không hắn là không hoàn thành nhiệm vụ. Lấy tính cách của Lăng Trọng Khoan, hắn là tuyệt đối không sống được.\n" +
            "\n" +
            "- Hàn… Hàn thiếu gia, ngươi nghe ta nói, ngươi không thể rời nơi này, kỳ thực, kỳ thực ngươi đã trúng độc, rời khỏi gian phòng này sẽ độc phát thân vong.\n" +
            "\n" +
            "Hắn nhanh trí, làm sao cũng phải lưu Lăng Hàn ở lại chỗ này.\n" +
            "\n" +
            "Lăng Hàn không khỏi bật cười, loại biểu diễn vụng về này có thể lừa hắn? Lăng Hàn nâng cước đạp bay Trương Viễn, hiện tại không thể lãng phí thời gian với chó săn, hắn nhất định phải ngăn cản gian kế của Lăng Trọng Khoan, bằng không phụ thân liều mạng sẽ thành áo cưới cho người khác.\n" +
            "\n" +
            "Còn Trương Viễn, Lăng Hàn đương nhiên sẽ không để loại tiểu nhân vật này ở trong lòng, ngược lại là Lăng Trọng Khoan, chỉ cần thấy hắn xuất hiện, tất nhiên sẽ xử lý Trương Viễn, căn bản không cần ô uế tay hắn.\n" +
            "\n" +
            "- Không nên đi! Không nên đi a!\n" +
            "\n" +
            "Trương Viễn cầu xin mang theo tiếng khóc từ phía sau truyền đến, hắn phảng phất đã thấy kết cục thê thảm của mình.\n" +
            "\n" +
            "Tự gây nghiệt không thể sống, không đáng giá đồng tình.\n" +
            "\n" +
            "Lăng Hàn đi nhanh, mấy phút sau, hắn đi tới một phòng khách, còn chưa tiến vào liền nghe bên trong truyền ra một thanh âm già nua mà vang dội:\n" +
            "\n" +
            "- Lưu tiểu thư, xin mời, xin mời!\n" +
            "\n" +
            "Phòng khách có hai cổng nội ngoại, nội môn liên tiếp nội viện, ngoại môn là dẫn tới đại môn, xuyên thấu qua rèm cửa, chỉ thấy một nhóm năm người đang đi vào, bốn nam một nữ.\n" +
            "\n" +
            "Ngoại trừ cô gái kia, bốn nam tử Lăng Hàn đều biết, đều là Lăng gia tộc nhân, trong đó tên lão nhân khoảng sáu mươi chính là Đại chấp sự Lăng Trọng Khoan, ba người khác, có hai cái là trung niên chừng bốn mươi tuổi, đều là con trai của Lăng Trọng Khoan, mà cuối cùng là một tên thiếu niên, so với Lăng Hàn hơi lớn hơn một hai tuổi, chính là Trưởng Tôn của Lăng Trọng Khoan… Lăng Mộ Vân.\n" +
            "\n" +
            "Lăng Hàn nhìn lại nữ tử duy nhất kia, cho dù lấy ánh mắt Thiên Nhân Cảnh kiếp trước của hắn, hai mắt cũng sáng ngời, cô gái này thật đẹp, mắt như thu thủy, da trắng như tuyết, dung nhan chim sa cá lăn, cũng khoảng mười bảy mười tám tuổi, nhưng đã có phong thái họa quốc ương dân.\n" +
            "\n" +
            "Chỉ là vẻ mặt của nàng quá lạnh, phảng phất như một tòa băng sơn, bài xích bất luận người nào tiếp cận.\n" +
            "\n" +
            "Thiếu nữ này tất nhiên chính là người của Hổ Dương Học Viện, tới rất vừa vặn.\n" +
            "\n" +
            "Hả?\n" +
            "\n" +
            "Con ngươi của Lăng Hàn hơi phóng to, hắn phát hiện một sự tình càng vừa vặn, khóe miệng không khỏi lộ ra một nụ cười.\n" +
            "\n" +
            "Song phương phân chủ khách ngồi xuống, vài tên thị nữ dâng trà thơm, cung kính đứng hầu ở bên cạnh năm người.\n" +
            "\n" +
            "- Người mà Lăng Gia các ngươi chuẩn bị đưa đi học viện đã chuẩn bị kỹ càng chưa?\n" +
            "\n" +
            "Lưu Vũ Đồng mở miệng nói, âm thanh lành lạnh lại êm tai, còn có một tia xem thường. Nàng ghét nhất chính là hành vi thương lượng cửa sau, tuy phụng lệnh mà đến, nhưng đối với sư đệ tương lai kia lại không có chút hảo cảm.\n" +
            "\n" +
            "- Chuẩn bị kỹ càng, chuẩn bị kỹ càng!\n" +
            "\n" +
            "Lăng Trọng Khoan liền vội vàng nói, tuy tuổi tác của hắn đủ để làm gia gia của thiếu nữ, nhưng cảnh giới của song phương lại ngang nhau, đều là Tụ Nguyên Cảnh.\n" +
            "\n" +
            "Võ không trưởng ấu, cường giả vi tôn.\n" +
            "\n" +
            "Thậm chí, Lăng Trọng Khoan có loại cảm giác, tu vi của thiếu nữ này còn cao hơn hắn một ít, hắn là Tụ Nguyên tầng sáu, mà thiếu nữ, có khả năng là tầng bảy, thậm chí tầng tám.\n" +
            "\n" +
            "Điều này cũng làm cho hắn càng thêm bức thiết muốn đưa Tôn Tử của mình tiến vào Hổ Dương Học Viện, không ra mấy năm, tất có thể vượt qua Lăng Đông Hành, giúp hắn đoạt lại vị trí Gia chủ.\n" +
            "\n" +
            "- Mộ Vân, còn không mau tới bái kiến Lưu sư tỷ!\n" +
            "\n" +
            "Lão gia hoả quay đầu nói với Lăng Mộ Vân.\n" +
            "\n" +
            "- Vâng, gia gia!\n" +
            "\n" +
            "Lăng Mộ Vân mười phần cung kính, chắp tay nói với Lưu Vũ Đồng.\n" +
            "\n" +
            "- Mộ Vân bái kiến Lưu sư tỷ!\n" +
            "\n" +
            "Ánh mắt của hắn có một tia hừng hực, đối với mỹ nữ lãnh diễm, lại vô cùng mạnh mẽ kia tràn ngập dã tâm.\n" +
            "\n" +
            "Hắn tin tưởng, chỉ cần có thể ở chung nhiều chút thời gian, tất có thể đoạt được tâm của mỹ nhân.\n" +
            "\n" +
            "Lưu Vũ Đồng hơi kinh ngạc, nàng nhớ người mà Lăng Gia thương lượng cửa sau tên Lăng Hàn. Có điều, cái này cùng nàng có quan hệ gì, nàng chỉ phụ trách đến dẫn người về học viện mà thôi.\n" +
            "\n" +
            "- Nếu chuẩn bị kỹ càng,vậy liền lên đường đi.\n" +
            "\n" +
            "Nàng lạnh nhạt nói.\n" +
            "\n" +
            "- Lưu tiểu thư, xin ở lại hàn xá thêm mấy ngày, cho chúng ta bày tỏ tâm ý a.\n" +
            "\n" +
            "Lăng Trọng Khoan vội vàng nói, hắn muốn kéo quan hệ với thiếu nữ này, ngày sau có thể chăm sóc cháu trai một chút.\n" +
            "\n" +
            "- Không cần!\n" +
            "\n" +
            "Lưu Vũ Đồng lạnh lùng từ chối, liền muốn xoay người rời đi.\n" +
            "\n" +
            "- Tạm thời dừng chân!\n" +
            "\n" +
            "Một thanh âm vang lên, Lăng Hàn bước ra ngoài.\n" +
            "\n" +
            "Sắc mặt của bốn người Lăng Trọng Khoan đều hơi có chút biến hóa, mặc kệ bọn họ xem thường phế vật Lăng Gia này ra sao, nhưng hiện tại bọn hắn là tặc, làm kẻ trộm đương nhiên sẽ có chút chột dạ.\n" +
            "\n" +
            "- Hàn đệ, không phải ngươi bị thương sao, nhanh trở về tĩnh dưỡng a.\n" +
            "\n" +
            "Lăng Mộ Vân phản ứng cực nhanh, bước đến bên người Lăng Hàn, đưa tay tóm tới, hắn muốn hạn chế Lăng Hàn ngay lập tức, không cho đối phương có cơ hội mở miệng.\n" +
            "\n" +
            "Hắn là Luyện Thể tầng bảy, thực lực tuyệt đối không phải Trương Viễn có thể sánh được." +
            "\n" +
            "\n" +
            "\n" +
            "Chương 3: Ngươi có bệnh, ta có thể trị\n"+
            "Luyện Thể Cảnh tổng cộng chia làm tầng chín, thông thường từ tầng một đến tầng ba xưng là Luyện Thể tiền kỳ, tầng bốn đến tầng sáu làm trung kỳ, bảy đến tầng chín làm hậu kỳ, Võ Giả ở ba giai đoạn này, về mặt thực lực sẽ có chênh lệch rất lớn.\n" +
            "\n" +
            "Mà cấp độ càng cao, chênh lệch lại càng lớn, như Luyện Thể tầng chín có thể nghiền ép Luyện Thể tầng tám, nhưng Luyện Thể tầng một đối đầu Luyện Thể tầng hai, sẽ không yếu thế lớn như vậy.\n" +
            "\n" +
            "Trước đó nhìn như Lăng Hàn kém Trương Viễn hai tầng, kỳ thực chỉ chênh lệch một đại giai đoạn, nhưng Lăng Mộ Vân là Luyện Thể tầng bảy, Luyện Thể hậu kỳ, so với Lăng Hàn là ròng rã cao hơn hai giai đoạn lớn.\n" +
            "\n" +
            "Đây là hồng câu không thể vượt qua, cho dù Lăng Hàn đã từng là cường giả Thiên Nhân Cảnh, cũng không thể bù đắp chênh lệch lớn như vậy, dù sao hiện tại cơ sở của hắn quá thấp.\n" +
            "\n" +
            "Làm sao bây giờ?\n" +
            "\n" +
            "Lăng Hàn nghiêm túc, thừa dịp thủ chưởng của đối phương chộp tới, đột nhiên nâng quyền đánh ra.\n" +
            "\n" +
            "Trên mặt Lăng Mộ Vân không khỏi xẹt qua một tia trào phúng, tuy hắn không biết làm sao Lăng Hàn tới được, nhưng phế vật mà cả Lăng gia đều biết, có thể tạo thành uy hiếp gì với hắn?\n" +
            "\n" +
            "Hắn vận chuyển nguyên lực, bắp thịt nơi ngực nhô lên, chặt chẽ như sắt, dù ngạnh kháng một quyền của Lăng Hàn thì lại làm sao? Hiện tại trọng điểm là lập tức hạn chế Lăng Hàn, không cho hắn có cơ hội mở miệng.\n" +
            "\n" +
            "Quả thế.\n" +
            "\n" +
            "Khóe miệng của Lăng Hàn lộ ra vẻ tươi cười, phản ứng của đối phương như trong dự liệu của hắn, lần này nhìn ngươi kinh ngạc ra sao a!\n" +
            "\n" +
            "Oành, bởi vì Lăng Mộ Vân không tránh không né, cú đấm này đương nhiên không có vấn đề gì.\n" +
            "\n" +
            "Lăng Mộ Vân vẫn mang theo vẻ trào phúng, đưa tay khoát lên vai Lăng Hàn, nói:\n" +
            "\n" +
            "- Hàn đệ, ta đưa ngươi về… phốc!\n" +
            "\n" +
            "Lời còn chưa nói hết, hắn liền phun ra một ngụm máu, vẫn chưa xong, hắn chỉ cảm thấy ngực như nước sôi, muốn phun toàn bộ nội tạng ra ngoài.\n" +
            "\n" +
            "Lăng Mộ Vân đặt mông ngồi trên đất, sắc mặt trở nên cực kỳ khó coi.\n" +
            "\n" +
            "Lăng Hàn cũng đúng lúc lùi lại bảy bước, phải dựa vào trên tường phía sau mới ngừng bước chân được.\n" +
            "\n" +
            "Chuyện gì thế này?\n" +
            "\n" +
            "Lăng Hàn ở trên cú đấm kia dùng kỹ xảo, tên là Cách Sơn Chấn, có thể mang kình lực xuyên thấu qua phòng ngự, lại nổ tung, bởi vậy tuy Lăng Mộ Vân lấy nguyên lực bố phòng, nhưng quyền lực của Lăng Hàn là cách tầng bắp thịt kia nổ tung ở trong cơ thể hắn, tự nhiên tạo thành đả kích rất lớn với Lăng Mộ Vân.\n" +
            "\n" +
            "Cũng may Lăng Mộ Vân là Luyện Thể tầng bảy, bằng không cú đấm này có thể làm hắn trọng thương, trực tiếp bỏ mạng cũng không phải là không có khả năng.\n" +
            "\n" +
            "Xem thường một người đã từng là cường giả Thiên Nhân Cảnh, đây là tự mình chuốc lấy cực khổ.\n" +
            "\n" +
            "Có điều, Luyện Thể tầng bảy dù sao cũng là Luyện Thể tầng bảy, nguyên lực đàn hồi, sức mạnh kia vẫn xa xa không phải Lăng Hàn có khả năng gánh vác, bởi vậy hắn cũng bị chấn lảo đảo lùi về sau, dưới lực lượng rung động, tay phải của hắn cũng trật khớp.\n" +
            "\n" +
            "Cách, lông mày của Lăng Hàn cũng không nhăn một cái, tay trái nắn nắn, xương tay phải đã về vị trí cũ.\n" +
            "\n" +
            "Cho đến lúc này, đám người Lăng Trọng Khoan mới phản ứng lại, không ai không vừa giận vừa sợ, phẫn nộ chính là Lăng Hàn lại đả thương Lăng Mộ Vân, kinh sợ là tên này không phải phế vật sao, làm sao có khả năng làm được điểm ấy?\n" +
            "\n" +
            "Mà mấy thị nữ kia càng ngây người như phỗng, cái này vẫn là Hàn thiếu gia mà các nàng nhận thức sao, sao hung ác mãnh liệt như vậy, một quyền liền đánh Mộ Vân thiếu gia thổ huyết!\n" +
            "\n" +
            "- Tiểu súc sinh, ngươi thật to gan, thật độc ác!\n" +
            "\n" +
            "Lăng Trọng Khoan lập tức rống to.\n" +
            "\n" +
            "- Mộ Vân chỉ là quan tâm ngươi, muốn đưa ngươi trở về phòng, ngươi lại xuống tay tàn nhẫn như thế, ngươi cái cẩu vật phát điên này!\n" +
            "\n" +
            "Quả nhiên là lão gian hoạt, trực tiếp chụp mũ.\n" +
            "\n" +
            "Lăng Mộ Vân cũng chậm chạp hồi khí, hai mắt nhìn Lăng Hàn tràn ngập sát khí, hắn là thiên tài của Lăng gia, lại bị một tên phế vật đánh thương, điều này làm cho lòng tự tôn của hắn sao có thể tiếp thu?\n" +
            "\n" +
            "Lăng Hàn căn bản không để ý tới hai ông cháu này, mà nhìn về phía Lưu Vũ Đồng, nói:\n" +
            "\n" +
            "- Cô nương, ngươi có bệnh!\n" +
            "\n" +
            "Cái này?\n" +
            "\n" +
            "Lăng Trọng Khoan vốn định ra tay, nhưng nghe được câu này liền miễn cưỡng áp chế lại.\n" +
            "\n" +
            "Người ta là học sinh của Hổ Dương học viện, mà Hổ Dương Học Viện chính là của Hoàng thất Vũ Quốc, có thể tiến vào học viện, tất nhiên nắm giữ bối cảnh mạnh mẽ, vượt xa Tụ Nguyên Cảnh.\n" +
            "\n" +
            "Nhưng Lăng Hàn lại mở miệng nói người ta có bệnh, cái này không phải muốn chết sao?\n" +
            "\n" +
            "Rất tốt, kế tiếp sẽ kéo Lăng Đông Hành vào, mượn đao giết người, hắn liền có thể ung dung ngồi lên vị trí Gia chủ.\n" +
            "\n" +
            "Tuyệt vời, tuyệt vời, tuyệt vời, Lăng Đông Hành a Lăng Đông Hành, ngươi tuyệt đối không ngờ a, con trai của ngươi không chỉ phế vật, hơn nữa còn là vua hố hàng!\n" +
            "\n" +
            "Lưu Vũ Đồng nhìn về phía Lăng Hàn, ánh mắt hiện ra vẻ chán ghét.\n" +
            "\n" +
            "Nàng có diễm danh, hơn nữa còn là quý nữ của Lưu gia, một trong Hoàng thành Bát Đại Gia Tộc. Lưu gia là tồn tại chỉ đứng sau hoàng tộc, tự nhiên không thiếu nam tử lấy lòng nàng, có người còn đi ngược đường cũ, giả vờ lạnh lùng muốn hấp dẫn sự chú ý của nàng.\n" +
            "\n" +
            "Nàng đương nhiên sẽ coi Lăng Hàn như con ruồi, chỉ là thông qua phương thức “chửi bới“... này ngược lại là lần thứ nhất gặp phải, nhưng cái này không làm cho nàng có cảm giác chú ý chút nào, chỉ có căm ghét.\n" +
            "\n" +
            "- Lớn mật!\n" +
            "\n" +
            "Lăng Trọng Khoan tra nhan nhìn sắc, đúng lúc hét lớn.\n" +
            "\n" +
            "- Còn không mau quỳ xuống, nhận lỗi với Lưu tiểu thư.\n" +
            "\n" +
            "Lăng Hàn cười nhạt, nói:\n" +
            "\n" +
            "- Cõi đời này, ngoại trừ cha mẹ, không ai có thể để cho ta quỳ xuống!\n" +
            "\n" +
            "Hắn đi tới chỗ Lưu Vũ Đồng, lúc cách ba bước, liền ngừng lại.\n" +
            "\n" +
            "Bởi vì hắn biết đây là cực hạn mà đối phương có thể khoan dung, lại gần nữa, đối phương nhất định sẽ ra tay hại người.\n" +
            "\n" +
            "Hắn là không muốn chịu đòn chút nào.\n" +
            "\n" +
            "- Ngươi từ mười tuổi bắt đầu, có phải hàng năm đều sẽ vô duyên vô cớ té xỉu? Mới đầu chỉ là một năm một lần, sau đó tần suất càng ngày càng cao, hiện tại, có phải mười mấy ngày sẽ ngất xỉu một lần không?\n" +
            "\n" +
            "Lăng Hàn hạ thấp giọng, chỉ để Lưu Vũ Đồng nghe được.\n" +
            "\n" +
            "Lưu Vũ Đồng không khỏi biến sắc, tật xấu này của nàng ở Lưu gia, cũng chỉ có mấy người biết, tại sao Lăng Hàn có thể nói ra? Nàng không khỏi đánh giá Lăng Hàn lần nữa, nói:\n" +
            "\n" +
            "- Ngươi biết nguyên nhân?\n" +
            "\n" +
            "- Tự nhiên!\n" +
            "\n" +
            "Lăng Hàn ngạo nhiên gật đầu, nếu không như vậy, hắn cũng sẽ không nói lời kinh người.\n" +
            "\n" +
            "- Bệnh của ngươi tên Tam Âm Tuyệt Mạch, là một loại nguyền rủa của thượng thiên. Người nắm giữ Tam Âm Tuyệt Mạch, bình thường chỉ có thể sống đến hai mươi tuổi, bởi vì năm hai mươi tuổi ấy, ngươi sẽ ở trong một lần ngất xỉu, vĩnh viễn không tỉnh lại nữa.\n" +
            "\n" +
            "Lưu Vũ Đồng lặng lẽ, nhưng mà tin tưởng Lăng Hàn.\n" +
            "\n" +
            "Bởi vì sau khi bệnh trạng của nàng càng ngày càng nghiêm trọng, người nhà đã từng dẫn nàng đi thăm danh y, tuy mỗi danh y đều bó tay toàn tập, thậm chí ngay cả tên bệnh cũng không biết, nhưng dựa theo một vị danh y suy đoán, tần suất ngất xỉu của nàng sẽ càng ngày càng cao, cho đến một ngày nào đó sẽ không tỉnh nữa.\n" +
            "\n" +
            "Hiện tại, nàng rốt cuộc biết mình bị bệnh gì, nhưng như vậy thì thế nào, hết thảy danh y của Vũ Quốc đều bó tay toàn tập, nàng dĩ nhiên không tin Lăng Hàn sẽ có biện pháp.\n" +
            "\n" +
            "- Ta có thể trị.\n" +
            "\n" +
            "Đúng lúc này, Lăng Hàn mở miệng nói.\n" +
            "\n" +
            "Trong lòng Lưu Vũ Đồng run lên, nhưng trên mặt không chút biến sắc, nói:\n" +
            "\n" +
            "- Nếu ngươi có thể chửa khỏi, ta có thể phong ngươi chức vị, hoặc là cho ngươi vô số tài nguyên tu luyện.\n" +
            "\n" +
            "Lăng Hàn nhoẻn miệng cười, nói:\n" +
            "\n" +
            "- Muốn trị Tam Âm Tuyệt Mạch chỉ có một biện pháp, kia chính là tu luyện Tam Âm Huyền Công, mà ta vừa vặn biết môn công pháp này. Ta có thể dạy ngươi, nhưng có một điều kiện… ngươi làm thị vệ của ta.\n" +
            "\n" +
            "Lưu Vũ Đồng không khỏi nổi giận, nàng là quý nữ của Lưu gia, bản thân càng là thiên tài võ đạo, mới mười bảy tuổi liền đạt đến Tụ Nguyên tầng tám. Hiện tại một Luyện Thể tầng hai nho nhỏ, lại nói muốn thu nàng làm thị vệ, đây là tự tin từ đâu tới, dũng khí từ đâu tới?\n" +
            "\n" +
            "- Không nên cảm thấy oan ức, bởi vì ta có thể cho ngươi một bầu trời càng rộng lớn hơn, để ngươi đi tới đỉnh phong võ đạo càng cao hơn. Bảy đại tuyệt địa, tứ đại sát cốc, tam đại huyền hải, ngươi có gặp qua chưa?\n" +
            "\n" +
            "Lăng Hàn dụ dỗ từng bước, Tam Âm Tuyệt Mạch dĩ nhiên là thiên địa nguyền rủa, nhưng trời không tuyệt đường người, người như vậy thông thường đều nắm giữ linh căn Thiên Cấp, chỉ cần tu luyện Tam Âm Huyền Công, thì tất có thể nhất phi trùng thiên.\n" +
            "\n" +
            "Lưu Vũ Đồng không khỏi tim đập thình thịch, đối với võ đạo, nàng có theo đuổi cuồng nhiệt, đây là toàn bộ sinh mệnh của nàng.','https://truyenchu.vn/uploads/Images/than-dao-dan-ton.jpg',1)";
    private String SQLQuery5 = "INSERT INTO truyen VALUES (null,'THẾ GIỚI HOÀN MỸ','Chương 1: Đại Hoang\n" +
            "\n" +
            "Đêm đã về khuya, bóng tối phủ kín khắp nơi, bao trùm lên cảnh vật. Thế nhưng trong núi lại chẳng hề yên tĩnh, tiếng mãnh thú rít gào rung động cả non sông, cây cối rung lên, lá bay tán loạn.\n" +
            "\n" +
            "Chốn rừng núi mênh mang là nơi hoạt động của vô số mãnh thú hồng hoang cùng những chủng tộc sót lại từ thời Thái Cổ. Tiếng kêu đáng sợ của muôn loài rống lên trong bóng tối, khiến mặt đất như muốn nứt toác ra.\n" +
            "\n" +
            "Từ trong dãy núi trông xa thấy có thấp thoáng một quầng sáng nhu hòa, tựa như một ngọn nến lập lòe dưới màn đêm đen vô tận, lẩn khuất giữa muôn trùng núi, ánh sáng dường như có thể vụt tắt bất cứ lúc nào. Bạn đang xem truyện được sao chép tại: TruyenFull.vn\n" +
            "\n" +
            "Đến gần hơn, có thể thấy rõ ở đó có một nửa thân cây khô khổng lồ, đường kính thân cây ước chừng hơn chục mét, toàn thân cháy đen, ngoại trừ một nửa thân cây này, chỉ còn lại một cành cây yếu ớt nhưng lại tỏa ra sức sống. Lá cây lung linh như được khắc từ lục ngọc, tán phát từng đốm sáng nhu hòa bao trùm lấy cả một thôn làng.\n" +
            "\n" +
            "Nói một cách chính xác thì đây là một thân cây sét đánh, rất nhiều năm về trước nó từng gặp phải một trận sét thông thiên, vòm cây um tùm cùng sức sống tràn trề của gốc liễu già đã bị sấm sét phá hủy. Nay chỉ còn lại một đoạn gốc cao chừng tám chín mét trồi lên mặt đất, đường kính rộng kinh người, cành liễu duy nhất sót lại kia trông như sợi xích thần bằng mây lục bích, hào quang ngập tràn bao trùm che chở cho cả thôn làng, khiến mảnh đất này trở nên mông lung như một vùng tiên thổ, trong chốn đại hoang cảm giác vô cùng thần bí.\n" +
            "\n" +
            "Nhà nhà trong thôn đều xây bằng đá. Đêm khuya thanh vắng, vẻ an lành yên ả của chốn này dường như tách biệt hẳn với bóng tối cùng tiếng mãnh thú gào thét bên ngoài.\n" +
            "\n" +
            "\"Hú uuuuu….\"\n" +
            "\n" +
            "Một trận cuồng phong thổi qua, có đám mây đen khổng lồ vắt ngang trời, che kín cả màn đêm, chắn nốt chút xíu ánh sao yếu ớt khiến dãy núi càng thêm tăm tối.\n" +
            "\n" +
            "Một tiếng chim kêu hung tợn từ trên cao vọng xuống, tiếng kêu sắc lẻm có sức xuyên thấu mạnh, không ngờ lại bắt nguồn từ đám mây đen kia. Nhìn kỹ, thì ra đó là một con chim khổng lồ to đến không tưởng, che lấp trăng sao, dài không biết bao nhiêu dặm.\n" +
            "\n" +
            "Đi qua Thạch Thôn, nó cúi đầu nhìn xuống, hai con mắt tựa như hai vầng trăng máu, hung khí ngút trời. Nó nhìn chằm chằm gốc liễu già trong chốc lát, cuối cùng bay về phía sâu nhất trong dãy núi.\n" +
            "\n" +
            "Yên ắng một lúc lâu mãi cho đến tận nửa đêm, mặt đất bắt đầu rung chuyển. Một bóng dáng mơ hồ từ phương xa bước tới, cao ngang đỉnh núi!\n" +
            "\n" +
            "Một hơi thở kì lạ lan tỏa, núi rừng lặng ngắt một cách chết chóc, hung cầm mãnh thú cúi rạp mình không dám phát ra một chút xíu âm thanh.\n" +
            "\n" +
            "Lại gần, đây là một sinh vật có hình người, dáng đứng thẳng, nó cao lớn vô cùng, sánh ngang đỉnh núi, toàn thân nó không có lông tóc gì mà dày đặc một lớp vảy vàng kim lấp lánh. Mặt nó phẳng lì, chỉ có một con mắt thẳng, mỗi lần chớp mở như có ánh sét vàng kim rạch qua, sắc bén ghê người. Toàn thân nó huyết khí mênh mông, tựa như một vị thần ma!\n" +
            "\n" +
            "Nó đi ngang qua chốn này, liếc nhìn gốc liễu, thoáng dừng chân rồi dường như đang vội vã lên đường, cuối cùng nhanh chóng bỏ đi. Vô vàn ngọn núi như đang rên rỉ dưới từng bước chân của nó, cả chốn núi rừng cũng bị uy thế ấy làm cho run rẩy.\n" +
            "\n" +
            "Bình minh lên, một con rết dài mười mét, thân to như thùng nước, tỏa ánh sáng bạc lấp lánh bò ngoằn ngoèo trong núi. Con rết như được đúc từ bạc trắng, mỗi một đốt đều sáng bóng dữ dằn, đập vào đá núi rầm rầm, tia lửa bắn tung tóe. Nhưng cuối cùng nó lại tránh qua Thạch Thôn mà không hề xâm nhập, nơi nó đi qua sương đen mịt mù, muông thú đều lẩn tránh.\n" +
            "\n" +
            "Một cành liễu mảnh mai tỏa ánh sáng bích hà óng ánh khẽ đung đưa trong gió….\n" +
            "\n" +
            "Chương 2: Triều khí bừng bừng\n" +
            "\n" +
            "– Thạch Thôn nằm trong dãy núi Thương Mãng, bốn bề núi cao khe lớn, quần thể núi non nguy nga kỳ vĩ trải ngút tầm nhìn.\n" +
            "\n" +
            "Sáng sớm, từng làn mây sớm trải xuống lấp lánh ánh vàng, khiến người ta cảm thấy ấm áp khi đắm mình trong đó/\n" +
            "\n" +
            "Một đám mấy chục đứa trẻ lớn nhỏ không đồng đều, khoảng từ bốn năm tuổi cho đến mười mấy tuổi đang đứng trên khoảng đất trống trước thôn, ngẩng mặt đón làn mây sớm, hì hục rèn luyện thân thể. Từng khuôn mặt non nớt lộ vẻ nghiêm túc, mấy đứa lớn hơn một chút thì hùng hổ lắm, tụi nhỏ hơn cũng đang khua khoắng khá là ra dáng.\n" +
            "\n" +
            "Một người đàn ông trung niên tráng kiện như hổ báo, mặc áo da thú, nước da màu đồng, tóc đen buông xõa, ánh mắt lấp lánh quan sát từng đứa trẻ, cẩn thận chỉ điểm cho chúng.\n" +
            "\n" +
            "\"Lúc mặt trời mới mọc là lúc vạn vật khởi đầu, sinh khí mạnh nhất, tuy không thể nuốt mây ngậm khí như trong truyền thuyết, nhưng rèn luyện thân thể dưới làn mây sớm cũng có ích lợi rất lớn. Có thể bồi đắp sinh cơ cho cơ thể. Trong một ngày chỉ có thời khắc sáng sớm này thôi, chịu khó dậy sớm chăm chỉ rèn luyện, cường gân tráng cốt, hoạt huyết luyện gân, về sau mới có vốn mà sinh tồn trong chốn mãng sơn này.\" Người trung niên đứng phía trước chỉ điểm đám trẻ nghiêm mặt nhắc nhở, sau đó quát: \"Các ngươi có hiểu không?\"\n" +
            "\n" +
            "\"Hiểu!\" Đám trẻ hăng hái cất giọng đáp lời.\n" +
            "\n" +
            "Trong núi hay có những sinh vật tiền sử xuất hiện. Có loài cánh lớn che trời bay ngang in bóng trải đầy mặt đất, cũng có những con hoang thú đứng trên đỉnh núi tru trăng, càng không thể thiếu những loài độc trùng bò lổn ngổn, vô cùng đáng sợ.\n" +
            "\n" +
            "\"Hiểu ạ.\" Một nhóc tì rõ ràng đã lơ đãng, chậm hẳn nửa nhịp thỏ thẻ lên tiếng.\n" +
            "\n" +
            "Đây là một chú nhóc rất nhỏ, chỉ khoảng một hai tuổi, mới biết đi chưa được bao lâu, thế mà cũng đi theo mọi người rèn luyện thân thể. Hiển nhiên chú nhóc tự mình bám theo trà trộn trong đám trẻ thôi chứ chưa đến tuổi xuất hiện trong đội ngũ này.\n" +
            "\n" +
            "\"Hô hô ha hi\" Chú nhóc bi bô, cánh tay non nớt ra sức múa may bắt chước động tác của lũ trẻ lớn hơn, nhưng vì nó còn quá nhỏ nên cứ xiêu xiêu vẹo vẹo, bước chân tập tễnh lắc lư, cộng thêm vệt sữa trăng trắng còn vương bên mép khiến mọi người phải bật cười.\n" +
            "\n" +
            "Đám trẻ lớn nhìn nó, ai nấy cau mày liếc mắt khiến cho bầu khoog khí rèn luyện nghiêm túc buổi sớm thoải mái hơn không ít.\n" +
            "\n" +
            "Chú nhóc trắng trẻo xinh xắn, đôi mắt đen láy xoay tròn trông như một con búp bê bằng sứ, đáng yêu vô cùng. Động tác non nớt cùng những tiếng bi bô trong miệng thật ngây ngô khờ khạo. Nhìn chú nhóc, mấy người già đang khoanh chân ngồi hít thở tinh khí đất trời trên những tảng đá lớn ở một khoảng đất khác cũng phải nở nụ cười.\n" +
            "\n" +
            "Ngay cả đám trai tráng trưởng thành thân hình vạm vỡ, ở trần để lộ cơ bắp cuồn cuộn cũng nhìn sang, ý cười lộ rõ. Họ là những người cường tráng nhất thôn, là lực lượng quan trọng nhất phụ trách săn bắn và bảo vệ thôn làng. Họ cũng đang rèn luyện, có người cầm cây gậy lớn mài từ xương cự thú, có người lại mang kiếm to bản rèn từ kim loại màu đen ra sức múa, tiếng gió nổi lên như sấm.\n" +
            "\n" +
            "Hoàn cảnh sinh tồn vô vùng khốc liệt, quá nhiều hồng hoang mãnh thú độc trùng, để kiếm cái ăn, để sống sót, có rất nhiều trai tráng chưa kịp trưởng thành đã chết yểu trong chốn đại hoang. Muốn sống, chỉ có không ngừng làm mạnh bản thân. Rèn luyện buổi sớm đã trở thành thói quen của mỗi người, từ người trưởng thành đến người già và trẻ nhỏ.\n" +
            "\n" +
            "\"Thu tâm!\" Người trung niên phụ trách kèm cặp chỉ dạy lũ trẻ lớn tiếng hô. Đám trẻ vội vàng tập trung chú ý, tiếp tục rèn luyện dưới làn mây sớm nhu hòa lấp lánh.\n" +
            "\n" +
            "\"Phù… ôi cha… mệt quá.\" Chú nhóc thở phào một hơi ngồi phịch xuống đất nhìn đám trẻ lớn rèn luyện thể phách, nhưng chỉ một chốc nó liền phân tán sự chú ý, đứng dậy bập bễnh chạy về phía một con chim sẻ năm màu đang nhảy nhót cách đó không xa, cuối cùng lại liên tục vấp ngã phịch mông xuống đất, nhưng nó không khóc mà tức tối lồm cồm bò dậy tiếp tục đuổi theo.\n" +
            "\n" +
            "\"Được rồi, thu công!\"\n" +
            "\n" +
            "Sau một tiếng hô lớn, tất cả lũ trẻ đồng loạt reo hò, xoa nắn chân tay nhức mỏi rồi chạy ùa đi về phía nhà mình chuẩn bị ăn cơm sáng.\n" +
            "\n" +
            "Người già cười xòa, cũng đứng dậy khỏi phiến đá lớn. Còn đám thanh niên trai tráng như hổ báo kia thì vừa cười vừa mắng, trêu chọc con mình, cầm cốt bổng cùng đại kiếm rảo bước về nhà.\n" +
            "\n" +
            "Thạch Thôn không lớn, già trẻ trai gái cộng lại được khoảng hơn ba trăm người, nhà cửa đểu dựng từ đá tảng, đơn sơ một cách tự nhiên.\n" +
            "\n" +
            "Đầu thôn có một gốc cây sét đánh bự chảng, đường kính hơn chục mét, lúc này trên cành liễu duy nhất của thân cây đã thu hết ánh hào quang trong làn mây sớm, trở nên rất đỗi bình thường.\n" +
            "\n" +
            "\"Oa, có cả thịt Thổ Long nữa, cho xin một miếng!\"\n" +
            "\n" +
            "Đám trẻ đứa nào cũng hoạt bát hiếu động, cả lúc ăn cơm cũng không chịu ngồi yên, nhiều đứa ôm bát từ nhà mình ra xúm lại.\n" +
            "\n" +
            "Xung quanh Thạch Thôn cây cỏ um tùm và có nhiều thú dữ, có điều tuy ở bên núi nhưng thức ăn của dân làng cũng không quá phong phú, chỉ có mấy món bánh lúa mạch thô, quả dại cùng chút thịt trong bát lũ trẻ.\n" +
            "\n" +
            "Trên thực tế, thiếu thốn đồ ăn luôn là một vấn đề rất nghiêm trọng của Thạch Thôn. Trong núi vô cùng nguy hiểm, đám dị thú hung cầm quá mạnh và đáng sợ, mỗi lần đi săn đều có khả năng thiệt hại về người.\n" +
            "\n" +
            "Nếu được chọn lựa, dân làng không ai muốn vào trong núi, vì vào trong đó có nghĩa là sẽ có nguy cơ đổ máu và hi sinh.\n" +
            "\n" +
            "Thức hăn đối với họ vô cùng quý giá, không được phép lãng phí. Mỗi đứa trẻ từ nhỏ đã hiểu điều này, đói, thức ăn, săn bắn, tính mạng, máu tươi, tất cả đều liên kết với nhau.\n" +
            "\n" +
            "Nhà lão tộc trưởng Thạch Vân Phong ở đầu thôn được ghép từ đá tảng lớn, kề sát gốc liễu già cháy đen. Một thứ chất lỏng màu trắng sôi sung trục trong ang gốm trên bếp lò trong sân nhà, mùi sữa thơm nức. Lão đang nấu sữa thú, thi thoảng lại bỏ vào một chút dược thảo, dùng thìa gỗ khuấy nhẹ.\n" +
            "\n" +
            "Chẳng mấy chốc, ông lão gọi: \"Nhóc con, mau lại ăn nào.\"\n" +
            "\n" +
            "Chú nhóc mất cha mẹ từ khi mới nửa tuổi, bú sữa bách thú lớn lên, nay đã được một năm mấy tháng. Nếu là trẻ con bình thường lẽ ra đã cai sữa từ lâu, nhưng nó vẫn thích ăn lắm, không chịu cai, thường xuyên bị mấy đứa lớn chê cười.\n" +
            "\n" +
            "\"Ôi cha… phù…không chạy nổi nữa.\" Nó nãy giờ cứ mải miết đuổi theo con chim sẻ năm màu, giờ đang thở hổn hển, ngồi phịch mông xuống đất.\n" +
            "\n" +
            "\"Nhóc con bú sữa nào!\" Đám trẻ lớn hùa trêu.\n" +
            "\n" +
            "\"Đám khỉ con tụi bây có đứa nào chưa từng qua độ tuổi này hả?\" Lão tộc trưởng cười mắng.\n" +
            "\n" +
            "\"Bọn cháu đâu có một tuổi rưỡi rồi mà vẫn bú sữa, hi hi.\"\n" +
            "\n" +
            "Bị đám trẻ lớn chọc quê, chú nhóc cười ngây ngô, đôi mắt to đen láy tít lại thành hình trăng lưỡi liềm, hoàn toàn không để bụng. Nó ngồi xuống bên ang dùng muoi gỗ múc sữa uống ngon lành.\n" +
            "\n" +
            "Ăn sáng xong, mấy người già lớn tuổi trong thôn cùng đến nhà tộc trưởng Thạch Vân Phong, tuy râu tóc đã bạc phơ nhưng tinh khí thần vẫn còn sung túc lắm.\n" +
            "\n" +
            "\"Dạo này không ổn lắm, nửa đêm hay có bọn lớn xác đi qua, động tĩnh quá lớn, chắc chắn sâu trong núi đã xảy ra chuyện gì đó.\"\n" +
            "\n" +
            "\"Ừm, đêm qua tôi bị đánh thức mấy lần, sởn hết xương cốt, nhất định là có hồng hoang hung thú đại trùng đi ngang qua đây.\"\n" +
            "\n" +
            "Mấy người già lần lượt lên tiếng, người chau mày kẻ trầm tư, thảo luận những dấu hiệu nguy hiểm thời gian gần đây, cảm thấy đã phát sinh chuyện gì đó không tầm thường.\n" +
            "\n" +
            "\"Tôi thấy sâu trong Đại Hoang có khả năng đã xuất hiện thứ gì đó không tầm thường thu hút sự chú ý của một vài chủng tộc sót lại từ Thái Cổ ở quanh đây, khiến chúng lũ lượt kéo đến.\" Lão tộc trưởng Thạch Vân Phong trầm ngâm nói.\n" +
            "\n" +
            "\"Có lẽ nào đã xuất hiện sơn bảo?\" Một ông lão bỗng trợn mắt, rầu tóc dựng lên, mặt sửng sốt.\n" +
            "\n" +
            "Những người còn lại ai cũng lộ vẻ kì quái, ánh mắt hau háu, nhưng nhanh chóng ngọn lửa trong mắt họ tắt vụt, đó không phải là thứ mà họ có thể đoạt được, ở sâu trong núi, không ai có thể đi vào.\n" +
            "\n" +
            "Bao nhiêu năm nay chưa từng có ai sống sót đi ra, trong núi có vô vàn loài đáng sợ, cho dù toàn thể người dân Thạch Thôn cùng xông vào thì cũng không ăn thua gì.\n" +
            "\n" +
            "\"Tộc trưởng, đã nhiều ngày rồi chúng ta chưa vào núi.\" Đúng lúc này, một người đàn ông vạm vỡ bước vào nhà, anh ta là thủ lĩnh đội săn, cũng là tộc trưởng đời sau của Thạch Thôn.\n" +
            "\n" +
            "\"Dạo này không được thái bình cho lắm.\" Lão tộc trưởng Thạch Vân Phong chau mày.\n" +
            "\n" +
            "\"Nhưng thực sự sắp hết thức ăn rồi.\" Thạch Lâm Hổ nói, thân hình y cực cao lớn, hơn hai mét, lưng đeo một thanh đại kiếm nặng hơn ba trăm cân, trông y giống như một người gấu, da màu đồng, cơ bắp cuồn cuộn như từng con trăn đang di chuyển. truyện được lấy tại TruyenFull.vn\n" +
            "\n" +
            "\"Lũ trẻ cần phát triển, không thể chịu đói. Phải nghĩ cách.\" Có ông lão lên tiếng.\n" +
            "\n" +
            "\"Tuy về đêm không được yên ổn lắm, nhưng ban ngày cũng không có điều khác thường nào. Tôi dẫn thêm vài người, cẩn thận một chút chắc sẽ không sao.\" Thạch Lâm Hổ nói.\n" +
            "\n" +
            "Cuối cùng, mấy chục gã thanh niên trai tráng tụ tập lại ở đầu thôn, do tộc trưởng Thạch Vân Phong dẫn đầu đến trước thân cây sét đánh, nghiêm trang cầu khấn trước gốc liễu già.\n" +
            "\n" +
            "\"Tế Linh, xin hãy bảo hộ tộc nhân, để lũ trẻ săn được thịt thú béo tốt, bình an trở về. Chúng tôi sẽ dâng hiên trái tim thành kính, đời đời cúng tế phụng dưỡng người.\"\n" +
            "\n" +
            "Chương 3: Cốt văn\n" +
            "\n" +
            "Trong khi tộc trưởng và các vị bô lão cầu khấn, tất cả thanh niên trai tráng ai cũng lộ vẻ trịnh trọng, tiến hành lễ bái. Không ít phụ nữ cũng đến lặng lẽ cầu nguyện, cầu cho người thân của mình được trở về an toàn sau chuyến đi săn.\n" +
            "\n" +
            "Trong núi quá nguy hiểm, rời khỏi thôn làng được cây liễu già bảo hộ, bên ngoài sẽ là một thế giới hoàn toàn khác, ở đó đầy rẫy những con mãnh cầm và cự thú vô cùng đáng sợ.\n" +
            "\n" +
            "Và rồi cứ thế, một toán người khỏe mạnh nhất thôn vác cung tên lớn trên vai, mang theo đại kiếm lên đường tiến vào trong chốn núi sâu rừng rậm, một luồng hơi thở của đại hoang tức thì ập tới.\n" +
            "\n" +
            "Dõi mắt tiễn đội săn ra đi, lão tộc trưởng Thạch Vân Phong dẫn lũ trẻ về lại bãi cỏ đầu thôn, khoanh chân ngồi xuống nói: \"Được rồi, đám khỉ con các cháu cũng cần chăm chỉ học tập đó.\"\n" +
            "\n" +
            "Đám trẻ lập tức xị mặt, đứa nào đứa nấy không còn hứng thú gì hết, miễn cưỡng ngồi quanh lão, ỉu xìu như một mớ lá cây phơi héo.\n" +
            "\n" +
            "\"Tộc trưởng gia gia, mấy chữ kì cục đó phức tạp như bùa bắt ma ấy, khó học lắm, phải dụng tâm ghi nhớ làm gì ạ?\"\n" +
            "\n" +
            "\"Đúng thế, còn chẳng hữu ích bằng tiễn pháp cha dạy cháu!\"\n" +
            "\n" +
            "Đám trẻ toàn bộ đều xịu mặt, có vẻ rất chán ghét.\n" +
            "\n" +
            "\"Lũ nhóc các cháu thật không hiểu chuyện, cốt văn là những kí tự hiển hóa bẩm sinh trên xương cốt của một chủng tộc mạnh mẽ thời Thái Cổ, ẩn chứa sức mạnh thần bí khó dò, bao nhiêu người muốn học còn không có đường học đó. Chỉ cần học thành tài, không biết còn mạnh hơn thế hệ cha chú các cháu bao nhiêu lần đâu.\" Lão tộc trưởng ngán ngẩm chê trách chúng.\n" +
            "\n" +
            "\"Tộc trưởng gia gia, ông hãy biểu diễn cho chúng cháu xem thử sức mạnh của cốt văn đi.\" Một đứa nhóc choai choai lên tiếng.\n" +
            "\n" +
            "\"Nhóc tì lại đây.\" Lão tộc trưởng gọi với ra xa.\n" +
            "\n" +
            "Chú nhóc đã đuổi con chim sẻ năm màu xong, đang ra sức giựt đuôi một con chó vàng lớn, nghe tiếng liền ngơ ngác quay đầu, buông thay lon ton chạy tới, chớp chớp đôi mắt sáng ngời: \"Ui cha ui cha, tộc trưởng gia gia có chuyện gì ạ?\"\n" +
            "\n" +
            "\"Hãy đem cốt văn ta dạy cho cháu sử dụng ra xem.\" Thạch Vân Phong nói.\n" +
            "\n" +
            "\"Vâng ạ.\" Nhóc tỳ rất vâng lời, nó giơ hai bàn tay bé xíu, ngậm miệng lại, toàn thân không ngừng dùng sức, khuôn mặt nhỏ nhắn đỏ bừng lên.\n" +
            "\n" +
            "\"Bùm\" một tiếng, lòng bàn tay nó xuất hiện một quầng sáng, một kí tự kì lạ nổi lên, giống như được đúc bằng kim loại, bóng bẩy và thực chất. Liền đó, trên bàn tay kia cũng xuất hiện.\n" +
            "\n" +
            "Nhóc tì bước lên hai bước, nhấc bổng một khối đá xanh còn cao hơn cả mình lên.\n" +
            "\n" +
            "\"Lợi hại quá!\" Lũ trẻ reo lên kinh ngạc, một đứa bé mới hơn một tuổi, làm thế nào mà nhấc được một hòn đá lớn ngần này?\n" +
            "\n" +
            "\"Nhóc tỳ, có phải đệ đã dùng hết cả sức bú sữa ra rồi không?\" Mấy đứa lớn trêu.\n" +
            "\n" +
            "\"Ui cha, vâng ạ, dùng hết sạch cả rồi.\" Nhóc tỳ ném hòn đá xuống, ngồi phịch ra nền cười rất vô tư thuần khiết, kí tự trên tay nó cũng nhanh chóng mờ dần rồi biến mất.\n" +
            "\n" +
            "\"Tộc trưởng gia gia, đây chính là sức mạnh của cốt văn thần bí mà ông nghiên cứu suốt mười mấy năm nay ư?\" Lũ trẻ sáng mắt lên, hoàn toàn khác hẳn vẻ ủ ê lúc nãy.\n" +
            "\n" +
            "\"Đừng hưng phấn vội, những thứ này chỉ có thể đưa các cháu lên đường mà thôi, so với Thiên Cốt Văn xuất hiện trong truyền thuyết thời cổ đại thì còn kém xa nhiều lắm.\" Ông lão gật đầu rồi lại lắc đầu.\n" +
            "\n" +
            "\"Tộc trưởng gia gia, ông kể chuyện thế giới bên ngoài cho chúng cháu nghe đi.\" Đám trẻ tỏ vẻ háo hức.\n" +
            "\n" +
            "Người trong thôn ai cũng biết lão tộc trưởng hồi còn trẻ từng cùng với mười mấy vị tộc nhân cường đại trong thôn đi đến tận cùng mặt đất xa xôi, từng xông pha ở thế giới bên ngoài.\n" +
            "\n" +
            "Thế nhưng mười mấy năm trước, chỉ có hai người toàn thân đẫm máu trở về, một trong số đó không lâu sau thì chết, chỉ có một mình Thạch Vân Phong sống sót.\n" +
            "\n" +
            "Mấy năm nay, lão vẫn luôn nghiên cứu cốt văn thần bí, thi thoảng lại lấy mấy người có thể chất khỏe mạnh trong thôn ra làm thí nghiệm. Lũ trẻ biết rõ, những bậc cha chú khỏe như rồng như hổ của chúng mỗi lần bị gọi đến căn nhà đá kia đều phát ra những tiếng gào thê thảm đến rùng mình, khiến lũ trẻ này từ bé đã nảy sinh lòng sợ hãi cùng lảng tránh.\n" +
            "\n" +
            "Đến tận dạo gần đây việc nghiên cứu của lão tộc trưởng mới giãn ra, nhờ đó mà dân làng cùng đỡ sợ. Thêm nữa, nhóc tỳ bú sữa bách thú và ăn chực trăm nhà được lão nhận nuôi, trở thành đối tượng nghiên cứu tốt nhất.\n" +
            "\n" +
            "\"Thế giới bên ngoài ư…\" Lão tộc trưởng lộ vẻ hồi ức, sau một thoáng xuất thần mới nói: \"Thế giới bên ngoài quá lớn, bát ngát vô bờ, từ vùng này qua vùng khác là hàng trăm vạn dặm, không ai biết chính xách rộng bao nhiêu, một người có đi cả đời mình cũng không ra khỏi một vùng. Đại hoang mênh mông vô tận, loài người ở những vùng khác nhau rất khó có thể liên lạc với nhau vì thực sự quá nguy hiểm. Trên mặt đất có vô vàn chủng tộc mạnh mẽ, đáng sợ và thần bí, cho dù là bộ lạc mấy chục vạn người hoặc một cự thành hùng vỹ cũng có khả năng bị mấy con thú thuộc chủng tộc sót lại từ thời thái cổ phá hủy tan tành. Đương nhiên, cũng có loài người mạnh đến mức không thể nào tưởng tượng, không hề thua kém chiến lực tuyệt đỉnh của những chủng tộc khác, thần uy vô địch, xứng danh bậc thiên kiêu của loài người.\"\n" +
            "\n" +
            "Đám trẻ sinh lòng kính sợ, đồng thời cũng vô cùng khao khát, thấy tò mò trước thế giới mình không biết. Có đứa hỏi: \"Núi sông này có địa bảo tiên dược gì có thể khiến người ta thoát thai hoán cốt sau một đêm không? Thiên kiêu lợi hại nhất loài người uy thế lớn tới cỡ nào ạ?\"\n" +
            "\n" +
            "Ông lão cười nói: \"Muốn biết thì hãy khiến bản thân mình mạnh lên trước đã.\"\n" +
            "\n" +
            "\"Nếu chúng cháu nắm vững sức mạnh thần bí của cốt văn thì sẽ có thể đi xông pha khắp thiên hạ được phải không ạ?\" Mấy đứa nhóc lộ vẻ mơ màng.\n" +
            "\n" +
            "Thạch Vân Phong xoa đầu một đứa trẻ, đáp: \"Chưa nói đến các vùng khác, chỉ một vùng của chúng ta đây thôi, nếu có ai đi hết một nửa cương thổ đã tài giỏi lắm rồi!\"\n" +
            "\n" +
            "Lũ trẻ toàn bộ đều ngẩn người.\n" +
            "\n" +
            "\"Điều ta có thể làm chỉ là dẫn các cháu lên đường, còn sau này đi được đến bước nào đều phải dựa vào bản thân các cháu. Những thứ ta dạy các cháu chắc cũng không thua kém gì lũ trẻ đồng trang lứa ở thế giới bên ngoài.\" Ông lão nói hết câu, ánh mắt lộ ra một thứ ánh sáng khác thường, tay sờ miếng ngọc cốt kì dị cất trong ngực áo.\n" +
            "\n" +
            "Lũ trẻ ngồi quanh lão tộc trưởng, cuối cùng cũng trật tự chăm chú nghe lời dạy bảo cho đến tận trưa mới giải tán ra về. xem tại TruyenFull.vn\n" +
            "\n" +
            "\"Khó quá đi, tộc trưởng không ngờ lại nói phải mất mấy năm mới có vài người cá biệt hóa được cốt văn vào trong cơ thể, còn đại đa số sẽ mãi mãi không thể thành công.\"\n" +
            "\n" +
            "\"Nhưng nhóc tỳ mới nhỏ xíu như hạt đậu, đệ ấy làm được kia mà.\"\n" +
            "\n" +
            "Chú nhóc chớp mắt ngây thơ vô tội, rồi tiếp tục đi giựt đuôi con chó vàng kia, con chó sủa uông uông còn vô tội hơn nữa.\n" +
            "\n" +
            "Mặt trời ngả bóng, trong ánh tịch dương, cả Thạch Thôn như bị nhuộm trong một tầng ánh sáng màu vàng nhạt. Xa xa vẳng đến tiếng hổ kêu vượn hú, còn những ngôi nhà đá ở đây lại yên bình tựa như những tòa thấn miếu từ thời viễn cổ.\n" +
            "\n" +
            "Mấy chục người xuất hiện ở đường chân trời, ánh chiều tà kéo bóng họ dài lê thê, thân hình họ bị ráng chiều phủ lên từng đường viền lấp lánh trông cao lớn và hùng vĩ vô cùng. Gần như ai cũng kéo theo một con mãnh thú khổng lồ, căng đầy thu hoạch.\n" +
            "\n" +
            "\"Về rồi!\" Đám phụ nữ đứng đợi ở đầu thôn từ rất lâu rồi, họ reo lên vui sướng, nỗi bất an sợ hãi trong lòng biến mất ngay lập tức. Họ cất tiếng gọi vang.\n" +
            "\n" +
            "\"Cha lũ trẻ bình an trở về rồi!\"\n" +
            "\n" +
            "\"Trời ơi, không ngờ lại săn được nhiều đến thế, quả là vụ thu hoạch lớn chưa từng có!\"\n" +
            "\n" +
            "Chuyến đi săn này hết sức thành công, mấy chục người đàn ông ai cũng có thu hoạch, trong đống thú săn có voi sừng rồng khổng lồ, có con Quỳ Thú một chân hình dạng giống con trâu, còn có cả con Phi Mãng mọc cánh to như thùng nước….\n" +
            "\n" +
            "Bô lão trong thôn ai cũng ngạc nhiên, những sinh vật này ngày thường rất khó đối phó, có những con được coi là hung thú, vậy mà nay lại bị liệp sát nhiều như vậy, máu loang lốm đốm, thực sự nằm ngoài ý liệu của mọi người.\n" +
            "\n" +
            "Ví dụ như con voi sừng rồng kia, thân voi cứng như sắt, ngọn giáo sắt khó mà chọc thủng, cặp sừng rồng sắc nhọn như lưỡi dao kim cương, dễ dàng đập vụn đá tảng thành bột phấn. Còn con Quỳ Thú nọ tiếng vang như sấm, nếu ở gần có thể chấn chết người ta. Con Phi Mãng mọc cánh là sát thủ sơn lâm, có thể bất thình lình nhào xuống từ trên đỉnh núi, cực kì đáng sợ.\n" +
            "\n" +
            "Trong mớ thu hoạch còn có cả những sinh vật lợi hại hơn nữa, ví như con Hỏa Tê hai đầu toàn thân đỏ rực, con Tì Hưu huyết mạch không thuần chủng … chúng đều là những loài hung thú trứ danh, phát hiện ra chúng đều cần tránh xa đi đường vòng né tránh, vậy mà nay đều bị liệp sát rồi, điều này vô cùng trái với lẽ thường!\n" +
            "\n" +
            "\"Chuyến này thực sự vô cùng may mắn, cả đoàn ai cũng đầy túi trở về mà không ai bị thương.\" Thạch Lâm Hổ thủ lĩnh đội săn cất tiếng cười sảng khoái giải thích với tộc trưởng và dân làng. Mấy đêm vừa rồi, trong núi có cự thú siêu cấp đi qua khiến đất trời rung chuyển, dẫm chết và bị thương vô số thú rừng. Ban ngày họ lần theo giết chết không ít hung thú trọng thương, chúng đều là những sinh vật cường hoành mà ngày thường dân làng phải né tránh.\n" +
            "\n" +
            "\"Trong núi có mấy dấu chân lớn hình dạng giống chân người, nhưng thực sự quá lớn, dài đến gần trăm mét!\"\n" +
            "\n" +
            "\"Lớn vậy sao?\" Dân làng trầm trồ, đây đúng là một tin đáng sợ.\n" +
            "\n" +
            "Ngay cả các bô lão nghe nói đều thót dạ, càng thêm chắc chắn sâu trong núi đã phát sinh chuyện bất thường thu hút những chủng tộc sót lại từ Thái Cổ ở xung quanh Đại Hoang tìm đến.\n" +
            "\n" +
            "Mặc kệ nói thế nào thì thu hoạch lần này cũng khiến toàn thể tộc nhân mừng rỡ, Thạch Thôn tràn ngập tiếng cười đùa của trẻ con, bầu không khí khắp nơi đều vui sướng.\n" +
            "\n" +
            "Tộc trưởng Thạch Vân Phong dẫn mọi người đi về phía gốc liễu già, vác theo xác mấy chục con thú, đặt toàn bộ lũ hung thú dính đầy vết máu lên trên bục đá, rõ ràng đây là một đài tế cỡ lớn.','https://vcdn.kenhgamevn.com/wp-content/uploads/2021/09/29060946/game4v-the-gioi-hoan-my-2-1632366655-71.jpeg',1)";
    private String SQLQuery6 = "INSERT INTO truyen VALUES (null,'ĐẤU PHÁ THƯƠNG KHUNG','Chương 1: Thiên tài rơi rụng\n" +
            "\n" +
            "\"Đấu lực, ba đoạn\"\n" +
            "\n" +
            "Nhìn năm chữ to lớn có chút chói mắt trên trắc nghiệm ma thạch, thiếu niên mặt không chút thay đổi, thần sắc tự giễu, nắm chặt tay, bởi vì dùng lực quá mạnh làm móng tay đâm thật sâu vào trong lòng bàn tay, mang đến từng trận trận đau đớn trong tâm hồn...\n" +
            "\n" +
            "\"Tiêu Viêm, đấu lực, ba đoạn! Cấp bậc: Cấp thấp!\".\n" +
            "\n" +
            "Bên cạnh trắc nghiệm ma thạch, một vị trung niên nam tử, thoáng nhìn tin tức trên bia, ngữ khí hờ hững công bố…\n" +
            "\n" +
            "Trung niên nam tử vừa nói xong, không có gì ngoài ý muốn, đám người trên quảng trường lại nổi lên trận trận châm chọc tao động\n" +
            "\n" +
            "\"Ba đoạn? Hắc hắc, quả nhiên không ngoài dự đoán của ta, \"\"Thiên tài\" này một năm rồi vẫn dậm chân tại chỗ a!\"\n" +
            "\n" +
            "\"Ai, phế vật này thật sự làm mất hết cả mặt mũi gia tộc.\"\n" +
            "\n" +
            "\"Nếu tộc trưởng không phải phụ thân của hắn. Loại phế vật này sớm đã bị đuổi khỏi gia tộc, tự sinh tự diệt rồi, làm gì còn có cơ hội ở gia tộc ăn không uống không.\"\n" +
            "\n" +
            "\"Ai..., thiên tài thiếu niên năm đó của Văn Ô Thản thành, tại sao hôm nay lại lạc phách thành bộ dáng này cơ chứ?\"\n" +
            "\n" +
            "\"Ai mà biết được? Có lẽ do làm việc gì đó trái với lương tâm, làm thần linh nổi giận đó mà…\"\n" +
            "\n" +
            "Chung quanh truyền đến cười nhạo cùng thanh âm tiếc hận, dừng ở trong tai của thiếu niên, tựa như một chiếc dao nhọn hung hăng đâm vào tim hắn, khiến hô hấp của thiếu niên trở nên có chút dồn dập.\n" +
            "\n" +
            "Thiếu niên chậm rãi ngẩng đầu, lộ ra khuôn mặt thanh tú non nớt, con ngươi đen nhánh nhẹ nhàng đảo qua đám bạn cùng lứa tuổi đang trào phúng chung quanh, khóe miệng thiếu niên tự giễu, tựa hồ trở nên càng thêm chua xót.\n" +
            "\n" +
            "\"Những người này, đều thừa hơi như vậy sao? Có lẽ vì ba năm trước bọn họ từng trước mặt mình lộ ra bộ mặt tươi cười nhún nhường, cho nên hiện tại muốn đòi trở về đây mà…\" Mỉm cười chua xót, Tiêu Viêm chán nản xoay người, im lặng đi tới cuối hàng, thân ảnh cô đơn cùng thế giới xung quanh trở nên có chút lạc lõng.\n" +
            "\n" +
            "\"Người tiếp theo, Tiêu Mị\"\n" +
            "\n" +
            "Nghe người tiến hành trắc nghiệm gọi tên, một thiếu nữ rất nhanh từ trong đám người đi ra, tiếng nghị luận ở xung quanh trở nên nhỏ đi rất nhiều, từng đạo ánh mắt nóng bỏng tập trung lên trên khuôn mặt của thiếu nữ…\n" +
            "\n" +
            "Thiếu nữ tuổi không quá mười bốn, dù chưa thể coi là tuyệt sắc, nhưng khuôn mặt non nớt kia cũng ẩn chứa trong đó một tia vũ mị nhàn nhạt, thanh thuần cùng vũ mị, một tập hợp mâu thuẫn, càng khiến nàng trở thành tiêu điểm của toàn trường…\n" +
            "\n" +
            "Thiếu nữ nhanh chóng đi lên, tay vuốt ve ma thạch bi quen thuộc, sau đó chậm rãi nhắm mắt…\n" +
            "\n" +
            "Tại lúc thiếu nữ nhắm mắt, ma thạch bi đen nhánh lại hiện lên quang mang…\n" +
            "\n" +
            "\"Đấu khí: Bảy đoạn!\"\n" +
            "\n" +
            "\"Tiêu Mị, Đấu khí: Bảy đoạn! Cấp bậc: Cao cấp\"\n" +
            "\n" +
            "\"Da!\" Nghe trắc ngiệm viên đọc lên thành tích, thiếu nữ ngẩng mặt lên đắc ý cười…\n" +
            "\n" +
            "\"Sách sách, bảy đoạn đấu khí, cứ theo tiến độ như vậy, chỉ sợ không quá ba năm thời gian, nàng có thể trở thành một đấu giả chính thức rồi…\"\n" +
            "\n" +
            "\"Không hổ là hạt giống của gia tộc a…\"\n" +
            "\n" +
            "Nghe đám người truyền đến trận trận thanh âm hâm mộ, thiếu nữ tươi cười lại rạng rỡ thêm vài phần, tâm hư vinh, là thứ mà rất nhiều cô gái đều không thể kháng cự…\n" +
            "\n" +
            "Nhớ đến ngày thường hay cùng mấy tỷ muội đàm tiếu, tầm mắt Tiêu Mị bỗng nhiên xuyên qua đám người, dừng trên một đạo thân ảnh cô đơn…\n" +
            "\n" +
            "Nhíu mày suy nghĩ một chút, Tiêu Mị vứt bỏ ý niệm trong đầu, hiện tai hai người đã không còn cùng một giai tầng, lấy biểu hiện của Tiêu Viêm mấy năm này, sau khi trưởng thành, nhiều nhất cũng chỉ có thể làm nhân viên hạ tầng của gia tộc mà thôi, mà thiên phú vĩ đại như nàng, sẽ trở thành trọng điểm bồi dưỡng của gia tộc, có thể nói là tiền đồ không thể hạn lượng.\n" +
            "\n" +
            "\"Ai…\" Khẽ thở dài một tiếng, trong đầu Tiêu Mị bỗng hiện ra hình ảnh một thiếu niên ý khí phong phát ba năm trước đây, bốn tuổi luyện khí, mười tuổi có chín đoạn đấu khí, mười một tuổi đột phá mười đoạn đấu khí, ngưng tụ thành công đấu khí toàn, trở thành đấu giả trẻ nhất trong vòng trăm năm của gia tộc!\n" +
            "\n" +
            "Thiếu niên trước kia, bộ dáng tự tin lại thêm tiềm lực không thể hạn lượng, không biết đã làm bao cô gái động xuân tâm, đương nhiên trong đó cũng có cả Tiêu Mị.\n" +
            "\n" +
            "Nhưng con đường của thiên tài, từ trước đến giờ luôn luôn trắc trở, ba năm trước, khi danh vọng của thiếu niên thiên tài đạt tới đỉnh cao nhất, cũng là lúc đột ngột phải thừa nhận đả kích tàn khốc nhất, không chỉ có vừa vất vả khổ tu ngưng tụ đấu khí toàn trong một đêm biến mất, mà đấu khí theo thời gian trôi qua lại càng trở nên càng ngày càng ít đi một cách quỷ dị.\n" +
            "\n" +
            "Kết quả của đấu khí biến mất, đó chính là thực lực không ngừng giảm đi.\n" +
            "\n" +
            "Từ thiên tài, một đêm trở thành một thứ mà ngay cả người bình thường cũng không bằng, loại đả kích này, khiến thiếu niên từ đó thất hồn lạc phách, cái tên thiên tài, cũng dần dần bị khinh thường cùng châm chọc thay thế.\n" +
            "\n" +
            "Trèo càng cao, ngã càng đau, lần ngã này có lẽ sẽ không còn cơ hội đứng dậy nữa.\n" +
            "\n" +
            "\"Người tiếp theo, Tiêu Huân Nhi!\"\n" +
            "\n" +
            "Trong âm thanh huyên náo của đám người, thanh âm của trắc nghiệm viên lại vang lên.\n" +
            "\n" +
            "Theo đó là một cái tên thanh nhã vang lên, đám người bỗng trở nên im lặng, ánh mắt đều dịch chuyển.\n" +
            "\n" +
            "Tại nơi ánh mắt tụ hội, một thiếu nữ áo tím đang đạm nhã đứng đó, khuôn mặt non nớt bình tĩnh, không vì bị mọi người chú ý mà thay đổi chút nào.\n" +
            "\n" +
            "Thiếu nữ khí chất lãnh đạm tựa như đóa sen mới nở, tuổi nhỏ đã có khí chất thoát tục, khó có thể tưởng tượng sau này lớn lên, thiếu nữ này sẽ khuynh quốc khuynh thành đến mức độ nào…\n" +
            "\n" +
            "Tử y thiếu nữ này, nói về mỹ mạo cùng khí chất, so với Tiêu Mị trước đó lại càng hơn vài phần, khó trách mọi người đều có động tác như vậy.\n" +
            "\n" +
            "Khẽ bước tới, thiếu nữ tên Tiêu Huân Nhi đi tới phía trước ma thạch bi, bàn tay nhỏ bé đưa lên, ống tay áo theo đó mà chảy xuống, lộ ra da thịt trắng nõn nà, sau đó đặt nhẹ tay lên bia đá…\n" +
            "\n" +
            "Sau một khoảng trầm tĩnh, trên thạch bia hiện lên ánh sáng chói mắt.\n" +
            "\n" +
            "\"Đấu khí: Chín đoạn! Cấp bậc: Cao cấp!\"\n" +
            "\n" +
            "Nhìn mấy chữ trên thạch bia, giữa sân trở nên tĩnh lặng.\n" +
            "\n" +
            "\"…Đã tới chín đoạn rồi, thật là khủng bố mà! Người đứng đầu trong giới trẻ của gia tộc, chỉ sợ không ai ngoài Huân Nhi tiểu thư a.\" Yên tĩnh qua đi, các thiếu niên xung quanh đều không tự chủ được nuốt một ngụm nước miếng, ánh mắt tràn ngập kính sợ…\n" +
            "\n" +
            "Đấu khí, con đường bắt buộc phải đi qua của mỗi đấu giả, sơ giai đấu khí chia từ một đến mười đoạn, đấu khí trong cơ thể đạt tới mười đoạn, là có thể ngưng tụ đấu khí toàn, trở thành một đấu giả được người khác tôn trọng.\n" +
            "\n" +
            "Trong đám người, Tiêu Mị nhíu mày nhìn cô gái áo tím đứng trước bia đá, trên mặt hiện lên một tia ghen tị…\n" +
            "\n" +
            "Nhìn tin tức trên thạch bia, khuôn mặt hờ hững của trung niên trắc nghiệm viên bên cạnh cũng lộ ra một tia mỉm cười hiếm hoi, đối với cô gái thoáng dùng âm thanh cung kính nói: \"Huân Nhi tiểu thư, nửa năm sau, tiểu thư hẳn sẽ có thể ngưng tụ đấu khí toàn, nếu thành công, mười bốn tuổi trở thành một đấu giả chân chính, tiểu thư sẽ là người thứ hai của Tiêu gia trong trăm năm nay!\"\n" +
            "\n" +
            "Đúng vậy, người thứ hai, người thứ nhất đó chính là thiên tài đã mất đi ánh hào quang - Tiêu Viêm.\n" +
            "\n" +
            "\"Cám ơn.\" Thiếu nữ khẽ gật đầu, khuôn mặt bình thản không vì được hắn khích lệ mà vui sướng, im lặng xoay người, dưới ánh mắt nóng bỏng của mọi người, chậm rãi đi đến cuối đám người, tới trước mặt thiếu niên đang suy sụp…\n" +
            "\n" +
            "\"Tiêu Viêm ca ca.\" Tại lúc đến bên cạnh thiếu niên, thiếu nữ dừng chân, đối với Tiêu Viêm cung kính cúi người, trên khuôn mặt xinh đẹp, cư nhiên lộ ra nụ cười thanh nhã khiến các cô gái chung quanh cũng phải trở nên ghen tị.\n" +
            "\n" +
            "\"Huynh bây giờ còn có tư cách để muội gọi như vậy sao?\" Nhìn trước mặt đã trở thành khỏa minh châu sáng nhất trong gia tộc kia, Tiêu Viêm chua xót nói, sau khi bản thân hắn tụt dốc nàng chính là một trong số cực ít những người vẫn bảo trì tôn kính đối với hắn.\n" +
            "\n" +
            "\"Tiêu Viêm ca ca, trước kia huynh đã từng nói với Huân Nhi, có thể buông, mới có thể cầm lấy, thu phóng tự nhiên mới là người tự tại!\" Tiêu Huân Nhi mỉm cười ôn nhu nói, giọng nói non nớt, khiến người tâm đã chết cũng cảm thấy ấm lòng.\n" +
            "\n" +
            "\"Ha, ha, người tự tại sao? Huynh cũng chỉ biết nói mà thôi, muội xem bộ dáng hiện tại của huynh đi, giống một người tự tại sao? Hơn nữa… thế giới này, cơ bản cũng không phải là thế giới của huynh.\" Tiêu Viêm cười tự giễu nói.\n" +
            "\n" +
            "Đối với sự suy sụp của Tiêu Viêm, Tiêu Huân Nhi khẽ cau mày, thật lòng nói: \"Tiêu Viêm ca ca, tuy muội cũng không biết huynh vì sao lại bị như vậy, bất quá, Huân Nhi tin tưởng, huynh sẽ lại đứng dậy, lấy lại vinh quang và tôn nghiêm của huynh…\" Kết thúc câu nói, khuôn mặt trắng nõn của thiếu nữ lần đầu tiên hiện lên nét ửng đỏ nhàn nhạt: \"Tiêu viêm ca ca năm đó, thực ra rất hấp dẫn…\"\n" +
            "\n" +
            "\"A a…\" Đối với lời nói thẳng thắn của thiếu nữ, thiếu niên xấu hổ cười một tiếng, nhưng lại không nói gì, người không phong lưu phí hoài tuổi trẻ, nhưng hắn hiện tại thực sự đã không còn tư cách cùng tâm tình đó nữa, yên lặng xoay người, chậm rãi đi ra khỏi quảng trường…\n" +
            "\n" +
            "Đứng tại chỗ nhìn theo bóng lưng cô độc của thiếu niên, Tiêu Huân Nhi trù trừ một thoáng, sau đó bỏ lại tiêng sói tru tiếng ghen tị tại phía sau, bước nhanh theo, cùng thiếu niên sóng vai bước đi…\n" +
            "\n" +
            "Chương 2: Đấu khí đại lục\n" +
            "\n" +
            "Trăng sáng vằng vặc, bầu trời đầy sao.\n" +
            "\n" +
            "Trên đỉnh núi, Tiêu Viêm nằm trên mặt cỏ, trong miệng ngậm một nhánh cỏ xanh, khẽ nhấm nháp, tùy ý để tư vị chua chát tràn ngập trong miệng…\n" +
            "\n" +
            "Giơ lên bàn tay trắng nõn lên trước mặt, ánh mắt xuyên thấu qua khe hở giữa các ngón tay, nhìn vầng trăng bạc trên bầu trời xa xăm.\n" +
            "\n" +
            "\"Ai…\" Nhớ đến trắc nghiệm lúc buổi chiều, Tiêu Viêm thở dài một tiếng, miễn cưỡng co tay lại, hai tay đỡ lấy đầu, ánh mắt có chút hoảng hốt.\n" +
            "\n" +
            "\"Mười lăm năm rồi…\" Âm thanh nho nhỏ bỗng nhiên không hề báo trước từ trong miệng thiếu niên xuất ra.\n" +
            "\n" +
            "Trong lòng Tiêu Viêm, có một cái bí mật chỉ mình hắn biết: Hắn không phải người của thế giới này, hoặc có thể nói là, linh hồn của Tiêu Viêm không thuộc về thế giới này, hắn đến từ một nơi tên là địa cầu, tuy nhiên vì sao hắn lại đến được nơi này hắn cũng không thể giải thích được, sống qua một khoảng thời gian, hắn hiểu ra được: Hắn đã xuyên việt!\n" +
            "\n" +
            "( Theo ý hiểu của mềnh \"xuyên việt\" tức là vượt qua chiều không gian khác))\n" +
            "\n" +
            "Theo tuổi dần dần tăng lên, đối với đại lục này, Tiêu Viêm cũng đã có chút lý giải mơ hồ về nó…\n" +
            "\n" +
            "Đại lục tên là Đấu Khí đại lục, trên đại lục không có các loại ma pháp như trong tiểu thuyết, mà đấu khí mới là chủ nhân duy nhất của đại lục!\n" +
            "\n" +
            "Tại đại lục này, tu luyện đấu khí, cơ hồ dưới sự cố gắng của vô số thế hệ đã phát triển đến mức đỉnh cao, hơn nữa nhờ phạm vi đấu khí không ngừng mở rộng, cuối cùng đã phát triển vào dân gian, việc này khiến cho đấu khí cùng nhân loại càng trở nên quen thuộc, do đó, tầm quan trọng của đấu khí trong đại lục này là không gì có thể thể thay thế.\n" +
            "\n" +
            "Trải qua thống kê, đấu khí đại lục đem đấu khi chia ra các cấp bậc từ thấp đến cao, chia làm bốn giai mười hai cấp: Thiên, Địa, Huyền, Hoàng!\n" +
            "\n" +
            "Mà mỗi đẳng cấp lại phân làm sơ, trung, cao - ba cấp.\n" +
            "\n" +
            "Tu luyện đấu khí cấp bậc cao hay thấp cũng là mấu chốt quyết định thành tựu sau này, ví dụ như người tu luyện công pháp trung cấp Huyền giai tất nhiên sẽ mạnh hơn người cùng cấp bậc tu luyện công pháp trung cấp Hoàng giai.\n" +
            "\n" +
            "Đấu khí đại lục, phân biệt mạnh yếu, quyết định qua ba điều kiện. Bạn đang đọc truyện tại Truyện FULL - www.Truyện FULL\n" +
            "\n" +
            "Đầu tiên, trọng yếu nhất đương nhiên là tự thân thực lực, nếu thực lực chỉ có nhất tinh đấu giả thì dù có luyện công pháp Thiên giai tuyệt thế cũng không thể chiến thắng một người tu luyện công pháp Hoàng giai đấu sư.\n" +
            "\n" +
            "Tiếp theo, đó là công pháp! Đồng cấp bậc cường giả, nếu công pháp của ngươi cao hơn đối phương, như vậy tại lúc tỷ thí sẽ có ưu thế rất lớn.\n" +
            "\n" +
            "Loại cuối cùng, gọi là đấu kĩ!\n" +
            "\n" +
            "Tên như ý nghĩa, đây là một lại kỹ năng phát huy đấu khí đặc thù, đấu khí trên đại lục cũng có cấp bậc phân biệt, cũng chia làm Thiên, Địa, Huyền, Hoàng bốn cấp.\n" +
            "\n" +
            "Đấu khí đại lục số lượng đấu kĩ không hề ít, bình thường đấu kĩ truyền lưu ra ngoài, phần lớn đều là hoàng cấp, muốn đạt được đấu kĩ cao thâm thì phải gia nhập tông phái hoặc đấu khí học viện trên đại lục.\n" +
            "\n" +
            "Đương nhiên, một số người do kỳ ngộ hoặc được tiền nhân để lại công pháp, hoặc có đấu kĩ tương xứng với chính bản thân mình, thì loại đấu kĩ đó phối hợp với công pháp khiến uy lực của nó càng mạnh hơn.\n" +
            "\n" +
            "Dựa vào ba điều kiện này có thể phán đoán mạnh yếu, tổng thể mà nói nếu có thể có được cấp bậc công pháp càng cao, sau này phát triển càng không cần phải nói…\n" +
            "\n" +
            "Bất quá công pháp tu luyện cao cấp đấu khí người thường đều rất khó tìm được, công pháp truyền lưu tại tầng lớp phổ thông, nhiều nhất cũng chỉ là Hoàng giai công pháp, một số gia tộc cường đại hoặc trung, tiểu tông phái mới có phương pháp tu luyện Huyền giai, ví dụ như gia tộc của Tiêu Viêm, công pháp cao nhất chỉ có tộc trưởng mới có tư cách tu luyện. Cuồng sư nộ cương, là một loại phong thuộc tính công pháp đấu khí trung cấp Huyền giai.\n" +
            "\n" +
            "Trên Huyền giai, đó là Địa giai, loại công pháp cao thâm này chỉ có thế lực siêu nhiên hoặc đại đế quốc mới có thể có…\n" +
            "\n" +
            "Còn Thiên giai… thì đã mấy trăm năm chưa từng thấy xuất hiện.\n" +
            "\n" +
            "Theo lý luận, người bình thường muốn có được công pháp cao cấp, cơ bản đều là khó như lên trời, nhưng mọi sự đều không có tuyệt đối, theo đấu khí đại lục mở rộng ra, vạn tộc tràn vào an cư lập nghiệp, phía bắc đại lục, có man tộc được xưng là lực lượng mạnh mẽ vô cùng, có thể cùng thú hồn hợp thể. Phía nam đại lục, cũng có các loại gia tộc ma thú cao cấp có trí tuệ, hay chủng tộc hắc ám âm ngoan quỷ dị…\n" +
            "\n" +
            "Bởi vì địa vực mở ra, nên có rất nhiều ẩn sĩ vô danh, tại lúc sinh mệnh kết thúc, có lẽ sẽ đem công pháp do mình sáng tạo để ở một nơi, chờ đợi người có duyên đến lấy. Tại đấu khí đại lục truyền lưu một câu nói: Nếu có một ngày, ngươi rơi xuống một cái sơn động, không cần kinh hoảng, đi về phía trước hai bước, có lẽ nó sẽ giúp ngươi trở thành cường giả của thế giới này!\n" +
            "\n" +
            "Nói như vậy, cũng không phải là giả, trong ngàn năm lịch sử của đại lục, cũng không thiếu loại cố sự nhờ những kì ngộ này mà trở thành cường giả.\n" +
            "\n" +
            "Mà cố sự tạo thành hiệu quả là rất nhiều người tìm đến các vách núi hòng đi tìm tuyệt thế công pháp. Đương nhiên, những người này phần lớn đều là gẫy tay gẫy chân mà về…\n" +
            "\n" +
            "Tóm lại, đây là một mảnh đất tràn ngập kỳ tích và người sáng tạo nên kỳ tích.\n" +
            "\n" +
            "Đương nhiên, muốn tu luyện bí tịch đấu khí, ít nhất phải trở thành đấu giả chân chính mới có tư cách này, mà Tiêu Viêm thì cách mục tiêu đó còn rất xa…\n" +
            "\n" +
            "\"Phì.\" Nhổ ra cây cỏ trong miệng, Tiêu Viêm đột nhiên nhảy dựng lên, khuôn mặt dữ tợn, đối với bầu trời thất rít gào lên: \"Ta đệt cơm mịa mài, đem lão tử xuyên qua thời không sang đây làm một cái phế vật sao? Kháo!\" ( để là \"thảo\" thì không có ý nghĩa gì trong câu này cả... vốn từ có hạn quá không biết bên tàu dùng cái chữ này với nghĩa là gì - đại khái là chửi hay thốt lên bất mãn í mà, \"ta thảo\" chắc cũng gần giống câu \"ta ngất\" ó \"ta kháo\" chứ ứng với nghĩa là cây cỏ thì... bó tay quá.)\n" +
            "\n" +
            "Ở kiếp trước, Tiêu Viêm là một người cực kỳ bình phàm, tiền tài gái đẹp so với hắn căn bản là hai cái đường thẳng song song, vĩnh viễn không có điểm gặp nhau, nhưng sau khi đến đấu khí đại lục, Tiêu Viêm kinh hỉ phát hiện, nhờ có kinh nghiệm hai đời, linh hồn của hắn so với người bình thường mạnh hơn rất nhiều!\n" +
            "\n" +
            "Phải biết rằng, tại đấu khí đại lục, linh hồn là do trời sinh, có thể theo tuổi lớn lên mà mạnh hơn một chút, nhưng chưa có công pháp nào có thể đơn độc tu luyện linh hồn, cho dù là thiên giai công pháp cũng không thể! Đây là kiến thức cơ bản nhất tại đấu khí đại lục.\n" +
            "\n" +
            "Linh hồn cường hóa, cũng tạo nên thiên phú tu luyện cho Tiêu Viêm, đồng thời cũng tạo nên danh tiếng thiên tài cho hắn\n" +
            "\n" +
            "Khi một người bình thường biết mình có tiền vốn để trờ thành tiêu điểm cho ánh mắt của vô số người, nếu không có đủ định lực, rất khó có thể giữ vững tâm tính của mình, rất hiển nhiên, kiếp trước Tiêu Viêm là một người bình thường, cũng không có định lực cao hơn người khác, cho nên lúc hắn bắt đầu tu luyện đấu khí, hắn lựa chọn làm thiên tài, tiêu điểm trước con mắt của mọi người mà không phải là phát triển trong an tĩnh.\n" +
            "\n" +
            "Nếu không có việc gì ngoài ý muốn, Tiêu Viêm thực sự có thể đem hai chữ thiên tài càng lúc càng vang xa, đáng tiếc, tại năm hắn mười một tuổi, danh tiếng thiên tài đột nhiên bị biến cố cướp đoạt đi, mà thiên tài cũng trong một đêm trở thành phế vật cho mọi người chế nhạo!\n" +
            "\n" +
            "……\n" +
            "\n" +
            "Sau khi hét lên vài tiếng, cảm xúc của Tiêu Viêm chậm rãi bình ổn dần, khuôn mặt lại hồi phục bộ dáng yên lặng như ngày thường, mọi việc đã đến nước này, hắn có nổi giận thế nào đi nữa cũng không thể vãn hồi đấu khí toàn mà trước đó hắn phải vất vả tu luyện.\n" +
            "\n" +
            "Chua xót lắc đầu, trong lòng Tiêu Viêm kì thật có một tia ủy khuất, cơ bản là hắn đối với thân thể của chính mình xảy ra chuyện gì cũng không hề biết, ngày thường kiểm tra cũng không phát hiện ra không đúng ở chỗ nào, linh hồn theo tuổi gia tăng cũng càng ngày càng cường đại, hơn nữa tốc độ hấp thu đấu khí so với trạng thái đỉnh cao của vài năm trước còn mạnh mẽ hơn vài phần, những thứ đó này đều nói rõ lên rằng thiên phú của mình không hề suy giảm, nhưng đấu khí tiến vào cơ thể đều biến mất toàn bộ không chút ngoại lệ, tình hình quỷ dị khiến tinh thần Tiêu Viêm ảm đạm bi thương…\n" +
            "\n" +
            "Ảm đạm thở dài, Tiêu Viêm nâng tay lên, trên ngón tay có một chiếc nhẫn màu đen, chiếc nhẫn rất cổ xưa, không biết do tài liệu nào làm ra, bên trên còn có đường hoa văn mờ nhạt, đây là lễ vật duy nhất mà mẫu thân trước khi chết đưa cho hắn, bắt đầu từ lúc bốn tuổi đến nay, hắn đã đeo nó mười năm, di vật của mẫu thân làm Tiêu Viêm đối với nó có một phần quyến luyến, ngón tay nhẹ nhàng vuốt ve giới chỉ, Tiêu Viêm cười khổ nói: \"Máy năm nay, thật sự đã phụ lòng kỳ vọng của mẫu thân rồi…\"\n" +
            "\n" +
            "Thở dài một tiếng, Tiêu Viêm bỗng nhiên quay đầu, đối với rừng cây đen nhánh ấm áp cười nói: \"Phụ thân, ngài tới rồi ạ?\"\n" +
            "\n" +
            "Tuy đấu khí chỉ có tam đoạn, bất quá linh hồn cảm giác của Tiêu Viêm so sánh với một ngũ tinh đấu giả còn mẫn tuệ hơn nhiều, ngay trong lúc nhắc đến mẫu thân, hắn đã phát hiện ra trong rừng cây có động tĩnh.\n" +
            "\n" +
            "\"Ha ha, Viêm nhi, muộn thế này rồi, tại sao còn ở trên này?\" Trong rừng cây, sau một thoáng im lặng truyền ra tiếng cười quan tâm của nam tử.\n" +
            "\n" +
            "Cành cây lay động một chút, một vị trung niên nam tử bước ra, khuôn mặt mang theo nụ cười, dừng ở chỗ đứa con của mình đang đứng dưới ánh trăng.\n" +
            "\n" +
            "Trung niên nhân mặc một bộ y sam họa lệ màu xám, long hành hổ bộ rất có uy nghiêm, trên mặt một đôi lông mày thô dày lại tăng thêm vài phần hào khí, đó là Tiêu Gia đương nhiệm tộc trưởng đồng thời là phụ thân của Tiêu Viêm, ngũ tinh đại đấu sư Tiêu Chiến!\n" +
            "\n" +
            "\"Phụ thân, chẳng phải ngài cũng chưa nghỉ ngơi sao?\" Nhìn trung niên nam tử, nụ cười trên mặt Tiêu Viêm càng đậm, tuy mình có trí nhớ kiếp trước, bất quá từ lúc hắn sinh ra đến nay, vị phụ thân trước mặt này đối với hắn cực kỳ sủng ái, sau khi hắn suy sụp càng không giảm mà tăng, như vậy cũng đủ làm cho Tiêu Viêm cam tâm gọi hắn một tiếng phụ thân rồi.\n" +
            "\n" +
            "\"Viêm nhi, còn nghĩ tới việc trắc nghiệm buổi chiều sao?\" Bước nhanh tiến lên, Tiêu Chiến cười nói.\n" +
            "\n" +
            "\"Ha ha, có gì để nghĩ đâu, tất cả đều trong dự kiến rồi mà\". Thiếu niên lắc lắc đầu, nụ cười cũng có chút miễn cưỡng.\n" +
            "\n" +
            "\"Ai…\" Nhìn khuôn mặt có chút non nớt của Tiêu Viêm, Tiêu Chiến hít một hơi, trầm mặc một lúc, bỗng nhiên nói: \"Viêm nhi, năm nay ngươi mười lăm tuổi rồi đúng không?\"\n" +
            "\n" +
            "\"Vâng, phụ thân\"\n" +
            "\n" +
            "\"Qua một năm nữa, tựa hồ… phải tiến hành nghi thức trưởng thành rồi…\" Tiêu Chiến cười khổ nói.\n" +
            "\n" +
            "\"Đúng vậy, phụ thân, còn có một năm nữa thôi!\" Bàn tay có chút siết chặt, Tiêu Viêm bình tĩnh trả lời, nghi thức trưởng thành đại biểu cho cái gì hắn tự nhiên hiểu rõ, chỉ cần qua trưởng thành nghi thức, hắn không có tiềm lực tu luyện, tự nhiên sẽ bị hủy bỏ tư cách tiến vào Đấu Khí Các tiến hành tìm kiếm công pháp đấu khí, sau đó là bị phân đến các nơi có sản nghiệp của gia tộc, làm một số công việc bình thường, đây là tộc quy của gia tộc, cho dù phụ thân hắn cũng không thể thay đổi.\n" +
            "\n" +
            "Mà, nếu trước hai mươi lăm tuổi vẫn chưa trở thành một đấu giả thì gia tộc cũng sẽ ghi nhận nữa!\n" +
            "\n" +
            "\"Thật xin lỗi con, Viêm nhi, nếu một năm sau đấu khí của con chưa đạt đến thất đoạn thì phụ thân cũng chỉ có thể nhịn đau đem con phân về trong sản nghiệp của gia tộc mà thôi, việc này cũng không phải một mình phụ thân có thể định đoạt, mấy cái lão gia hỏa kia mọi lúc đều chờ phụ thân mắc sai lầm ài…\" Nhìn Tiêu Viêm bình tĩnh, Tiêu Chiến có chút hổ thẹn thở dài.\n" +
            "\n" +
            "\"Phụ thân, con sẽ cố gắng, một năm sau con nhất định sẽ đạt tới thất đoạn đấu khí!\" Tiêu Viêm mỉm cười an ủi.\n" +
            "\n" +
            "\"Một năm, tăng bốn đoạn sao? Ha ha, nếu là trước kia, có lẽ còn có thể, bất quá hiện tại… Không có một điểm cơ hội nữa rồi…\" Tuy an ủi phụ thân như vật, nhưng trong lòng Tiêu Viêm vẫn cười khổ tự giễu.\n" +
            "\n" +
            "Cũng là phi thường hiểu rõ Tiêu Viêm, Tiêu Chiến cũng chỉ đành thở dài một tiếng. Hắn biết một năm tăng bốn đoạn đấu khí có bao nhiêu khó khăn, vỗ nhẹ đầu hắn, bỗng nhiên cười nói: \"Đã không còn sớm, trở về nghỉ ngơi đi, ngày mai gia tộc sẽ có khách quý tới, con cũng đừng để thất lễ.\"\n" +
            "\n" +
            "\"Khách quý? Ai ạ?\" Tiêu Viêm tò mò hỏi.\n" +
            "\n" +
            "\"Ngày mai sẽ biết.\" Nháy nháy mắt với Tiêu Viêm, Tiêu Chiến cười to mà đi, chỉ lưu lại Tiêu Viêm với cảm giác bất đắc dĩ.\n" +
            "\n" +
            "\"Yên tâm đi phụ thân, con sẽ cố hết sức!\" Vuốt ve chiếc nhẫn cổ xưa trên tay, Tiêu Viêm ngẩng đầu lên lẩm bẩm nói.\n" +
            "\n" +
            "Trong lúc Tiêu Viêm ngẩng đầu đó, chiếc nhẫn màu đen cổ xưa trên tay bỗng nhiên hiện lên một tia ánh sáng cực kỳ yếu ớt quỷ dị, ánh sát chỉ chớp lên trong nháy mắt, không có bất cứ ai phát hiện ra…\n" +
            "\n" +
            "Chương 3: Khách nhân\n" +
            "\n" +
            "Trên giường, thiếu niên nhắm mắt ngồi xếp bằng, hai tay trước người làm một cái kỳ dị thủ ấn, ngực nhẹ phập phồng, mỗi một lần hô hấp đều hình thành hoàn mỹ tuần hoàn, lúc hơi thở tuần hoàn có nhàn nhạt bạch sắc khí lưu theo miệng, mũi đi vào cơ thể ôn dưỡng cốt cách cùng thân thể\n" +
            "\n" +
            "Lúc thiếu niên nhắm mắt tu luyện, trên ngón tay hắc sắc cổ xưa giới chỉ lại quỷ dị sáng lên sau đó lập tức biến mất…\n" +
            "\n" +
            "\"Hô…\" chậm rãi thở một hơi, thiếu niên hai mắt đột nhiên mở, một đôi nhàn nhạt bạch mang tại đêm tối hiện lên. Đó là vừa bị hấp thu mà chưa hoàn toàn luyện hóa đấu khí.\n" +
            "\n" +
            "\"Đấu khí vất vả tu luyện được, lại biết mất… Ta, ta thảo!\" Cảm ứng đấu khí trong cơ thể, thiếu niên khuôn mặt đột nhiên phẫn nộ, thanh âm có chút bén nhọn mắng.\n" +
            "\n" +
            "Nắm tay gắt gao niết vào nhau, một lúc sau, thiếu niên cười khổ lắc lắc đầu, mệt mỏi nằm xuống giường, giãn chân cùng đùi đang có chút run rẩy ra, chỉ có ba đoạn đấu khí, hắn không có khả năng vô thị các loại mệt nhọc.\n" +
            "\n" +
            "Tại trong phòng hoạt động thân thể đơn giản một chút, ngoài phòng truyền đến già nua thanh âm: \"Tam thiếu gia, tộc trưởng gọi ngươi đến đại sảnh!\"\n" +
            "\n" +
            "Tam thiếu gia, Tiêu Viêm đứng thứ ba trong nhà, trước hắn có hai người ca ca, bất quá bọn họ đã sớm ra ngoài lịch lãm, thỉnh thoảng mới về nhà. Hai vị ca ca này đối với vị thân đệ đệ Tiêu Viêm cũng rất không sai\n" +
            "\n" +
            "\"Nga.\" Thuận miệng đáp, Tiêu Viêm đi ra khỏi phòng, đối với ngoài phòng một cái thanh sam lão giả mỉm cười nói: \"Đi thôi, Mặc quản gia.\"\n" +
            "\n" +
            "Nhìn thiếu niên non nớt khuôn mặt, thanh sam lão giả hỏa thiện gật gật đầu, lúc xoay người trong mắt xẹt qua một mạt không ai phát hiện tiếc hiện, ai, lấy thiên phú của\n" +
            "\n" +
            "Tam thiếu gia trước kia chỉ sợ sớm đã trở thành một xuất sắc đấu giả, đáng tiếc…\n" +
            "\n" +
            "Theo lão quản gia ra khỏi hậu viện, tại nghênh khách đại sảnh ngừng lại, cung kính gõ cửa sau đó mới nhẹ nhàng đẩy cửa vào\n" +
            "\n" +
            "Đại sảnh rất lớn, người ngồi bên trong cũng không ít, vài người ngồi cao nhất là Tiêu Chiến và ba vị sắc mặt đạm mạc lão giả, bọn họ là trưởng lão trong tộc, quyền lợi không bé hơn tộc trưởng\n" +
            "\n" +
            "Tại bốn người bên trái, ngồi một số trưởng bối có thực lực không kém trong gia tộc, ở bên cạnh họ cũng có một số biểu hiện kiệt xuất trong gia tộc tuổi trẻ một đời\n" +
            "\n" +
            "Một bên khác, ngồi ba người lạ lẫm, nói như vậy bọn họ là khách quý mà Tiêu Chiến nói đêm qua.\n" +
            "\n" +
            "Có chút nghi hoặc ánh mắt đảo qua tại ba người xa lạ, bên trong ba người, có một vị mặc nguyệt bạch y bào lão giả. Lão giả tươi cười đầy mặt, thần thái sáng láng, một đôi nho nhở song nhãn quang mang ngẫu thiểm, tầm mắt của Tiêu Viêm khẽ hạ xuống, dừng ở lão giả trên ngực, đột nhiên rùng mình, tại lão giả trên ngực y bào rõ ràng có một cái ngân sắc thiển nguyệt, tại thiển nguyệt xung quanh có bảy khỏa kim quang lòe lòe tinh thần\n" +
            "\n" +
            "\"Thất tinh đại đấu sư! Lão nhân này lại là một vị thất tinh đại đấu sư? Thật là người không thể nhìn tướng!\" Tiêu Viêm trong lòng kinh dị, thực lực của lão giả này so với phụ thân mình còn mạnh hơn hai tinh.\n" +
            "\n" +
            "Người có thể trở thành đại đấu sư, ít nhất cũng là danh chấn một phương cường giả, thực lực như vật sẽ được tất cả các thế lực xu chi nhược vụ(?), vậy mà bỗng nhiên lại gặp một vị cường giả có cấp bậc như vậy, cũng khó trách Tiêu Viêm sẽ cảm thấy kinh ngạc.\n" +
            "\n" +
            "Bên cạnh lão giả, ngồi một đôi tuổi trẻ nam nữ, bọn họ đều mặc giống nhau nguyệt bạch bào trang phục, nam tử tuổi khoảng hai mươi, tướng mạo anh tuốn, phối hợp vóc người cao lớn, rất có mị lực, trọng yếu nhất là năm khỏa kim tinh trên ngực, đại biểu thanh niên này thực lực: Ngũ tinh đấu giả!\n" +
            "\n" +
            "Có thể hai mươi tuổi trở thành một ngũ tinh đấu giả, nói lên thanh niên thiên phú tu luyện cũng rất cao\n" +
            "\n" +
            "Anh tuấn tướng mạo, hơn nữa bất tục thực lực, vị thanh niên này không chỉ đem bao nhiêu thiếu nữ trong gia tộc mê đến thần hồn điên đảo, ngay cả Tiêu Mị ngồi một bên, mĩ mâu nhìn về phía bên này, cũng phát ra dị thải\n" +
            "\n" +
            "Thiếu nữ thầm đưa mắt, bất quá với thanh niên này không có chút hấp dẫn lực. Lúc này, vị thanh niên kia đang đem chú ý lực tập trung tại xinh đẹp thiếu nữ ngồi bên cạnh…\n" +
            "\n" +
            "Thiếu nữ này tuổi cùng Tiêu Viêm tương phảng, làm Tiêu Viêm ngoài ý muốn chính là nàng dung mạo, so với Tiêu Mị còn đẹp hơn vài phần, tại bên trong gia tộc, cũng chỉ có giống như hoa sen Tiêu Huân Nhi có thể so sánh, khó trách nam tử này đối với trong tộc mấy cái yên chi tục phấn khinh thường một cỗ\n" +
            "\n" +
            "Thiếu nữ mềm mại vành tai có một cái lục sắc ngọc trụy, khẽ động một chút, phát ra thanh thúy ngọc hưởng, đột ngột hiện ra một mặt kiều quý…\n" +
            "\n" +
            "Ngoài ra, tại thiếu nữ bắt đầu phát dục trên ngực, có ba khỏa kim tinh\n" +
            "\n" +
            "\"Tam tinh đấu giả, cô gái này… Nếu không có nhờ ngoại vật kích phát thì chính là một cái tuyệt đỉnh thiên tài!\" Trong lòng nhẹ nhàng hít một hơi khí lạnh, ánh mắt Tiêu\n" +
            "\n" +
            "Viêm tại trên mặt cô gái dừng lại một chút rồi rời đi, nói thế nào đi nữa dưới ngây thơ ngoại mạo của hắn chính là một cái thành thục linh hồn, tuy thiếu nữ rất đẹp, bất quá hắn cũng không nhàn tâm lộ ra chảy nước miếng trư ca bộ dáng\n" +
            "\n" +
            "Hành động của Tiêu Viêm khiến thiếu nữ cảm thấy kinh ngạc, tuy nhiên nàng cũng không phải loại người nghĩ thế giới đều vây quanh mình nữ hài, bất quá khí chất và mỹ mạo của mình, nàng rất hiểu rõ, Tiêu Viêm tùy ý động rác thực sự làm nàng có chút ngoài ý muốn, đương nhiên, cũng chỉ như vậy mà thôi!\n" +
            "\n" +
            "\"Phụ thân, ba vị trưởng lão!\" Bước nhanh về phía trước, đối với bốn người Tiêu Chiến cung kính hành lễ\n" +
            "\n" +
            "\"A a, Viêm nhi, đến rồi a, mau ngồi xuống đi.\" Thấy Tiêu Viêm đã đến, Tiêu Chiến dừng lại cùng khách nhân đàm tiếu, hướng về phía hắn gật gật đầu, phất tay nói.\n" +
            "\n" +
            "Mỉm cười gật đầu, Tiêu Viêm làm như không thấy ba vị trưởng lão phóng đến không kiên nhẫn và khinh thường, quay đầu lại nhìn, ngạc nhiên phát hiện, không có vị trí của mình…\n" +
            "\n" +
            "\"Ai, địa vị cảu mình trong gia tộc, xem ra càng ngày càng thấp a, ngày xưa còn tốt, nhưng hiện tại lại làm ta trước mặt khách nhân khó xử, ba cái lão bất tử này…\"\n" +
            "\n" +
            "Trong lòng tự giễu cười, Tiêu Viêm thầm nhủ lắc đầu.\n" +
            "\n" +
            "Nhìn Tiêu Viêm đứng tại chỗ, người tuổi trẻ trong gia tộc đều nhịn không được cười châm chọc, hiển nhiên đều rất thích xem hắn mất mặt bộ dáng.\n" +
            "\n" +
            "Lúc này, Tiêu Chiến phía trên cũng phát hiện Tiêu Viêm xấu hổ, khuôn mặt hiện lên tức giận, đối với bên cạnh lão giả nhíu mày nói: \"Nhị trưởng lão, ngươi…\"\n" +
            "\n" +
            "\"Khái, thật xin lỗi, thế nhưng đem Tam thiếu gia quên mất, a a, ta lập tức gọi người chuẩn bị\" Hoàng bào lão giả bị Tiêu Chiến trừng mắt chỉ nhàn nhạt cười, \"Tự trách\" vỗ vỗ trán, nhưng trong mắt châm chọc không có che giấu bao nhiêu\n" +
            "\n" +
            "\"Tiêu Viêm ca ca, ngồi ở đây đi!\" Thiếu nữ nhàn nhạt tiếng cười, bỗng nhiên tại đại sảnh vang lên.\n" +
            "\n" +
            "Ba vị trưởng lão ngẩn người, ánh mắt nhìn về phía trong góc im lặng Tiêu Huân Nhi, miệng nhuyễn nhuyễn, thế nhưng đều không dám nói nữa…\n" +
            "\n" +
            "Tại trong góc đại sảnh, Tiêu Huân Nhi mỉm cười khép lại bộ sách rất dày, khí chất đạm nhã thong dong, đối với Tiêu Viêm đáng yêu chớp chớp mắt.\n" +
            "\n" +
            "Nhìn Tiêu Huân Nhi mỉm cười khuôn mặt, Tiêu Viêm chần chừ một chút, vuốt mũi gật gật đầu, sau đó tại đông đảo thiếu niên ghen tỵ ánh mắt, đi đến bên cạnh ngồi xuống. Bạn đang đọc truyện tại - http://truyenfull.vn\n" +
            "\n" +
            "\" Ngươi lại giúp ta giải vây.\" Ngửi bên cạnh thiếu nữ nhàn nhạt mùi thơm, Tiêu Viêm cười nhẹ nói.\n" +
            "\n" +
            "Tiêu Huân Nhi nhợt nhạt cười, khuôn mặt lộ ra đáng yêu má lúm đồng tiền, mảnh khảnh ngón tay lại mở ra cổ xưa bộ sách, tuổi nhỏ đã có một loại tri tính mĩ cảm, lông mi chớp động, bỗng nhiên có chút buồn bã nói: \"Tiêu Viêm ca ca đã có ba năm không một mình ngồi cạnh Huân Nhi?\"\n" +
            "\n" +
            "\"Ách… Huân Nhi hiện tại là thiên tài trong gia tộc, muốn có bằng hữu còn không đơn giản sao?\" Nhìn thiếu nữ có chút u oán khuôn mặt, Tiêu Viêm kiền tiếu nói.\n" +
            "\n" +
            "\"Lúc Huân Nhi bốn tuổi đến sáu tuổi, mỗi ngày buổi tối đều có một người vào phòng ta, sau đó dùng một loại rất ngốc nghếch thủ pháp cùng với không hùng hậu đấu khí, ôn dưỡng ta kinh mạch cùng cốt cách, mỗi lần đều tự mình đổi mồ hôi đầm đìa mới mỏi mệt rời đi, Tiêu Viêm ca ca, ngươi nói hắn là ai?\" Huân Nhi trầm mặc một lúc bỗng quay đầu, đối với Tiêu Viêm thản nhiên cười, thiếu nữ phong tình làm chung quanh thiếu niên ánh mắt tỏa sáng.\n" +
            "\n" +
            "\"Khái… Ta, ta làm sao biết được?\" Trong lòng lại nhảy dựng lên, Tiêu Viêm xấu hổ cười hai tiếng, lập tức có chút tâm hư đem ánh mắt chuyển đến trong đại sảnh.\n" +
            "\n" +
            "\" Hì hì…\" Nhìn phản ánh của Tiêu Viêm, Tiêu Huân nhi hòa nhã cười, ánh mắt chuyển đến trên bộ sách, thản nhiên tự nói: \"Tuy biết là hắn có ý tốt, nhưng Huân Nhi mặc kệ, dù gì đi nữa người ta cũng là nữ hài tử. Làm gì có đạo lý trộm động chạm đến nữ hài tử thân thể, nếu Huân Nhi tìm thấy người đó, hừ…\"\n" +
            "\n" +
            "Khóe miệng giật giật, Tiêu Viêm trong lòng có chút tâm hư, không nói một lời.','https://animehay.club/upload/poster/3374.jpg',1)";
    private String SQLQuery7 = "INSERT INTO truyen VALUES (null,'VŨ ĐỘNG CÀN KHÔN','Chương 1: Lâm Động\n\n" +
            "\n" +
            "A...\"\n" +
            "\n" +
            "Khi Lâm Động hao hết khí lực mở ra đôi mi nặng trĩu, nhất thời căn phòng đơn sơ mà sạch sẽ xuất hiện trong mắt, hình ảnh quen thuộc làm hắn ngẩn người ra, chợt vội quay đầu lại, quả nhiên nhìn thấy hai đạo thân ảnh, một nam một nữ ngồi bên cạnh bàn.\n" +
            "\n" +
            "\"Cha, mẹ ...\"\n" +
            "\n" +
            "Nhìn hai đạo thân ảnh kia, Lâm Động vội gắng gượng tinh thần, nhỏ giọng gọi.\n" +
            "\n" +
            "\"Động nhi, con tỉnh?\"\n" +
            "\n" +
            "Nghe thấy tiếng kêu, nàng kia quay đầu sang, nhìn thấy Lâm Động vừa mở mắt, nhất thời vui sướng nói.\n" +
            "\n" +
            "Cả người nữ tử kia có chút mộc mạc, nhìn qua chừng ba mươi, khuôn mặt hơi thanh tú làm người ta có loại cảm giác dịu dàng nhu hòa, mà nàng đúng là mẫu thân Lâm Động - Liễu Nghiên.\n" +
            "\n" +
            "\"Học nghệ chưa tinh mà đã đánh nhau với người ta, tự chuốc lấy khổ.\"\n" +
            "\n" +
            "Ngồi bên cạnh nữ tử là một vị nam tử nhìn qua chừng ba bốn mươi tuổi, thân thể có chút đơn bạc, có thể mơ hồ nhìn thấy một chút sắc bén trong ánh mắt hắn, chẳng qua giống như có thương tích trong người, khuôn mặt hơi có vẻ tái nhợt, che lấp hơn nửa tia sắc bén kia, hắn là phụ thân Lâm Động - Lâm Khiếu.\n" +
            "\n" +
            "Lâm Động hiển nhiên có chút e ngại với vị phụ thân xưa nay nghiêm khắc này, rụt cổ lại, chợt lại có chút không phục nói: \"Ai bảo những tên kia đứng trước mặt ta mắng cha là phế vật...\"\n" +
            "\n" +
            "Khi nói chuyện, Lâm Động sờ sờ ngực, nơi đó vẫn còn chút nhói đau, không khỏi oán hận nghiến răng, vốn hôm nay là một lần khảo thí của Lâm gia, mà hắn cũng đi kiểm tra nhẹ, vì mới bắt đầu tu luyện chỉ hơn nửa năm nên thành tích cũng không bao nhiêu, mà hắn cũng không để trong lòng, nếu cho hắn có thời gian và điều kiện tu luyện như những người khác thì hắn tin rằng mình sẽ chẳng yếu hơn người khác.\n" +
            "\n" +
            "Mà khi khảo thí chấm dứt, Lâm Động đang chuẩn bị dẹp đường hồi phủ thì vài tên ngày thường quan hệ không tốt, vốn dĩ hắn không để ý tới nhưng lại không nhịn được sự cố ý khiêu khích của đối phương, phẫn nộ, tuổi trẻ, tất nhiên Lâm Động không nhịn được ra tay, mà kết quả cũng thực rõ ràng, hắn trực tiếp bị đánh một trận, còn bị ngất đi.\n" +
            "\n" +
            "\"Lâm Sơn, ngươi nhớ kỹ cho ta, lần sau ta không đánh ngươi thành đầu heo thì ta không mang họ Lâm nữa!\"\n" +
            "\n" +
            "Lâm Sơn trong lời Lâm Động chính là người khởi xướng chuyện này, cũng là địch nhân lớn nhất hiện tại trong lòng Lâm Động, bởi vì quan hệ phụ thân hai bên cực kỳ ác liệt nên Lâm Sơn kia cũng thường xuyên đến gây sự với Lâm Động, mà lần này cũng là một trong số đó.\n" +
            "\n" +
            "Hung hăng nghiến răng, nhưng ngay sau đó Lâm Động đột nhiên ủ rũ lại, tuy Lâm Sơn kia đáng giận đến cực điểm nhưng nói gì thì nói, hiện tại tên kia cũng đã Thối Thể tứ trọng, thành tích này ở trong đám tiểu bối Lâm gia cũng xem như đi đằng trước, so với thực lực Thối Thể nhị trọng như Lâm Động hắn thì quả thật mạnh hơn không ít.\n" +
            "\n" +
            "Tu luyện nhất đạo, luyện thể vi tiên, hết thảy đều bắt đầu từ thân thể của mình, nhân thể vốn là thứ huyền ảo khó lường nhất trong thiên địa.\n" +
            "\n" +
            "Cái gọi là Thối Thể, nói đơn giản hơn chính là tu luyện thân thể, làm cho thân thể mình dần dần cường hóa, hơn nữa cuối cùng từ ngoài vào trong, khi gân cốt cốt tủy trong cơ thể cường hóa đến trình tự nhất định cũng là lúc phát sinh ra một tia nguyên lực, mà khi xuất hiện nguyên lực tức là hắn đã chân chính trở thành một gã Tu Luyện Giả.\n" +
            "\n" +
            "Thối Thể chia làm cửu trọng, tam trọng trước hiệu quả không lớn, không có tác dụng gì ngoài việc làm tố chất thân thể mạnh lên một ít, chỉ khi tu luyện đến Thối Thể tứ trọng mới dần dần bày ra chỗ tốt của tu luyện, đến tầng này thì làn da nhân thể sẽ chậm rãi cứng rắn như đá, bất luận khí lực hay tốc độ đều tăng lên không ít.\n" +
            "\n" +
            "Mà Lâm Sơn kia lại đứng ở trình tự này, Lâm Động mới Thối Thể nhị trọng hiển nhiên không phải đối thủ.\n" +
            "\n" +
            "Bất quá tuổi hai người xấp xỉ nhau nhưng có chênh lệch lớn đến vậy không phải vì cái gì mà thiên phú cả, tầng Thối Thể này không phải coi trọng cái gọi là thiên phú lắm, thậm chí tầng này ai cũng có thể tu luyện, nhưng đến tột cùng tu luyện đến đệ mấy trọng thì phải xem tiền vốn và cơ duyên.\n" +
            "\n" +
            "Thối Thể cửu trọng, giai đoạn này rất khổ bởi vì chỉ có không ngừng thử nghiệm cực hạn của thân thể mới có thể làm thân thể dần dần cường đại được.\n" +
            "\n" +
            "Bất quá, loại thử nghiệm cực hạn này cũng là một loại áp bức tiềm năng nhân thể, loại áp bức này mà không được bổ sung ngay thì thân thể sẽ xuất hiện tổn thương vì tiêu hao quá độ, đến lúc đó không chỉ ảnh hưởng đến tu luyện, ngược lại còn làm cho mình cả người là thương, mất nhiều hơn được.\n" +
            "\n" +
            "Bởi vậy trong quá trình Thối Thể cần các loại linh dược đại bổ làm dịu thân thể mới có thể tiếp tục tu luyện, nhưng là những dược liệu này đa phần cực kỳ sang quý, nếu gia cảnh không khá giả thì quả thật không thể chịu nổi.\n" +
            "\n" +
            "Mà đây là cái gọi là tiền vốn!\n" +
            "\n" +
            "Sở dĩ Lâm Sơn có thể siêu việt Lâm Động lưỡng trọng không chỉ vì tu luyện nhiều hơn nửa năm, hơn nữa hắn có một phụ thân chưởng quản tài chính Lâm gia, mà trái lại, Lâm Động hắn không có phúc khí này, không có linh dược tẩm bổ thân thể thì tốc độ tu luyện tất nhiên kém xa...\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Trong phòng, nghe lời nói thầm của Lâm Động, bàn tay đặt lên bàn của Lâm Khiếu đột nhiên nắm chặt lại một chút, sắc mặt cũng trầm xuống, Liễu Nghiên bên cạnh thấy thế vội vàng đánh mắt với Lâm Động, Lâm Động mới vội vàng ngậm miệng lại.\n" +
            "\n" +
            "\"Không cần so miệng lưỡi với người khác, tu luyện cho tốt, người khác tự nhiên sẽ ngậm miệng lại.\"\n" +
            "\n" +
            "Lâm Khiếu phất phất tay nói: \"Liễu Nghiên, đưa gốc Xích Tham kia cho Động nhi đi, có Xích Tham, tốc độ tu luyện của hắn hẳn có thể nhanh hơn một chút, cách tộc bỉ cũng chỉ còn nửa năm, nếu không nhanh chóng tu luyện sẽ càng thêm mất mặt.\"\n" +
            "\n" +
            "\"Khiếu ca, gốc Xích Tham kia là để cho người chữa thương mà...\" Nghe vậy, Liễu Nghiên nhất thời sửng sốt, vội vàng nói.\n" +
            "\n" +
            "\"Ta đã là một phế nhân, dù chữa trị thế nào đi nữa cũng không được gì, về sau ta sẽ vào núi nhiều hơn, tận lực tìm một ít linh dược cho Động nhi.\" Lâm Khiếu lắc lắc đầu, tự giễu cười.\n" +
            "\n" +
            "\"Cha không phải phế nhân, cha từng là người mạnh nhất Lâm gia ngoài gia gia ra!\" Nghe lời Lâm Khiếu nói, Lâm Động lại đỏ bừng mặt nói, trong lòng tiểu hài tử, phụ thân vĩnh viễn là mạnh nhất.\n" +
            "\n" +
            "\"Người mạnh nhất...\"\n" +
            "\n" +
            "Nắm tay Lâm Khiếu không tự chủ được nắm chặt lại, trên khuôn mặt lại toát ra vẻ thống khổ xâm nhập đến cốt tủy, một lát sau, hắn đứng dậy, có chút mỏi mệt đi ra ngoài.\n" +
            "\n" +
            "\"Liễu Nghiên, sắc thuốc cho đứa nhỏ đi, thương thế của ta không sao cả, đã nhiều năm như vậy rồi, một gốc Xích Tham có tác dụng gì?\"\n" +
            "\n" +
            "Lời nói mang theo một chút suy sụp kia làm ánh mắt Liễu Nghiên đỏ lên, ai từng nghĩ đến, nam tử năm đó khí phách nhất Thanh Dương Trấn, hiện tại lại chán nản như vậy.\n" +
            "\n" +
            "\"Nương, đừng khóc, Động nhi nhất định sẽ cố gắng tu luyện, đến lúc đó sẽ tìm cách chữa khỏi thương thế cho phụ thân.\" Lâm Động kéo kéo góc áo Liễu Nghiên, thấp giọng nói.\n" +
            "\n" +
            "\"Động nhi, đừng trách cha con nghiêm khắc, hắn chỉ trút hết tâm huyết của mình lên người con thôi, con cũng biết đó là kỳ vọng duy nhất của hắn.\"\n" +
            "\n" +
            "Liễu Nghiên cúi đầu, nhìn khuôn mặt rất nghiêm túc non nớt của Lâm Động, nhẹ nhàng lau nước mắt, sau đó sờ sờ đầu Lâm Động, thấp giọng nói.\n" +
            "\n" +
            "\"Nương, ta nghe nói lần này tiền tam trong tộc bỉ có thể nhận được một loại tam phẩm linh dược tên là Ngưng Huyết Chu Quả, ta từng nghe đại bá nói nó chữa thương rất hiệu quả, nếu có thể có được nó chắc chắn sẽ có điều trợ giúp với thương thế phụ thân.\" Lâm Động như đột nhiên nhớ ra điều gì, ánh mắt sáng lên nhìn Liễu Nghiên nói.\n" +
            "\n" +
            "\"Ngưng Huyết Chu Quả sao...\" Nghe vậy Liễu Nghiên cũng ngẩn người ra, chợt có chút bất đắc dĩ lắc đầu: \"Tiền tam tộc bỉ không dễ dàng chút nào, con có tâm là được rồi, nương đi giúp ngươi sắc Xích Tham uống đây.\"\n" +
            "\n" +
            "Nói xong Liễu Nghiên xoay người bước ra ngoài, trong thế hệ tiểu bối này của Lâm gia có vài vị thành tựu không nhỏ, Lâm Động muốn tiến vào tiền tam để đạt được Ngưng Huyết Chu Quả quả thật rất khó, bởi vậy nàng cũng không để trong lòng.\n" +
            "\n" +
            "Nhìn bóng Liễu Nghiên dần xa, Lâm Động cũng nghiến răng thật chặt, nắm tay nhỏ nắm chặt lại: \"Nương, yên tâm đi, ta sẽ đạt được Ngưng Huyết Chu Quả kia, như vậy có thể trị liệu thương thế trong cơ thể phụ thân!\"\n" +
            "\n" +
            "Vừa nghĩ tới thương thế Lâm Khiếu, trong mắt Lâm Động đột nhiên toát ra một loại hận ý thật sâu đậm, sở dĩ phụ thân bị không ít người ở Lâm gia châm chọc khiêu khích đều vì người kia!\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Lâm gia của Lâm Động chỉ là một gia tộc nhỏ, mặc dù trong cái Thanh Dương Trấn cũng không tính đứng đầu, nhưng là Lâm gia nhìn thật bình thường này lại có một bối cảnh làm người ta nghẹn họng, đó là Lâm thị gia tộc.\n" +
            "\n" +
            "Một trong tứ đại thị tộc của Đại Viêm Vương Triều - Lâm thị gia tộc!\n" +
            "\n" +
            "Lâm gia Thanh Dương Trấn, từ một góc độ nào đó có thể xem như một chi ngoại tộc của Lâm thị gia tộc, bất quá, với Lâm Động, đứa nhỏ chưa từng đi quá trăm dặm chung quanh Thanh Dương Trấn này thì Lâm thị gia tộc có thực lực làm người ta kinh hãi thật quá xa xôi và xa lạ.\n" +
            "\n" +
            "Ngẫu nhiên nghe được từ miệng phụ thân, Lâm Động biết được chi này của họ kỳ thật cũng từng là nội tộc của Lâm thị gia tộc, chẳng qua năm đó, vì gia gia Lâm Động thất bại trong một nhiệm vụ, làm tộc tổn thất rất lớn nên bị trục xuất khỏi nội tộc, đẩy đến Thanh Dương Trấn này.\n" +
            "\n" +
            "Ở đây, hắn thành lập nên một cái Lâm gia nho nhỏ, hơn nữa trong mấy mươi năm luôn kiệt lực muốn phản hồi lại nội tộc, nguyện vọng này là mục tiêu lớn nhất trong mấy mươi năm còn sót lại của hắn.\n" +
            "\n" +
            "Bất quá, cái loại cố gắng này của hắn cũng không có hiệu quả là bao, tất cả những gì hắn làm với Lâm thị gia tộc khổng lồ mà nói, căn bản không đáng nhắc tới nên hắn chỉ có thể đánh chủ ý đến chỗ khác, mà chỗ này chính là mười năm tộc hội của Lâm thị gia tộc!\n" +
            "\n" +
            "Đây là đại hội trọng yếu nhất Lâm thị gia tộc, rất nổi danh toàn bộ Đại Viêm Vương Triều, mười năm một lần, mỗi một lần đại hội đều là cơ hội tốt nhất cho những người trẻ tuổi trong tộc muốn trở nên nổi bật, danh dương thiên hạ, mà phần thưởng của giải đấu tự nhiên cũng sẽ làm người ta thèm thuồng không thôi. Bất quá, hấp dẫn nhất là chỉ cần có thể tiến vào tiền mười, dù ngươi có là ngoại tộc nhưng cũng sẽ được thăng lên làm nội tộc, vinh quang vô cùng.\n" +
            "\n" +
            "Bởi vậy, tộc hội trở thành ánh rạng đông trong tuyệt vọng của gia gia Lâm Động, nhưng vì tuổi cao nên hắn không thể tham gia được, bởi vậy hắn trút tất cả kỳ vọng vào những đứa con của mình, tất nhiên, Lâm Động phụ thân lúc đó đang bộc lộ tài năng trở thành ánh sáng hy vọng của gia gia và toàn bộ Lâm gia.\n" +
            "\n" +
            "Mà đối với gánh nặng này, phụ thân Lâm Động quả thật cũng không phụ kỳ vọng, trong năm huynh đệ, là người đầu tiên đột phá Thối Thể cửu trọng tiến vào Địa Nguyên Cảnh, hơn nữa trong bốn năm ngắn ngủn sau đó lại đột phá Địa Nguyên, trở thành vị Thiên Nguyên cao thủ thứ hai trong Lâm gia ngoài gia gia Lâm Chấn Thiên.\n" +
            "\n" +
            "Loại tộc độ tu luyện này làm cho gia gia trước nay không thích cười, mỗi một lần nhìn thấy phụ thân, khuôn mặt già nua sẽ lộ ra nụ cười vui vẻ, nghe nói lúc đó gia gia cười nhiều nhất trong mấy chục năm.\n" +
            "\n" +
            "Mười năm tộc hội đến trong chờ mong, nhưng mà kết quả cuối cùng lại làm cho Lâm gia như rớt vào vực sâu.\n" +
            "\n" +
            "Một chiêu!\n" +
            "\n" +
            "Vẻn vẹn chỉ là một chiêu, phụ thân được coi như kỳ vọng lại thảm bại!\n" +
            "\n" +
            "Hơn nữa, đây lại là trận đấu bắt đầu tộc hội!\n" +
            "\n" +
            "Kỳ vọng nhiều năm, đào tạo nhiều năm, chỉ trong ngắn ngủn vài giây hóa thành bọt biển.\n" +
            "\n" +
            "Kết quả của sự thất bại ấy tất nhiên là vô số ánh mắt khác thường, chịu đựng vô số đạo cười lạnh châm chọc trên đầu, đoàn người như chó nhà có tang về đến Thanh Dương Trấn.\n" +
            "\n" +
            "Đêm đó, phụ thân mang theo cả nhà rời khỏi nội khu Lâm gia, đến trên một tòa núi nhỏ hẻo lánh nhất Lâm gia, không hề vận dụng bất cứ thứ gì của Lâm gia nữa, hắn nói, hắn đã không có tư cách này.\n" +
            "\n" +
            "Mà phúc bất song chí, họa bất đan hành.\n" +
            "\n" +
            "( Phúc không đến hai họa không đi một)\n" +
            "\n" +
            "Thất bại đó không chỉ làm Lâm Khiếu suy sút mà lúc đó hắn còn sầu thảm phát hiện, người nọ không chỉ dùng một chưởng đánh bại hắn mà còn không lưu thủ, nguyên lực cuồng bạo như dã thú tàn phá thân thể hắn nát bét.\n" +
            "\n" +
            "Dưới sự trọng thương đấy, thực lực Thiên Nguyên của Lâm Khiếu trực tiếp rớt xuống Địa Nguyên cấp, hơn nữa, trọng thương lắng đọng, kinh mạch trong cơ thể có mười thì bị chặn đến bảy tám, dù hắn tu luyện đến mức nào cũng khó có thể tiến thêm.\n" +
            "\n" +
            "Trong gia tộc, ánh mắt kính sợ ngày xưa cũng dần dần biến thành thở dài, thất vọng... Nguồn truyện: Truyện FULL\n" +
            "\n" +
            "Đối mặt với tai nạn này, rốt cục Lâm Khiếu cũng tuyệt vọng, mỗi khi say rượu sẽ điên cuồng vỗ ngực, tiếng vang trầm thấp như sấm rền làm mẫu thân ở một bên đau lòng gạt lệ, mà tuy Lâm Động còn nhỏ, nhưng nhìn thấy một màn như vậy, lòng đau như dao cắt, đồng thời trong hắn cũng đã sinh ra một tia hận ý với người đả thương phụ thân kia!\n" +
            "\n" +
            "Hắn, hủy đi phụ thân, cũng hủy đi gia đình của mình!\n" +
            "\n" +
            "Về phần người đầu sỏ kia, sau này, ngẫu nhiên Lâm Động cũng nghe thấy đám đại bá nhắc tới với ngữ khí oán hận và vô lực.\n" +
            "\n" +
            "Mười tuổi bắt đầu tu luyện, mười hai tuổi đột phá Thối Thể cửu tiến vào Nguyên cảnh, mười bốn tuổi tấn Địa Nguyên cấp, mười bảy tuổi tấn Thiên Nguyên cấp, hai mươi lăm tuổi, nguyên khí trong cơ thể âm dương kết hợp, cuối cùng thành công hóa đan, cá chép nhảy long môn, trở thành cường giả trước ba mươi tuổi chỉ đếm được trên đầu ngón tay tại Đại Viêm Vương Triều kết thành nguyên đan!\n" +
            "\n" +
            "Nhân sinh của hắn quả thật như truyền kỳ vậy.\n" +
            "\n" +
            "Tên của hắn là Lâm Lang Thiên!\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Trong phòng, nắm tay Lâm Động nắm chặt, trong mắt chỉ tràn ngập hận ý.\n" +
            "\n" +
            "Chương 2: Thông Bối Quyền\n\n" +
            "\n" +
            "Sáng sớm, sương mù dày đặc bao phủ cả ngọn núi tĩnh lặng này, làm tầm mắt của mỗi người trở nên nhìn không rõ.\n" +
            "\n" +
            "\"Hô ~ hô ~\"\n" +
            "\n" +
            "Trong một khu rừng ở phía sau núi, đột nhiên truyền ra tiếng thở dốc kịch liệt, đưa tầm mắt đến gần có thể nhìn thấy trên một khu đất trống ở trong rừng, một thân ảnh nho nhỏ đang dùng cả hai tay ôm lấy một thân cây cao lớn, thân thể hắn mượn lực kéo của hai tay, không ngừng nhấp nhô lên xuống, hơn nữa trong lúc lên xuống, thân thể hắn bày ra một loại tư thế có chút quái dị, loại tư thế này làm cho khắp cơ thể đều vận động cùng lúc.\n" +
            "\n" +
            "Mặt khác, ngay tại cánh tay và cổ chân của hắn còn treo mấy khối sắt đen kịt, từng giọt mồ hôi thẫm thấu ra từ trong quần áo, lan tràn khắp cả mấy khối sắt kia.\n" +
            "\n" +
            "Thân ảnh nho nhỏ này tất nhiên là Lâm Động, tuổi thơ của hắn chưa từng hưởng qua phú quý bao giờ, hơn nữa lại có một phụ thân nghiêm khắc luôn dạy hắn những thứ quan trọng nhất trong tu luyện - nghị lực và chăm chỉ, những thứ này chính là tiền vốn và cũng là điều kiện duy nhất hắn có để cạnh tranh với những người khác.\n" +
            "\n" +
            "Mồ hôi chảy vào trong mắt, cảm giác chát và xót làm hắn cắn chặt hàm răng, hắn có thể cảm giác được sau khi trải qua luyện tập cao độ, cả cơ thể hắn phát ra loại cảm giác ê ẩm và mỏi mệt, lúc này rất nhiều người sẽ lựa chọn nghỉ ngơi, nhưng mà phụ thân hắn từng nói cho hắn biết, chỉ có tại loại thời điểm như vậy mới có thể đột phá cực hạn nên... nhất định phải kiên trì!\n" +
            "\n" +
            "Tuyệt đối không thể thả lỏng!\n" +
            "\n" +
            "Vì tộc hội nửa năm sau, hắn buộc phải liều mạng tu luyện!\n" +
            "\n" +
            "Cảm giác tiếp cận cực hạn làm đầu choáng váng, hoa mắt, bất quá cùng với sự kiên trì của Lâm Động, đột nhiên một tia nhiệt lực kỳ dị mạnh mẽ xuất hiện trong cơ thể, nhiệt lực này vừa xuất hiện làm tinh thần Lâm Động rung lên.\n" +
            "\n" +
            "Là dược lực của Xích Tham!\n" +
            "\n" +
            "Mấy ngày trước, gốc Xích Tham kia vốn dùng để trị liệu thương thế cho Lâm Khiếu, dưới sự kiên trì của hắn, cuối cùng đều bị đưa vào trong cơ thể Lâm Động.\n" +
            "\n" +
            "Không thể không nói, loại linh dược này có hiệu quả rất lớn với Lâm Động đang bị vây trong Thối Thể kỳ, tu luyện mấy ngày ngắn ngủn mà Lâm Động có thể cảm giác rõ ràng thân thể hắn ít nhất mạnh gấp đôi so với mấy ngày trước. cái loại thân thể cường hóa này hắn có thể cảm giác được rất rõ ràng.\n" +
            "\n" +
            "Đương nhiên, dược lực Xích Tham có hiệu quả rất tốt với Lâm Động, nhưng loại dược lực này dù sao cũng không phải vô cùng vô tận, dù sao Xích Tham cũng vẻn vẹn chỉ là nhất phẩm linh dược mà thôi, bởi vậy dược lực của nó phát huy trong năm ngày rồi dần dần tản ra.\n" +
            "\n" +
            "Bất quá loại tản ra này không phải hoàn toàn biến mất, thân thể Lâm Động chỉ mới bắt đầu cường hóa, tất nhiên không thể hoàn toàn hấp thu tất cả dược lực được, bởi vậy một ít dược lực sẽ lắng đọng sâu trong thân thể hắn, nhưng đến khi cơ thể Lâm Động đạt đến đói khát cực độ, loại lắng đọng này cuối cùng cũng bị bức ra, bị gân cốt cơ thể Lâm Động giống như quỷ đói tham lam cắn nuốt...\n" +
            "\n" +
            "Một tia dược lực ôn nhuận chậm rãi tiến vào cơ thể, lúc này Lâm Động như nghe được vô số tiếng reo hò từ tế bào trong cơ thể, loại cảm giác ê ẩm mệt mỏi yên lặng tiêu tán đi, thay vào đó là một loại cảm giác tinh lực dư thừa vô cùng vô tận.\n" +
            "\n" +
            "\"Hắc...\"\n" +
            "\n" +
            "Lâm Động nắm lấy thân cây, thân thể mạnh mẽ búng lên, lăng không lộn ra phía sau, vững vàng đứng trên mặt đất, xoay lưng lắc cổ, xương cốt cả người đột nhiên vang lên một tiếng răng rắc, sau đó Lâm Động vui sướng phát hiện thân thể hắn tựa hồ thoáng cường tráng hơn.\n" +
            "\n" +
            "\"Thối Thể đệ tam trọng!\"\n" +
            "\n" +
            "Nắm tay nhỏ bé Lâm Động nắm chặt lại, cảm thụ được cỗ lực lượng xuất hiện khi giãn cơ thể ra, khuôn mặt nhỏ nhắn lộ vẻ sợ hãi xen lẫn vui mừng, từ khi tu luyện đến nay, bởi gia cảnh nghèo hàn nên hắn rất ít có cơ hội dùng linh dược, không ngờ lần này dùng thử lại có hiệu quả lớn đến vậy.\n" +
            "\n" +
            "\"Ừm, cũng không tệ lắm...\"\n" +
            "\n" +
            "Khi Lâm Động đang vui sướng vì công lực tăng tiến, một âm thanh truyền đến từ bên cạnh, hắn vội vàng quay đầu, vừa lúc nhìn thấy Lâm Khiếu mặc một thân quần áo mộc mạc đang đứng dưới một đại thụ, trên khuôn mặt ngày thường không lộ ra nửa tia cười vui lúc này cũng xuất hiện một chút tươi cười.\n" +
            "\n" +
            "\"Cha!\"\n" +
            "\n" +
            "Nhìn thấy Lâm Khiếu, Lâm Động cũng kinh hỉ kêu lên.\n" +
            "\n" +
            "Lâm Khiếu gật gật đầu, đến gần Lâm Động, ánh mắt từ trên xuống dưới quét một vòng thân thể Lâm Động, khóe miệng nhếch cười, nói: \"Thối Thể đệ tam trọng, không tồi\"\n" +
            "\n" +
            "\"Đều nhờ gốc Xích Tham kia.\" Lâm Động lắc lắc đầu, hắc hắc cười.\n" +
            "\n" +
            "\"Xích Tham vẻn vẹn chỉ là Nhất phẩm linh dược, dù những người khác dùng, muốn từ đệ nhị trọng đạt đến đệ tam trọng cũng cần một hai tháng, nhưng đây lại là thành quả một ngày một đêm của ngươi\" Lâm Khiếu nhìn Lâm Động, trong lòng cũng khẽ thở dài một tiếng, trong khoảng thời gian này, thấy Lâm Động liều mạng tu luyện, trình độ rèn luyện như vậy làm mẫu thân đỏ mắt vài lần, tuy ngoài miệng hắn không nói gì, nhưng thân là phụ thân, trong lòng hắn cũng có chút đau lòng.\n" +
            "\n" +
            "Hắn hiểu Lâm Động liều mạng tu luyện như vậy chỉ muốn ở trên tộc hội nửa năm sau lấy được một cái thành tích kha khá, nếu vậy, thân là phụ thân, hắn cũng có thể cứu vãng được một ít mặt mày trong Lâm gia.\n" +
            "\n" +
            "Lâm Động ngây ngô cười, dù trong khoảng thời gian này rất mỏi mệt nhưng cũng có thu hoạch xa xỉ, ngày càng tiếp cận so với đám tinh anh trong Lâm gia.\n" +
            "\n" +
            "\"Đem mấy khối sắt buông bỏ đi, bây giờ ngươi đã đạt đến Thối Thể đệ tam trọng, cũng có thể miễn cưỡng tu luyện vũ kỹ, ta sẽ dạy ngươi một bộ quyền pháp.\" Lâm Khiếu nói. Bạn đang đọc truyện được lấy tại chấm cơm.\n" +
            "\n" +
            "Nghe vậy đôi mắt đen láy của Lâm Động nhất thời rực sáng, hiện tại hắn đã đạt đến Thối Thể đệ tam trọng nhưng lại không có nửa chiêu nửa thức nào, đánh nhau với người ta cũng chỉ có thể cậy mạnh thôi, nên trong lòng đã sớm hướng tới vũ kỹ, là thứ có thể làm cho thực lực hắn tăng mạnh lên, bất quá vì tố chất thân thể nên Lâm Khiếu vẫn chưa từng dạy cho hắn, hiện tại rốt cục cũng có cơ hội, sao hắn không vui cho được?\n" +
            "\n" +
            "\"Võ học khắp thiên hạ chia làm cửu phẩm tam thừa, nhất đến tam phẩm là tiểu thừa, tứ đến lục phẩm là trung thừa, thất đến cửu phẩm là thượng thừa, ta muốn dạy ngươi là một loại quyền phẩm tiểu thừa nhất phẩm - Thông Bối Quyền\" Lâm Khiếu nói.\n" +
            "\n" +
            "Lâm Động liên tục gật đầu, cũng không thất vọng vì quyền pháp kia vẻn vẹn chỉ là tiểu thừa nhất phẩm, hắn hiểu được đạo lý cơm phải ăn từng chút, hơn nữa đối với không ít người mà nói, tiểu thừa nhất phẩm đã là không tồi rồi, nghe nói trong Lâm gia, vũ kỹ cao nhất cũng vẻn vẹn là một loại vũ kỹ trung thừa tứ phẩm mà thôi, hơn nữa là năm đó gia gia vẫn còn là Lâm thị nội tộc, từ trong Tàng Kinh Các may mắn tìm được.\n" +
            "\n" +
            "\"Vũ kỹ chia cấp nhưng quan trọng nhất vẫn ở bản thân, ở trong tay cường giả chân chính, mặc dù là vũ kỹ nhất phẩm tầm thường cũng mang theo lực sát thương kinh người, thực lực Tu Luyện Giả càng mạnh, uy lực vũ kỹ khi thi triển ra lại càng mạnh\" Lâm Khiếu xòe bàn tay ra, ngoắc ngoắc Lâm Động: \"Dùng lực lượng lớn nhất, tốc độ nhanh nhất của ngươi đến công kích ta đi\"\n" +
            "\n" +
            "Lâm Động trợn mắt, vứt bỏ hết thảy khối sắt trên người, trực tiếp đánh một quyền về Lâm Khiếu.\n" +
            "\n" +
            "Đối mặt với một kích toàn lực của Lâm Động, Lâm Khiếu lại tùy tay vung lên, bàn tay nhanh như chớp lướt đến Lâm Động, ống tay áo vung lên, một tiếng \"ba\" vang lên, sau đó Lâm Động nhe răng trợn mắt nhảy dựng lên, vội vàng vén tay áo lên, chỉ thấy cả cánh tay đều đỏ lên.\n" +
            "\n" +
            "\"Thông Bối Quyền, nương y phát kình, nếu ta thoáng tăng lên hoặc vận dụng một chút nguyên lực thì xương cốt cánh tay này của ngươi đã bị đánh vỡ\" Lâm Khiếu từ từ nói: \"Tu luyện Thông Bối Quyền cần lấy y phục luyện công, quyền pháp này chú trọng khi nương y phục phát kình, khi tu luyện nhờ vào y phục của mình phát ra tiếng vang là được. Thông Bối Quyền có cửu thức, cũng gọi là Cửu Âm Kình bởi mỗi một thức đều có tiếng vang, thức nối thức, cửu âm vang lên thì uy lực có thể so với nhị phẩm vũ kỹ\"\n" +
            "\n" +
            "\"Ngươi chú ý nhìn, cố gắng nhớ kỹ cửu thức này!\"\n" +
            "\n" +
            "Lâm Khiếu quát khẽ một tiếng, đột nhiên triển khai tay chân, chân vừa động, chỉ thấy thân hình như hổ, song chưởng múa may như một đầu Thông Bối Viên Hầu đang mở ra thân mình, từng đạo âm thanh thanh thúy ba ba không ngừng vang lên.\n" +
            "\n" +
            "Lâm Động không chớp mắt nhìn nhìn Lâm Khiếu múa quyền, bất tri bất giác tâm thần ngưng tụ lại, tất cả những gì chung quanh đều bị hắn tự động bỏ qua, trong mắt chỉ còn một bộ quyền pháp kia mà thôi!\n" +
            "\n" +
            "Bởi vì dạy võ nên Lâm Khiếu cũng cố ý giảm tốc độ lại, diễn luyện vài lần mới từ từ thu công, nhìn về phía Lâm Động hỏi: \"Nhớ chưa?\"\n" +
            "\n" +
            "Lâm Động trầm ngâm một chút, có điểm không quá xác định gật gật đầu.\n" +
            "\n" +
            "\"Hả? Đánh thử xem?\"\n" +
            "\n" +
            "Thấy thế khuôn mặt Lâm Khiếu cũng xẹt qua một tia kinh ngạc, tuy hắn giảm tốc độ rất nhiều nhưng cửu thức Thông Bối Quyền cũng không phải đơn giản, lần đầu tiên Lâm Động tiếp xúc vũ kỹ nhưng lại có thể nhớ kỹ nhanh như vậy sao?\n" +
            "\n" +
            "Dường như cũng biết Lâm Khiếu kinh ngạc, Lâm Động đi ra hai bước, hai nắm tay đưa ra, một bộ quyền pháp mang theo vài phần trúc trắc thong thả đánh ra.\n" +
            "\n" +
            "Lâm Khiếu ở bên cạnh nhìn chằm chằm Lâm Động, khi thấy quả thật hắn đánh đầy đủ cửu thức Thông Bối Quyền ra, trên khuôn mặt Lâm khiếu lại lần nữa xuất hiện một chút ý mừng, tuy Thông Bối Quyền của Lâm Động có chút cứng ngắc, thậm chí có thể nói là tốt mã dẻ cùi nhưng lần đầu tiên tiếp xúc quyền pháp này lại có thể học ra hình ra dạng đã nói lên ngộ tính con hắn không tồi rồi. Phát hiện này làm cho trong lòng Lâm Khiếu có chút vui sướng, xem ra đứa con này quả thật kế thừa thiên phú của hắn năm đó a.\n" +
            "\n" +
            "\"Cha, vì sao con thi triển Thông Bối Quyền mà không có chút tiếng vang nào vậy?\" Một bộ quyền thong thả thi triển xong, Lâm Động có chút bất đắc dĩ nói.\n" +
            "\n" +
            "\"Tiểu tử nhà ngươi đúng là, nếu dễ dàng tu luyện ra tiếng vang như vậy thì Thông Bối Quyền này cũng quá mức hữu danh vô thực đi\" Lâm Khiếu cười mắng một tiếng, sau đó nói: \"Nhớ kỹ, khi tu luyện cẩn thận cảm ứng lực đạo, chỉ cần ngươi có thể làm cho ống tay áo ngươi đi theo lực đạo của ngươi chứ không phải ngược lại, lực đạo ngươi đi theo ống tay áo thì lúc đó xem như đã tu luyện thành công rồi, đến đây, thi triển lại vài lần đi\"\n" +
            "\n" +
            "Lâm Động lẩm nhẩm lại vài lần trong miệng, sau đó thi triển lại, mà Lâm Khiếu thì đứng bên cạnh, thường thường ra tiếng chỉ điểm hắn vài chỗ.\n" +
            "\n" +
            "Trên khu đất trống trong rừng, từng đạo quyền ảnh không ngừng vũ động, nam hài mồ hôi như suốt nhưng vẫn không thể làm hắn có chút phân tâm nào, khuôn mặt nhỏ nhắn có vẻ rất nghiêm túc.\n" +
            "\n" +
            "Thời gian dần đến giữa trưa, Lâm Động không ngừng tu luyện, mà cố gắng như vậy cũng không phải không có thành quả gì, đối với Thông Bối Quyền cửu thức cũng ngày càng thuần thục, tuy rằng vẫn không phát ra tiếng vang, nhưng tư thế cũng đã không kém rồi.\n" +
            "\n" +
            "\"Hôm nay tu luyện đến đây thôi, mai rồi luyện tiếp\" Nhìn thoáng qua sắc trời, lại nhìn thoáng qua Lâm Động đầu đầy mồ hôi, Lâm Khiếu đột nhiên nói, Lâm Động quả thật rất chăm chỉ và chấp nhất trong tu luyện, ngay cả hắn cũng thoáng có chút động dung, chợt lại âm thầm thở dài, xem ra mấy năm nay hắn suy sút làm đứa bé này cũng trở nên sớm trưởng thành hơn nhiều.\n" +
            "\n" +
            "\"Ừ, cha về nghỉ ngơi trước đi, con sẽ về ngay\" Lâm Động lên tiếng nhưng hai nắm tay vẫn chưa đình chỉ lại, hết sức chăm chú làm theo lời Lâm Khiếu, gắng sức cảm ứng biến hóa trong cơ thể.\n" +
            "\n" +
            "Thấy thế Lâm Khiếu cũng chỉ có thể bất đắc dĩ lắc đầu, tiến bộ của Lâm Động rất nhanh, bất quá muốn làm cho Thông Bối Quyền phát ra tiếng cũng không dễ dàng, năm đó hắn tu luyện ước chừng một tuần mới thành công.\n" +
            "\n" +
            "Dặn thêm một tiếng, Lâm Khiếu xoay người bước đi, khi xoay người khuôn mặt hắn cũng hiện lên một chút ý cười, ngộ tính hôm nay mà Lâm Động bày ra làm hắn rất vừa lòng.\n" +
            "\n" +
            "\"Ngộ tính đứa nhỏ này quả thật không sai, hơn nữa nghị lực rất cao, đạt đến siêu việt như thời kì cường thịnh nhất của ta hẳn sẽ không khó...\"\n" +
            "\n" +
            "\"Ba!\"\n" +
            "\n" +
            "Ý niệm này vừa hiện lên trong đầu Lâm Khiếu, sau lưng hắn lại truyền đến một đạo âm thanh vang dội và thanh thúy làm khuôn mặt hắn cứng đờ lại, cước bộ lảo đảo một chút nhưng trong mắt lại sáng ngời.\n" +
            "\n" +
            "\"Xem ra không phải không khó mà là rất đơn giản...\"\n" +
            "\n" +
            "Chương 3: Thạch trì cổ quái\n" +
            "\n" +
            "\"Ba…\"\n" +
            "\n" +
            "Trên khoảng đất trống, Lâm Động kinh ngạc nhìn nắm đấm, trên khuôn mặt nhỏ nhắn hiện lên vẻ mừng rỡ khó có thể che dấu, bất quá khi ngẩng đầu nhìn lên, cũng đã thấy thân ảnh chậm chạp của Lâm Khiếu đã ra khỏi rừng cây.\n" +
            "\n" +
            "\"Hắc hắc, ngày mai cho cha xem lại, để cho hắn vui mừng. \"Thấy thế, Lâm Động nhếch miệng một phát, đột nhiên thấy cánh tay truyền đến một trận đau đớn. Hắn vội vàng kéo ống tay áo lên, liền phát hiện trên cánh tay hiện đầy từng đạo đấu máu đỏ, thậm chí còn có vài chỗ trên lớp da bị giãn ra, máu tươi không ngừng thẩm thấu ra.\n" +
            "\n" +
            "\"Tê..~~.\"\n" +
            "\n" +
            "Lúc trước chuyên chú luyện công còn không cảm thấy, lúc này vừa nghỉ một chút, cảm giác đau đớn nhất thời vọt tới làm cho Lâm Động nhe răng trợn mắt một phen. Hắn biết đây là do tu luyện Thông Bối Quyền tạo thành, da cùng y phục ma sát kịch liệt vào nhau, lâu dài tạo ra một chút thương thế. Bạn đang đọc truyện được copy tại Truyện FULL\n" +
            "\n" +
            "\"Còn có thời gian, trước hết đi đến nơi đó một chút.\"\n" +
            "\n" +
            "Lâm Động ngẩng đầu nhìn thoáng qua sắc trời, đột nhiên quay đầu chạy sâu vào phía sau núi. Ước chừng mười mấy phút đồng hồ, một vách đá cao chót vót xuất hiện trước mặt, ánh mắt của hắn lướt qua chung quanh, sau đó cẩn thẩn nhảy xuống hòn đá lồi ra dọc theo vách núi, những hòn đá này cũng không thấy được rõ ràng, nhưng lại vừa lúc tạo thành một cái ám lộ.\n" +
            "\n" +
            "Đối với con đường này, Lâm Động coi như là quen thuộc, vì vậy dưới tình huống bảo trì cẩn thẩn, cũng không xảy ra chuyện gì ngoài ý muốn, rồi sau đó một sơn động núp dưới mấy khối đá lớn xuất hiện trước mắt.\n" +
            "\n" +
            "Sơn động cực kỳ bí mật, hơn nữa xung quanh còn có mấy khối đá lớn lồi ra che dấu, nếu không phải cố ý tìm kiếm, căn bản là không thể nào phát hiện được. Dĩ nhiên, bình thường thì sẽ không có người nào đến làm chuyện như vậy.\n" +
            "\n" +
            "Nhảy vào sơn động, Cảm giác mát mẻ nhất thời cuốn trôi một thân mồ hôi của Lâm Động. Nơi này cùng phía ngoài nóng bức giống như hai khối thiên đia khác nhau, cũng là một nơi tránh nóng tốt.\n" +
            "\n" +
            "Trong sơn động cũng không có gì rộng rãi, hơn nữa trong sơn động trừ một cái thạch trì chừng hai, ba thước cùng không có cái gì đặc biệt.\n" +
            "\n" +
            "Đến gần thạch trì, chỉ thấy tràn ngập nước trong suốt nhìn thấy cả đáy, trên mặt thạch trì, hơi có một chút hàn khí phiêu lãng.\n" +
            "\n" +
            "\"Phù Phù!!...\"\n" +
            "\n" +
            "Đi tới bên cạnh thạch trì, Lâm Động nhanh chóng cởi áo, trực tiếp nhảy vào, thứ hàn khí phiêu lãng kia làm cho thân thể của hắn run rẩy một chút, rồi cũng nhanh chóng thích ứng.\n" +
            "\n" +
            "Cái sơn động này là khi Lâm Động còn bé tình cờ tìm thấy, biết nơi này, cũng chỉ có hắn và Thanh Đàn mà thôi. Nước trong nơi này lạnh hơn rất nhiều so với những nơi khác. Giữa hè, Lâm Động thích nhất chính là đến nơi này tắm rửa, bất quá, nước nơi này ngoài trừ mát mẻ ra thì cũng không có hiệu quả kì dị gì khác.\n" +
            "\n" +
            "Dĩ nhiên mà nói như thế cũng là có điểm không đúng, ít nhất mỗi một lần sau khi tắm ở chỗ này, không biết là ảo ảnh hay cái gì, Lâm Động cảm giác được tinh thần của mình trở nên vô cùng ngưng tụ, bất kể làm cái gì, cũng có thể nhanh chóng đi vào trạng thái chuyên chú.\n" +
            "\n" +
            "Cảm giác như vậy, trước kia Lâm Động còn không cảm thấy có ích lợi gì, nhưng lúc vừa mới tu luyện Thông Bối Quyền, hắn mới phát hiện, ở dưới tình huống tu luyện tựa hồ có hiệu quả rất tốt. Nếu không, hắn cũng rất khó có thể tu luyện Thông Bối Quyền như thế mà đã tạo được tiếng vang.\n" +
            "\n" +
            "\"Hẳn là ảo giác?\"\n" +
            "\n" +
            "Nằm ở trong thạch trì, Lâm Động đang cầm nước trong tay nhìn nó chậm rãi chảy xuống, khuôn mặt nhỏ nhắn nhíu lại, thứ này thực sự thần kỳ như vậy, đây cũng là cần để cho hắn sớm tu luyện ra nguyên lực, nó còn có thể chảy chậm như vậy.\n" +
            "\n" +
            "\"Tu luyện đến Thối thể đệ lục trọng, chính là có thể Luyện Tủy Hóa Nguyên, có nguyên lực, mới thật sự là Tu Luyện Giả.\"Lâm Động đập mạnh, khuôn mặt nghĩ ngợi, chẳng quả hiện nay trong đám tiểu bối Lâm gia, có thể đạt đến tầng thứ này, cũng chỉ có thể đếm trên đầu ngón tay.\n" +
            "\n" +
            "Nguyên Lực, chính là thứ trọng yếu nhất trong khi tu luyện, nghe nói những cường giả thực lực cao thâm chỉ cần giơ tay nhấc chân là đã có thể khiến cho sơn băng địa liệt. Cái loại uy năng to lớn này, đối với mấy loại tiểu tử như Lâm Động đang còn ở giai đoạn ba lúc ban đầu mà nói, thật sự là quá sức tượng tưởng.\n" +
            "\n" +
            "Mà cội nguồn của loại uy năng này, chính là Nguyên lực, một loại năng lượng kỳ dị phiêu đãng giữa thiên địa, bất quá muốn hấp thu Nguyên lực thiên địa, trước hết phải tự thân rèn luyện ra một tia mầm mống Nguyên lực, như thế mới có khả năng hấp dẫn càng nhiều Nguyên lực vào trong cơ thể.\n" +
            "\n" +
            "Lâm Động dựa vào bên cạnh thạch trì ngửa mặt nhắm mắt, sau một hồi lâu suy nghĩ linh tinh, lại từ từ ngủ say. Trong khoảng thời gian tu luyện này, có thể nói hắn quá sức liều mạng, hôm nay thật vất vả mới có thể thư giãn một chút, nhất thời, mệt mỏi từ trong xương cốt tràn ra bên ngoài.\n" +
            "\n" +
            "Trong lúc Lâm Động ngủ say, trong sơn động lần nữa trở nên u tĩnh, làn nước thạch trì nhẹ nhàng dập dờn bồng bềnh.\n" +
            "\n" +
            "\"Tích tích…\"\n" +
            "\n" +
            "Trong lúc yên tĩnh, đột nhiên nước thạch trì trong suốt chuyển động, một giọt máu đỏ theo cánh tay đầy vết tích của Lâm Động lặng lẽ chảy xuống trong thạch trì.\n" +
            "\n" +
            "Theo một giọt máu tươi này chảy xuống, nước thạch trì vốn đang yên tĩnh trong giây lát liền sôi trào lên. Bọt nước mang theo huyết sắc nhàn nhạt từ trên mặt nước dâng lên, sau đó nổ ra xung quanh thân thể của Lâm Động đang ngủ say. Nhiều tia chất lỏng màu đỏ nhạt bắn ra bốn phía, cuối cùng giống như là có linh trí, quấn lên thân thể Lâm Động, sau đó nương theo lỗ chân lông nhanh chóng chui vào trong cơ thể.\n" +
            "\n" +
            "Ngay lúc một chút chất lỏng màu đỏ nhạt chui vào trong cơ thể Lâm Động, da thịt cả người hắn liền phảng phất như nhận lấy áp súc mãnh liệt co rút lại, mồ hôi giống như thủy triều chi chít tuôn ra, hội tụ chung một chỗ, toàn bộ rơi tí tách vào trong nước thạch trì.\n" +
            "\n" +
            "Mà mồ hôi xuất ra khỏi cơ thể mang theo một chút xíu tạp chất màu đen, trước đó không lâu Lâm Động bởi vì mới đột phá lên Thối Thể đệ tam trọng mà thân thể dài ra quá một phân, thế nhưng lại bị thay đổi trở về, cái loại cảm giác này giống như là bong bóng đang bành trướng lại bị chặn lại, đem toàn bộ dưỡng khí bên trong đẩy ra ngoài.\n" +
            "\n" +
            "Nước thạch trì sôi trào cũng không kéo dài quá lâu, ước chừng sau mười mấy phút đồng hồ, liền từ từ giảm đi. Đúng lúc nước thạch trì an tĩnh trở lại, Lâm Động đang ngủ say mạnh mẽ mở hai mắt ra, trong miệng hô to: \"Nóng quá!\"\n" +
            "\n" +
            "\"Phù phù!\"\n" +
            "\n" +
            "Trong miệng hô to một tiếng, Lâm Động liền đem đầu lặn xuống nước, ở trong đó ngây ngốc một hồi lâu, rồi mới đem đầu lộ ra khỏi mặt nước. Thở hổn hển dồn dập mấy hơi, vẻ mặt hắn mờ mịt, trước lúc tỉnh, hắn giống như thân ở trong hỏa lò, cảm giác nóng hổi khiến cho hắn không nhịn được mà phải la lên thất thanh.\n" +
            "\n" +
            "\"Làm sao ở chỗ này lại nóng như vậy?\"Ở trong thạch trì một hồi, lần nữa cảm giác được mát mẻ, Lâm Động mới vội vàng leo lên, nhìn thạch trì, đầu đầy mê hoặc.\n" +
            "\n" +
            "Đứng ở bên cạnh thạch trì suy nghĩ một hồi lâu, Lâm Động mới im lặng lắc đầu, nhặt y phục lên muốn mặc vào, ánh mắt hắn đột nhiên ngưng tại trên cánh tay mình.\n" +
            "\n" +
            "\"Di?\"\n" +
            "\n" +
            "Lâm Động kinh ngạc ngó chừng cánh tay mình, hắn nhớ rõ ràng, lúc này trên tay đầy vết máu do tu luyện Thông Bối Quyền gây ra, làm sao bây giờ lại không có?\n" +
            "\n" +
            "Lâm Động nghi ngờ vuốt ve cánh tay, đột nhiên thân thể cứng đờ. Khuôn mặt hắn nhanh chóng hiện lên thần sắc không thể tin nổi, bởi vì hắn phát hiện, làn da cánh tay mình đã trở nên cứng rắn hơn rất nhiều!\n" +
            "\n" +
            "Tình huống như thế này là dấu hiện sắp đột phá lên Thối Thể đệ tứ trọng.\n" +
            "\n" +
            "\"Này… Làm sao có thể?!?\"\n" +
            "\n" +
            "Phát hiện ra chuyện này, cho dù Lâm Động là người trong cuộc cũng phải trợn mắt há mồm nhìn.','https://hhpanda.tv/images/1639587483.jpg',1)";
    private String SQLQuery8 = "INSERT INTO truyen VALUES (null,'ĐẤU LA ĐẠI LỤC','Chương 1: Đấu La Đại Lục (1)\n" +
            "\n" +
            "\n" +
            "Ba Thục còn có mỹ danh Thiên Phủ Chi Quốc, trong đó nổi danh nhất chính là Đường Môn\n" +
            "\n" +
            "Đường Môn là một thần bí địa phương, rất nhiều người chỉ biết đó là một địa điểm giữa sườn núi, mà đỉnh núi nơi Đường Môn tọa lạc lại có một cái tên làm kẻ khác đảm chiến kinh tâm - Quỷ Kiến Sầu.\n" +
            "\n" +
            "Từ đỉnh Quỷ Kiến Sầu mà ném ra một hòn đá, phải đến 19 mới nghe được tiếng vang của hòn đá va chạm dưới chân núi, có thể thấy được núi cao thế nào, cũng bởi vì mười chín giây này, vượt qua mười tám tầng địa ngục một bậc, nên mới có cái tên này.\n" +
            "\n" +
            "Một gã hôi y (áo xám) thanh niên đang đứng trên đỉnh núi Quỷ Kiến Sầu, gió núi mãnh liệt không làm thân thể hắn di động chút nào, từ trên ngực hắn ngực có một chữ Đường lớn có thể nhận ra, hắn đến từ Đường Môn, áo xám đại biểu là Đường Môn ngoại môn đệ tử.\n" +
            "\n" +
            "Hắn năm nay hai mươi chín tuổi, xuất sanh không lâu thì tiến vào Đường Môn, trong ngoại môn bài danh đệ tam, bởi vậy ngoại môn đệ tử xưng hắn một tiếng Tam Thiếu. Đương nhiên, tới miệng nội môn đệ tử miệng, tựu biến thành Đường Tam.\n" +
            "\n" +
            "Đường Môn từ khi thành lập thì bắt đầu chia làm nội ngoại nhị môn, ngoại môn đệ tử đều là ngoại tính (họ khác) hoặc được thụ dư (ban cho) Đường tính (họ Đường), mà nội môn là Đường Môn trực hệ gia tộc truyền thừa.\n" +
            "\n" +
            "Lúc này, vẻ mặt Đường Tam rất phong phú, khi thì cười, khi thì khóc, nhưng vô luận thế nào, đều không thể che dấu hưng phấn phát ra từ nội tâm.\n" +
            "\n" +
            "Hai mươi chín năm, hai mươi chín năm trước hắn được ngoại môn trưởng lão Đường Lam thái gia nhặt về Đường Môn từ lúc còn nằm trong tã, Đường Môn chính là nhà hắn, mà Đường Môn ám khí chính là tất cả của hắn.\n" +
            "\n" +
            "Đột nhiên, Đường Tam sắc mặt chợt biến đổi, nhưng rất nhanh trở lại bình thường, có chút khổ sáp đích tự nhủ: \"Cái gì phải tới cuối cùng sẽ tới. \"\n" +
            "\n" +
            "Mười bảy đạo thân ảnh, mười bảy đạo bạch sắc thân ảnh, tựa như ánh sao toát ra từ sườn núi hướng đỉnh núi mà đến, chủ nhân mười bảy đạo thân ảnh này, tuổi nhỏ nhất cũng ngoại ngũ tuần (hơn 50), mỗi người đều thần sắc ngưng trọng, bọn họ mặc bạch y đại biểu chính là nội môn, mà chữ Đường màu vàng trước ngực là tượng trưng cho Đường Môn trưởng lão.\n" +
            "\n" +
            "Đường Môn nội môn trưởng lão đường kể cả chưởng môn Đường Đại tiên sinh tổng cộng có mười bảy vị trưởng lão, lúc này đăng sơn (lên núi) cũng là mười bảy vị. Cho dù là võ lâm đại hội cũng không thể kinh động toàn bộ Đường Môn trưởng lão đồng thời xuất động, phải biết rằng, trong số Đường Môn trưởng lão, người lớn tuổi nhất đã vượt qua hai giáp (hơn 120 tuổi).\n" +
            "\n" +
            "Đường Môn trưởng lão tu vi, không ai không đạt tới cực cảnh, chỉ trong chớp mắt, bọn họ cũng đã đi tới đỉnh núi.\n" +
            "\n" +
            "Ngoại môn đệ tử nhìn thấy nội môn trưởng lão, chỉ có thể quỳ xuống nghênh đón, nhưng lúc này, Đường Tam bất động, chỉ lẳng lặng nhìn các trưởng lão sắc mặt ngưng trọng đi tới trước mặt, ngăn lại tất cả đường đi, mà sau lưng hắn là Quỷ Kiến Sầu.\n" +
            "\n" +
            "Buông ba đóa Phật Nộ Đường Liên, Đường Tam cuối cùng cúi đầu, ánh mắt lưu luyến không thôi, khóe miệng toát ra một nụ cười vui mừng, hắn dù sao cũng đã thành công, cố gắng hai mươi năm, hắn rốt cục hoàn thành chế tạo Đường gia ngoại môn ám khí đỉnh phong, cái loại thỏa mãn về thành tựu này không thể dùng ngôn ngữ hình dung được.\n" +
            "\n" +
            "Giờ phút này, Đường Tam có cảm giác đối với chính mình mà nói, tất cả đều đã không còn trọng yếu, vi bối môn quy cũng được, sanh tử tồn vong cũng được, tựa hồ tất cả đều theo ba đóa Đường Liên đang nở rộ trước mắt mà kết thúc, Phật Nộ Đường Liên, loại ám khí bá đạo nhất thế gian này đản sinh trong chính tay mình, còn gì có thể làm Đường Tam hưng phấn hơn loại ám khí có tẩm dâm dược này?\n" +
            "\n" +
            "\"Ta biết, trộm nhập nội môn, học trộm bổn môn tuyệt học tội không thể tha thứ. Môn quy bất dung, nhưng Đường Tam có thể hướng lên trời mà thề, tuyệt không đem một điểm nào của bổn môn tuyệt học mà ta hoc trộm được tiết lộ ra bên ngoài. Ta nói điều này, cũng không phải hy vọng được các trưởng lão khoan dung, chỉ là muốn nói cho các trưởng lão, Đường Tam chưa bao giờ quên nguồn cội. Trước kia không có, sau này cũng không có. \"\n" +
            "\n" +
            "Đường Tam lúc này tâm tình rất tỉnh táo, có lẽ đây là lúc hắn tỉnh táo nhất trong đời. Nhìn đại viện cổ xưa của Đường Môn trên sườn núi, cảm thụ không khí thuộc về Đường Môn, Đường Tam mắt đã ươn ướt. Từ khi hắn bắt đầu hiểu chuyện, có thể nói, hắn chính là vì Đường Môn mà sinh, mà lúc này, cũng nên vì điều mà chính mình theo đuổi suốt cuộc đời lại vì Đường Môn mà đi.\n" +
            "\n" +
            "Các trưởng lão đều không nói gì, bọn họ lúc này còn chưa thể tỉnh táo sau khi chứng kiến Phật Nộ Đường Liên xuất hiện. Hai trăm năm, suốt hai trăm năm, Phật Nộ Đường Liên dĩ nhiên xuất hiện trong tay một ngoại môn đệ tử, điều có ý nghĩa gì? Phách tuyệt thiên hạ, tuyệt thế ám khí mà ngay cả người của chính Đường Môn cũng không thể ngăn cản đại biểu tuyệt đối là thời kì đỉnh phong của Đường Môn đã tới.\n" +
            "\n" +
            "Nhìn các trưởng lão cúi đầu không nói, Đường Tam thản nhiên cười, \"Đường Tam hết thảy mọi thứ đều là Đường Môn cấp, bất luận là sinh mệnh hay năng lực, đều là Đường Môn phú dư, bất luận lúc nào, Đường Tam sống là người của Đường Môn, chết là quỷ của Đường Môn, ta biết, các trưởng lão sẽ không cho phép thi thể ta, một ngoại môn đệ tử vi bối môn quy ở lại Đường Môn, đã như vật, hãy để xương cốt ta hòa vào tự nhiên Ba Thục đi. \"\n" +
            "\n" +
            "Thanh âm Đường Tam bình tĩnh, thậm chí có chút hưng phấn rốt cục làm các trưởng lão bừng tỉnh, lúc các trưởng lão ngẩng đầu nhìn về phía hắn, chỉ thấy một tầng \"nhũ bạch sắc\" (màu kem) khí lưu trong nháy mắt từ hắn trên người tỏa ra.\n" +
            "\n" +
            "\"Huyền thiên bảo lục, ngươi ngay cả bổn môn tối cao nội công, Huyền Thiên Bảo Lục cũng học rồi? \" Đường đại tiên sinh thất thanh nói.\n" +
            "\n" +
            "Oanh! Một tiếng nổ vang lên, lúc các vị trưởng lão đồng thời lui về sau để phòng bất trắc, bọn họ cũng thấy Đường Tam xích lõa toàn thân.\n" +
            "\n" +
            "Đường Tam cười, hắn tươi cười rất sáng lạn, \"xích lõa mà đến, xích lõa mà đi, Phật Nộ Đường Liên xem như lễ vật cuối cùng Đường Tam lưu lại cho bổn môn. Bây giờ, ngoại trừ con người của ta ra, ta không mang đi bất cứ vật gì của Đường Môn, bí tịch tất cả đều nằm trong khối gạch đầu tiên dưới cửa phòng ta. Đường Tam bây giờ đã đem tất cả đều trả lại cho Đường Môn. \"\n" +
            "\n" +
            "\"Ha ha ha ha ha ha ha......\" Đường Tam ngửa mặt lên trời cuồng tiếu, bước nhanh về phía sau, lúc này, các vị Đường Môn trưởng lão đột nhiên phát hiện, nhưng cũng không ai kịp ngăn cản hắn, thân thể hắn trong bạch quang bao phủ, như tia chớp phóng về Quỷ Kiến Sầu phía trước, thân hình cao lớn bay vút lên, bay về phía mây mù giữa núi.\n" +
            "\n" +
            "\"Chờ một chút.\" Đường đại tiên sinh rốt cục đã phản ứng, nhưng là, lúc này hắn nói cái gì đi nữa cũng đều đã chậm.\n" +
            "\n" +
            "Mây mù dày đặc, mang theo trận trận khí ẩm, mang đi ánh mặt trời, cũng mang đi Đường Tam, người đem cả đời cống hiến cho Đường Môn cùng ám khí.\n" +
            "\n" +
            "Thời gian tựa hồ \"đình trệ\" (dừng lại), Đờng Đại tiên sinh hai tay run rẩy nâng ba đóa Đường Liên trước mặt lên, mắt hắn đã ươn ướt, \"Đường Tam a Đường Tam, ngươi sao phải khổ như vậy chứ? Ngươi thật sự gây cho chúng ta nhiều kinh ngạc, nhiều lắm......\"\n" +
            "\n" +
            "\"Đại ca.\" Nhị trưởng lão tiến lên một bước, \"Cần gì phải thương xót phản đồ này? \"\n" +
            "\n" +
            "Đường Đại tiên sinh ánh mắt trong nháy mắt biến lãnh, toàn thân hàn khí đại thịnh, trừng mắt nhìn Nhị trưởng lão, \"Ngươi nói ai là phản đồ? Ngươi đã gặp qua một phản đồ sau khi đoạt được bổn môn tối cao bí tịch còn không trốn? Ngươi đã gặp qua một phản đồ dùng cái chết để chứng minh? Ngươi đã gặp qua một người mang tuyệt thế ám khí đủ để hủy diệt tất cả Đường Môn cao thủ nhưng lại lấy đó làm lễ vật cuối cùng cho Đường Môn? Đường Tam không phải phản đồ, hắn là thiên tài xuất sắc nhất bổn môn hai trăm năm qua.\"\n" +
            "\n" +
            "Nhị trưởng lão ngẩn ngơ, \"Nhưng là, hắn học trộm bổn môn......\"\n" +
            "\n" +
            "Đường đại tiên sinh chợt cắt đứt, \"Nếu ngươi cũng có thể làm ra Phật Nộ Đường Liên, ngươi trộm cái gì ta cũng có thể bất kể. Ngươi sai rồi, ta cũng sai rồi, một khắc trước, chúng ta dĩ nhiên trơ mắt nhìn cơ hội làm cho Đường Môn tái huy hoàng trước mắt trôi đi. \"\n" +
            "\n" +
            "Các vị trưởng lão xông tới, bọn họ thần sắc đều rất phức tạp, có nghi hoặc, có thương cảm, có thở dài, nhiều nhất vẫn là tiếc nuối.\n" +
            "\n" +
            "\"Các ngươi không cần nói gì cả, truyền lệnh ta, lệnh bổn môn đệ tử toàn thể xuất động, dưới Quỷ Kiến Sầu tìm Đường Tam, sống phải gặp người, chết phải thấy xác. Đồng thời, từ giờ khắc này, Đường Tam tấn thăng làm bổn môn nội môn đệ tử, nếu hắn còn sống, là người duy nhất kế thừa ta ngôi vị chưởng môn. \"\n" +
            "\n" +
            "\"Rõ, chưởng môn. \" Chúng trưởng lão đồng thời khom người tuân mệnh.\n" +
            "\n" +
            "Nếu Đường Tam lúc này còn ở trên vách núi, còn có thể nghe được Đường Đại tiên sinh nói, cho dù chết, hắn cũng nhất định rất vui mừng, cố gắng của hắn cuối cùng không uổng phí. Nhưng là, tất cả đều đã muộn một chút.\n" +
            "\n" +
            "Quỷ Kiến Sầu, một tảng đá rơi cũng phải mất hơn mười chín giây, tựa hồ siêu việt mười tám tầng địa ngục tồn tại, như thế nào có thể cho phép một người được mây mù phóng thích sống mà về? Đường Tam đi, hắn vĩnh viễn rời khỏi thế giới này, nhưng vận mệnh hắn một lần khác lại vừa mới bắt đầu.\n" +
            "\n" +
            "Đấu La Đại Lục, Thiên Đấu đế quốc TâyNam, Pháp Tư Nặc hành tỉnh.\n" +
            "\n" +
            "Thánh Hồn thôn, nếu là chỉ nghe kỳ danh, vậy tuyệt đối là một cái tên làm kẻ khác kinh ngạc, nhưng trên thực tế, đây bất quá chỉ là Pháp Tư Nặc hành tỉnh Nặc Đinh thành Nam một cái thôn nhỏ chỉ có hơn ba trăm hộ mà thôi. Sở dĩ tên là Thánh Hồn, là bởi vì trong truyền thuyết, trăm năm trước nơi này từng sinh ra một vị hồn sư đạt đến hồn thánh cấp bậc mà theo đó thành danh. Điều này cũng là Thánh Hồn thôn vĩnh viễn kiêu hãnh.\n" +
            "\n" +
            "Bên ngoài Thánh Hồn thôn, là một khi trồng trọt rộng rãi, nơi này xuất sản lương thực cùng thực phẩm, đều cung cấp cho Nặc Đinh thành, Nặc Đinh thành trong Pháp Tư Nặc hành tỉnh mặc dù không coi là đại thành thị, nhưng nơi này dù sao khoảng cách cùng biên giới với một đế quốc khác cũng rất gần, cũng tự nhiên là một trong những nơi đầu tiên mà thương nhân hai đại đế quốc giao dịch, Nặc Đinh thành bởi vậy mà phồn vinh, theo đó làm cho cuộc sống của bình dân trong thôn trang xung quanh thành thị so với địa phương khác tốt hơn nhiều.\n" +
            "\n" +
            "Trời mới tờ mờ sáng, xa xa phương đông mọc lên một mảng bạch sắc nhàn nhạt, trên một tòa tiểu sơn cao chỉ hơn trăm thước bên ngoài Thánh Hồn thôn, đã có thêm một đạo thân ảnh nhỏ gầy.\n" +
            "\n" +
            "Đó là một hài tử chỉ năm, sáu tuổi, hiển nhiên, hắn thường xuyên thừa nhận sự ấm áp của mặt trời, da tay \"tiểu mạch sắc\" (màu hơi nâu nâu) khỏe mạnh, hắc sắc đoản phát nhìn qua rất lanh lợi, một thân quần áo mặc dù đơn giản nhưng sạch sẽ.\n" +
            "\n" +
            "Đối với một tiểu hài tử như hắn mà nói, trèo lên ngọn núi cao trăm thước này cũng không phải là chuyện dễ dàng gì, nhưng kỳ quái chính là, hắn đi tới đỉnh núi nhưng mặt lại không đỏ, không thở gấp, bộ dáng rất tự đắc.\n" +
            "\n" +
            "Nam hài ngồi xuống trên đỉnh núi, hai mắt hắn gắt gao nhìn về phương Đông đang dần sáng lên một màu trắng, mũi chậm rãi hít vào, miệng từ từ thở ra, hít vào liên tục, thở ra nhẹ nhàng, đúng là hình thành vòng tuần hoàn tuyệt vời.\n" +
            "\n" +
            "Ngay lúc này, mắt hắn đột nhiên mở to, xa xa nơi chân trời, trong mảng bạch sắc đang sáng dần lên, phảng phất hiện lên một tia tử khí nhàn nhạt, nếu không phải có mục lực kinh người cùng không đủ chuyên chú, là tuyệt đối không cách nào phát hiện nó tồn tại.\n" +
            "\n" +
            "Tử khí xuất hiện, làm nam hài tinh thần hoàn toàn tập trung lại, hắn thậm chí không hề thở ra, chỉ là từ từ hít vào rất nhẹ nhàng, đồng thời hai mắt gắt gao nhìn về phía màn tử sắc lúc ẩn lúc hiện.\n" +
            "\n" +
            "Thời gian tử khí xuất hiện cũng không dài, khi phương Đông được ánh mặt trời từ từ dâng lên bao trùm thì tử khí đã hoàn toàn biến mất.\n" +
            "\n" +
            "Nam hài lúc này mới chậm rãi nhắm hai mắt lại, đồng thời thở ra một hơi thật dài trọc khí trong cơ thể. Một đạo bạch sắc khí lưu giống như từ miệng hắn phun ra, sau đó từ từ tản đi.\n" +
            "\n" +
            "Tĩnh tọa một hồi lâu, nam hài mới lại mở mắt, không biết có phải là tử khí triêm nhiễm không, trong đôi mắt hắn lóe lên một tầng nhàn nhạt tử ý, mặc dù tử sắc này tồn tại trong thời gian không dài rồi lặng yên thu liễm, nhưng chính lúc nó tồn tại cũng rất rõ ràng.\n" +
            "\n" +
            "Chán nản thở dài, nam hài làm ra một vẻ mặt bất đắc dĩ tuyệt không nên xuất hiện ở tuổi hắn, lắc đầu, lầm bầm nói: \"Vẫn không được, Huyền Thiên Công ta như trước không cách nào đột phá đệ nhất trọng bình cảnh. Đã suốt ba tháng, rốt cuộc là tại sao? Cho dù là Tử Cực Ma Đồng phải dựa vào \"tử khí đông lai\" (khí tím đến từ phía Đông) chỉ có thể tu luyện vào sáng sớm vẫn đang tiến bộ. Huyền Thiên Công không thể đột phá bình cảnh, Huyền Ngọc Thủ cũng vô pháp tăng lên. Lúc đầu ta tu luyện, tại đệ nhất trọng đến đệ nhị trọng, lúc đó tựa hồ cũng không gặp phải tình huống như vậy. Huyền Thiên Công tổng cộng cửu trọng, sao mà đệ nhất trọng này lại phiền toái như vậy? Chẳng lẻ, là bởi vì thế giới này cùng thế giới kia của ta vốn bất đồng sao? \"\n" +
            "\n" +
            "Đi tới thế giới này đã hơn năm năm, hài tử trước mắt này, đúng là Đường Tam lúc đầu ở Đường Môn \"khiêu nhai minh chí\" (nhảy vực chứng minh). Khi hắn từ trong hôn mê tỉnh táo lại, phát hiện ngoại trừ cảm giác ấm áp cái gì cũng không làm được. Nhưng cái chết trong dự liệu cũng không có tới, rất nhanh, hắn thông qua một quá trình dồn nén đi tới thế giới này.\n" +
            "\n" +
            "Qua một thời gian rất lâu, Đường Tam mới hiểu được chuyện gì xảy ra. Chính mình không chết, nhưng đã không còn là Đường Tam trước đây.\n" +
            "\n" +
            "Lúc xuất sanh, Đường Tam dùng đến gần một năm thời gian, mới học được thế giới này ngữ ngôn. Hắn còn nhớ rõ, lúc chính mình xuất sanh, mặc dù vẫn không cách nào mở mắt quan khán, nhưng nghe được một giọng nam nhân hùng hậu đang \"tê tâm liệt phế\" (cõi lòng tan nát) mà kêu khóc. Khi hắn học xong thế giới này ngữ ngôn, bằng vào trí nhớ hơn người nhớ lại thì, cũng chỉ có thể nhớ, nam nhân kia tựa hồ kêu lên: \"Tam muội, đừng bỏ ta.\" Mà nam nhân kia, chính là cha hắn Đường Hạo. Mẫu thân hắn ở thế giới này, khi đó cũng đã chết trong lúc khó sanh.\n" +
            "\n" +
            "Không biết là thiên ý, hay là nhân duyên trùng hợp, vì kỷ niệm thê tử chết đi, Đường Hạo đặt cho hắn một cái tên thần kỳ sao vẫn là Đường Tam.\n" +
            "\n" +
            "Những đứa trẻ đồng trang đứa trong thôn thường xuyên hội lấy điều này giễu cợt hắn, nhưng Đường Tam trong lòng lại thập phần hài lòng. Dù sao cái tên này tại thế giới bên kia hắn cũng đã sử dụng gần ba mươi năm. Chỉ riêng chuyện quen thuộc cũng đã làm hắn sớm thích hai chữ này.\n" +
            "\n" +
            "Đi tới thế giới này, trải qua bắt đầu là giật mình, sợ hãi, đến sau lại là hưng phấn cùng với bây giờ là bình tĩnh, Đường Tam đã hoàn toàn tiếp nhận sự thật, hắn xem ra, đây là ông trời lại cho hắn một cơ hội nữa. Kiếp trước tâm nguyện lớn nhất, có lẽ có thể trong một đời này thực hiện rồi.\n" +
            "\n" +
            "Xích lõa đi tới thế giới này, nhưng Đường Tam đã có lớn nhất tài phú, đó chính là trí nhớ. Thân là Đường Môn ngoại môn xuất sắc nhất thiên tài, Đường Môn các loại \"cơ quan loại ám khí\" (ám khí dùng cơ quan để phát động) phương pháp chế tạo toàn bộ khắc trong óc hắn. Mà lúc đầu hắn trộm đi Đường Môn nội môn bí tịch, khát vọng trong nhiều năm đạt được, trong quá trình học tập, nội môn tối cao Huyền Thiên Bảo Lục cũng đồng dạng được hắn ghi vào trong tâm. Đường Tam hy vọng, có thể ở thế giới này lại hiện ra Đường Môn huy hoàng.\n" +
            "\n" +
            "\"Cần phải trở về.\" Đường Tam nhìn sắc trời, thân thể gầy gò phóng lên, hướng dưới chân núi chạy đi. Nếu lúc này có người thấy hắn, nhất định sẽ kinh ngạc đích mở to hai mắt nhìn, hắn mỗi bước bước ra, cũng có thể gần một trượng, những hố bất không bằng phẳng trên mặt đất đối với hắn mà nói căn bản không có ảnh hưởng gì, dễ dàng né tránh, trong lúc đó cấp tốc bước đi, so với người trưởng thành còn muốn nhanh hơn nhiều.\n" +
            "\n" +
            "Đường Môn tinh túy là cái gì? Ám khí, độc dược cùng khinh công. Đường Môn nội môn cùng ngoại môn khác nhau lớn nhất, chính là phương pháp sử dụng ám khí. Ngoại môn lấy cơ quan loại là chính, mà nội môn lại là thủ pháp chân chính. Độc dược bình thường là ngoại môn mới dùng, nội môn đích truyền đệ tử ám khí rất ít dụng độc, bởi vì bọn họ căn bản không cần.\n" +
            "Chương 2: Đấu La Đại Lục (2)\n" +
            "Võ công ghi lại trên Huyền Thiên Bảo Lục chỉ có sáu loại, phân biệt là nội công tâm pháp Huyền Thiên Công, luyện tay phương pháp Huyền Ngọc Thủ. Luyện nhãn phương pháp Tử Cực Ma Đồng. \"Cầm nã pháp\" (phương pháp bắt) Khống Hạc Cầm Long, khinh thân phương pháp Quỷ Ảnh Mê Tung, cùng với ám khí sử dụng phương pháp, Ám Khí Bách Giải.\n" +
            "\n" +
            "Năm loại trước là trụ cột. Không có trụ cột vững chắc. như thế nào có thể phát huy hết tinh túy của Đường Môn ám khí chứ?\n" +
            "\n" +
            "Một tuổi đã bắt đầu tu luyện Huyền Thiên Công, bây giờ Đường Tam đã sắp sáu tuổi. Hắn như trước vẫn tu luyện cơ sở.\n" +
            "\n" +
            "Nhà Đường Tam ở tại phía Tây Thánh Hồn thôn. Ở vị trí đầu thôn, ba gian phòng đất có thể nói đơn sơ nhất trong thôn. Giữa căn nhà, có một mộc bài đường kính chừng một thước, mặt trên vẽ một cái đơn sơ \"chuy tử\" (chùy), chuy tử ở thế giới này, nghiễm nhiên đại biểu ý nghĩa chính là thợ rèn.\n" +
            "\n" +
            "Đúng vậy, Đường Hạo, cha của Đường Tam chính là một thợ rèn. Thợ rèn duy nhất trong thôn.\n" +
            "\n" +
            "Ở thế giới này. Thợ rèn có thể nói là một trong những nghề thấp hèn nhất. Bởi vì đặc thù nguyên nhân nào đó, thế giới này đỉnh cấp vũ khí cũng không phải do thợ rèn làm ra.\n" +
            "\n" +
            "Nhưng là, thợ rèn duy nhất trong thôn, vốn nhà Đường Tam không nghèo khó như vậy. nhưng là, về điểm này, thu nhập ít ỏi hầu hết đều......\n" +
            "\n" +
            "Vừa vào đến cửa, Đường Tam đã ngửi thấy được mùi cơm, đó cũng không phải là Đường Hạo vì hắn chuẩn bị, mà là hắn chuẩn bị vì Đường Hạo.\n" +
            "\n" +
            "Từ lúc mới bốn tuổi, Đường Tam thân cao vẫn chưa cao bằng táo thai (bệ bếp), nấu cơm cũng là nhiệm vụ của hắn mỗi ngày. Cho dù là phải đứng trên ghế mới có thể tới mặt bếp.\n" +
            "\n" +
            "Cũng không phải Đường Hạo yêu cầu hắn làm như vậy, mà là bởi vì không như vậy, Đường Tam cơ hồ không lúc nào có thể ăn no.\n" +
            "\n" +
            "Đi tới trước bếp, thuần thục đứng trên ghế,mở vung nồi lớn trước mặt, tức thì mùi hương truyền đến, cháo đã sớm chín rồi.\n" +
            "\n" +
            "Mỗi ngày trước khi lên núi. Đường Tam đều cho gạo vào nồi, chuẩn bị đủ củi. Chờ hắn khi trở về, cháo đã chín rồi.\n" +
            "\n" +
            "Cầm lấy hai cái bát sứt mẻ đã hơn mười chỗ gần \"táo thai\" (bệ bếp), Đường Tam cẩn thận múc đầy hai chén cháo. Sau khi đặt lên bàn, gạo trong cháo có thể đếm được, đối với Đường Tam đang tuổi lớn chừng ấy dinh dưỡng hiển nhiên là không đủ, đây cũng là nguyên nhân tại sao thân thể hắn nhỏ bé, gầy gò như vậy.\n" +
            "\n" +
            "\"Ba ba. Ăn cơm thôi. \" Đường Tam kêu lên. (Nghe giống đang gọi con ba ba nhỉJ)\n" +
            "\n" +
            "Một lúc lâu sau, tấm màn cửa được nhấc lên, một thân ảnh cao lớn có chút lảo đảo bước ra.\n" +
            "\n" +
            "Đó là một trung niên nam tử. Nhìn qua ước chừng gần năm mươi tuổi. Nhưng vóc người nhưng lại phi thường cao lớn khôi ngô, chỉ là trang phục hắn khiến người khác có chút coi thường.\n" +
            "\n" +
            "Khoác trên người một tấm áo rách, thậm chí chỗ rách cũng không được vá lại, lộ ra phía dưới làn da màu cổ đồng, ngũ quan vốn coi như đoan chính lại bị phủ một tầng sáp vàng, \"mắt nhắm mắt mở\" (thụy nhãn mông lung), mái tóc rối như tổ chim, râu mép đã không biết bao lâu rồi không có sửa sang lại, ánh mắt ngốc trệ mà tăm tối, mặc dù đã qua một đêm, nhưng mùi rượu trên người hắn vẫn còn làm Đường Tam không khỏi nhíu nhíu mày.\n" +
            "\n" +
            "Đây là Đường Hạo, cha của Đường Tam ở thế giới này.\n" +
            "\n" +
            "Từ nhỏ đến lớn. Đường Tam không biết cái gì gọi là tình cha. Đường Hạo đối với hắn, cho tới bây giờ đều là không để ý đến. Ban đầu còn nấu cơm cho hắn ăn. Nhưng theo thời gian trôi đi, lúc Đường Tam bắt đầu chủ động nấu cơm, Đường Hạo càng cái gì cũng mặc kệ, trong nhà nghèo khó như thế, thậm chí ngay cả bàn ghế cũng không có. Ăn cơm cũng là vấn đề, nguyên nhân chủ yếu là Đường Hạo đem hầu hết tiền công làm thợ rèn đều mua rượu để uống.\n" +
            "\n" +
            "Cha của những hài tử tầm tuổi Đường Tam bình thường cũng khoảng ba mươi tuổi. Kết hôn sớm thậm chí còn không đến ba mươi tuổi. Nhưng Đường Hạo thoạt nhìn so với người ta già hơn nhiều, giống như là gia gia của Đường Tam vậy.\n" +
            "\n" +
            "Đối với thái độ của Đường Hạo, Đường Tam cũng không oán hận. Một đời trước, hắn là cô nhi. Một đời này, mặc dù Đường Hạo đối với hắn không tốt, nhưng ít ra cũng có thân nhân. Đối với Đường Tam mà nói, điều này đã làm hắn thập phần thỏa mãn. Ít nhất, ở chỗ này có người để hắn gọi là ba ba.\n" +
            "\n" +
            "Đường Hạo cầm lấy cái trên bàn, cũng không sợ nóng, từng ngụm từng ngụm đưa cháo vào bụng mình. Lúc này sắc mặt hắn nhìn mới tốt hơn vài phần.\n" +
            "\n" +
            "\"Ba ba, ngươi chậm một chút. Còn có mà.\" Đường Tam cầm lấy bát trong tay cha mình, múc cho hắn một bát đầy cháo nữa. Chính mình cũng cầm lấy bát cháo lên húp.\n" +
            "\n" +
            "Khi còn ở Đường Môn, hắn cũng không có đi đâu, đối với bên ngoài càng rất ít tiếp xúc. Vốn giống như tờ giấy trắng, tới thế giới này, một lần nữa làm một tiểu hài tử, cũng không có gì không thể tiếp nhận.\n" +
            "\n" +
            "Rất nhanh, một nồi cháo có bảy, tám phần đều tiến vào bụng Đường Hạo, thở dài một hơi, đem bát đặt ở trên bàn. Mắt mở to ra vài phần, nhìn về phía Đường Tam.\n" +
            "\n" +
            "\"Có công việc ngươi trước hết cứ tiếp nhận. Xế chiều ta sẽ làm. Ta đi ngủ tiếp một hồi. \"\n" +
            "\n" +
            "Thói quen của Đường Hạo rất có quy luật, buổi sáng đều là ngủ. Xế chiều \"đánh tạo\" (rèn) một ít nông cụ kiếm ít thu nhập, buổi tối uống rượu.\n" +
            "\n" +
            "\"Được, ba ba.\" Đường Tam gật đầu.\n" +
            "\n" +
            "Đường Hạo đứng lên. Ăn không ít cháo, thân thể hẵn rốt cục đã không hề lay động. Hướng nhà trong đi đến.\n" +
            "\n" +
            "\"Ba ba.\" Đường Tam đột nhiên kêu một tiếng.\n" +
            "\n" +
            "Đường Hạo đứng lại, quay đầu nhìn về phía hắn. Cặp lông mày rõ ràng có vài phần không kiên nhẫn.\n" +
            "\n" +
            "Đường Tam chỉ vào một khối sắt có tầng nhàn nhạt ô quang trong góc nói: \"Khối sắt có thể cho con dùng hay không?\" Kiếp trước hắn là Đường Môn ngoại môn đệ tử xuất sắc nhất, đối với chế tạo các loại ám khí cực kỳ quen thuộc. Đương nhiên, khi đó các loại tài liệu đều là tùy Đường Môn cung cấp. Mà lúc tới thế giới này, hắn mặc dù tu luyện cũng đã vài năm. Nhưng thực lực còn xa mới đủ, đồng thời, hắn cũng chưa bao giờ nghĩ tới chuyện buông bỏ chế tạo ám khí mà chính mình am hiểu nhất. Hắn bây giờ đã bắt đầu thử \"đoán tạo\" (chế tạo) một ít ám khí. Nhưng tài liệu lại thành đại vấn đề.\n" +
            "\n" +
            "Kim loại mà Đường Hạo đánh tạo nông cụ đều là người trong thôn đưa tới. Đều là sắt thường rất nhiều tạp chất, rất khó chế tạo ra ám khí tốt. Lúc này khối sắt mà Đường Tam chỉ là ngày hôm qua vừa mới đưa tới. Làm Đường Tam kinh ngạc địa là, khối sắt này chứa một lượng nhất định thiết mẫu, dùng để chế tạo ám khí sẽ khá thích hợp.\n" +
            "\n" +
            "Đường Hạo mục quang chuyển qua khối sắt. \"Di, nơi này có thiết tinh?\" Đi qua cúi đầu nhìn khối sắt một chút, rồi quay đầu nhìn về phía Đường Tam: \"Ngươi sau này muốn làm một thợ rèn sao?\"\n" +
            "Chương 3: Đấu La đại lục (3)\n" +
            "Dị giới Đường Tam(tam)\n" +
            "\n" +
            "Dịch giả: Yêu Sinh Hận\n" +
            "\n" +
            "Đường Tam gật đầu, nghề nghiệp thợ rèn này không thể nghi ngờ là thích hợp nhất để hắn rèn ám khí, \"Ba ba, ngươi lớn tuổi rồi, qua vài năm nữa, chờ ta lớn một chút, ngươi sẽ dạy ta đánh tạo công cụ, để ta làm thay công việc của ngươi nghen.\"Trước kia công việc hắn làm đều là rèn ám khí tinh vi nhất, ngược lại những loại đơn giản nhất thì lại không biết. Đường Hạo thoáng có chút thất thần, thì thào nói: \"Thợ rèn, tựa hồ cũng rất tốt.\"Kéo qua một cái ghế cũ, hắn trực tiếp ngồi xuống trước mặt khối sắt nọ rồi nói: \"Tiểu Tam, ngươi nói cho ta biết, thợ rèn như thế nào mới là thợ rèn tốt nhất.\"\n" +
            "\n" +
            "Đường Tam suy nghĩ một chút, nói: \"Thợ rèn có thể làm ra thần khí, hẳn là thợ rèn tốt nhất.\"Hắn từng nghe người trong thôn nói qua, ở thế giới này có thần khí tồn tại, mặc dù hắn không biết thần khí rốt cuộc là cái gì. Nhưng có một chữ thần hẳn là rất tốt.\n" +
            "\n" +
            "Đường Hạo trong mắt hiện lên một tia đùa cợt, \"Thần khí? Tiểu Tam cũng biết đến thần khí. Vậy ngươi nói cho ta biết, thần khí dùng cái gì để làm ra? \"\n" +
            "\n" +
            "Đường Tam không chút nghĩ ngợi, nói thẳng: \"Đương nhiên chỉ dùng tài liệu tốt nhất.\"\n" +
            "\n" +
            "Đường Hạo vươn một ngón trỏ lắc lắc trước mặt Đường Tam, \"Nếu ngươi muốn làm một thợ rèn hợp cách, nhớ kỹ ta nói, dùng cao đẳng tài liệu rèn thần khí, đó không phải là thợ rèn tốt nhất, nhiều nhất chỉ là một \"hợp thành giả\" (người lắp ráp). Dùng sắt thường làm ra thần khí, mới là \"Tượng Thần\" (thợ thần – cái này trong Tinh Thần Biến cũng có nói qua rùiJ).\"\n" +
            "\n" +
            "\"Dùng sắt thường làm ra thần khí? \"Đường Tam có chút giật mình nhìn Đường Hạo. Ngày thường, Đường Hạo rất ít cùng hắn nói chuyện, hôm nay xem như đã là hôm nhiều nhất.\n" +
            "\n" +
            "Đứng thẳng lên, Đường Hạo chỉ sang phòng bên kia có một khối đại thiết năm mươi phân vuông, \"Muốn trở thành một thợ rèn, cùng ta học rèn. Vậy, ngươi dùng \"chùy tử\" (công cụ rèn – búa rèn)...trước đập nó một vạn lần, mới có tư cách này.\"\n" +
            "\n" +
            "Đó là một khối sắt thường, trong đó bao hàm rất nhiều tạp chất, so với khối thiết mẫu kia kém hơn không biết bao nhiêu lần.\n" +
            "\n" +
            "\"Bây giờ, ngươi còn có thể thay đổi chủ ý.\"Đường Hạo nhàn nhạt nói, đã chuẩn bị trở về nhà trong tiếp tục ngủ.\n" +
            "\n" +
            "\"Ba ba, ta nguyện ý thử xem.\"Đường Tam thanh âm thanh thúy mà bình tĩnh, nhưng bao hàm sự kiên định.\n" +
            "\n" +
            "Đường Hạo có chút ngoài ý muốn nhìn về phía hắn, \"Tốt.\"Vừa nói, hắn đi qua, đem khối đại thiết nọ ôm lấy, trực tiếp đặt ở cạnh ống bễ bên trong hỏa lò, chỉ cần thổi lửa lên, có thể đối với nó tiến hành rèn.\n" +
            "\n" +
            "Làm xong điều này, Đường Hạo trở vào nhà trong đi ngủ.\n" +
            "\n" +
            "Đường Tam là một người có tâm chí kiên định, nếu không, hắn cũng không thể dựa vào một tấm tàn phá đồ chỉ chế tạo được Phật Nộ Đường Liên, Đường Môn tối cao cơ quan loại ám khí, nó hao phí của hắn đến mười năm thời gian.\n" +
            "\n" +
            "Thổi lửa lên, khởi động ống bễ, hắn bắt đầu công việc của mình.\n" +
            "\n" +
            "\"Hô hô hô hô\" tiếng ống bễ vang lên, lửa từ trong lò toát ra, đốt lên khối đại thiết, mặc dù Đường Tam cũng chưa học rèn, nhưng hắn thường xuyên xem Đường Hạo đánh tạo nông cụ, quá trình vẫn còn biết.\n" +
            "\n" +
            "Sau khi khối sắt đã dần dần được thiêu đỏ, hắn đem thiết chùy Đường Hạo ngày thường vẫn dùng, đặt ở trên mặt đất, loại chùy cán dài này thậm chí so với hắn còn muốn cao hơn vài phần, bình thường hài tử năm, sáu tuổi căn bản không có khả năng cầm được, lại càng không nói là huy vũ nó để rèn liễu.\n" +
            "\n" +
            "Nhưng Đường Tam vẫn đem nó cầm lên, Huyền Thiên Công nội lực vận toàn thân, mặc dù chưa đột phá đệ nhất trọng, nhưng hắn cũng đã có khí lực của người trưởng thành.\n" +
            "\n" +
            "Đương, thiết chùy cùng khối sắt va chạm, phát ra một tiếng thanh thúy thanh âm, đây là Đường Tam lần đầu tiên đập xuống, cũng coi như vén tấm màn về rèn.\n" +
            "\n" +
            "Trong phòng, Đường Hạo đang nằm trên giường chuyển thân, mặc dù hắn nhắm mắt lại, nhưng trên mặt thần sắc lại có vài phần kinh ngạc, thì thào, \"Cư nhiên cầm được chùy, trời sanh thần lực sao? \"\n" +
            "\n" +
            "\"Đương đương đương đương\" Âm thanh trong lò rèn bắt đầu vang lên, Đường Hạo cùng Đường Tam phụ tử bắt đầu tiếp tục cuộc sống bình thản của bọn họ, chỉ là bất đồng là, từ ngày này bắt đầu, Đường Hạo chuẩn bị Đường Tam một cái hỏa lò trong phòng, để hắn chính mình rèn khối sắt nọ. Hắn không có chỉ điểm Đường Tam nửa câu, nhưng cũng từ ngày này bắt đầu, Đường Hạo rượu uống ít đi một chút, trong nhà thực vật cũng nhiều hơn một chút.\n" +
            "\n" +
            "Rèn tuyệt đối là một quá trình buồn tẻ và mệt nhọc, nhưng Đường Tam lại đem nó trở thành quá trình ma luyện đối với thân thể mình. Đã qua mười một ngày, hắn thủy chung vẫn đang đếm số lần đập, muốn huy động thiết chùy, bằng vào lực lượng của thân thể hắn là không cách nào làm được, phải có Huyền Thiên Công phụ trợ.\n" +
            "\n" +
            "Hắn toàn bộ công lực, ước chừng đủ huy động tầm một trăm chùy, mỗi khi công lực tiêu hao hầu như không còn, hắn liền khoanh chân ngồi dưới đất khôi phục, nội lực khôi phục đủ liền lập tức tiếp tục rèn.\n" +
            "\n" +
            "Đây không chỉ là thân thể rèn luyện, lặp đi lặp lại tiêu hao, khôi phục, đối với hắn Huyền Thiên Công cùng ý chí cũng là một loại ma luyện rất tốt. Đáng tiếc chính là, Huyền Thiên Công đệ nhất trọng bình cảnh lại như là bích lũy \"kiên bất khả tồi\" (vững chắc không thể phá hủy), Đường Tam tu luyện không phải không khắc khổ, hắn thiên phú cũng đủ, nhưng chỉ là không có cách nào đột phá tiến vào đệ nhị trọng.\n" +
            "\n" +
            "Nhưng hắn đích rèn luyện cũng không uổng phí, mặc dù Huyền Thiên Công không thể đột phá, nhưng cỗ nội lực lại theo hắn quá trình hắn rèn khối sắt kia mà trở nên càng thêm cứng cỏi, tốc độ khôi phục tựa hồ so với trước kia cũng nhanh hơn một điểm.\n" +
            "\n" +
            "Mười một ngày trôi qua, Đường Tam đã đánh ra hơn tám ngàn chùy, khối sắt không ngừng nhỏ đi, đã không được một phần ba thể tích ban đầu. Thân thể rèn luyện cùng thực vật tăng nhiều, hắn thân thể trở nên tráng kiện hơn vài phần, phảng phất có một cỗ khí lực phát ra từ trong cơ thể từ từ rót vào cơ thể hắn, làm hắn trong quá trình không ngừng rèn, nội lực tiêu hao từ từ giảm thiểu. Mà trong khi toàn bộ nội lực trợ giúp, lực lượng cũng tăng lên rất nhiều.\n" +
            "\n" +
            "Khi hắn nện xuống một ngàn chùy đích, khối sắt nọ cũng đã xuất hiện biến hóa nhất định, nhỏ đi một vòng, mặc dù đang bị lửa thiêu đỏ bừng, nhưng cũng mơ hồ có thể thấy, tạp chất bên trong tựa hồ giảm bớt rất nhiều.\n" +
            "\n" +
            "Bách luyện thành cương, từ này xuất hiện trong đầu Đường Tam, điều này càng thêm kiên định quyết tâm hoàn thành một vạn chùy của hắn. Mà khoảng cách đến mục tiêu này cũng đã rất gần.\n" +
            "\n" +
            "Đường Tam kiên trì làm Đường Hạo rất kinh ngạc, vì hắn xem ra, cho dù là con trai mình trời sanh thần lực, cũng không thể kiên trì quá ba ngày. Cán thiết chùy để dễ dàng làm thì rất thô, không ngừng huy động, cùng bàn tay cọ xát, tất nhiên sẽ mang đến cho bàn tay thương tổn rất lớn. Nhưng hắn lại phát hiện, Đường Tam mặc dù cật lực rèn, nhưng đôi tay nhỏ bé non nớt kia nhìn qua không có gì biến hóa. Thậm chí ngay cả một cái thủy phao (phồng nước) cũng không có nổi lên.','https://ia903101.us.archive.org/13/items/dau-la-dai-luc-anivsub.-org/%C4%90%E1%BA%A5u%20La%20%C4%90%E1%BA%A1i%20L%E1%BB%A5c%20-%20Anivsub.Org%20.png',1)";

    private String SQLQuery9 = "INSERT INTO truyen VALUES (null,'TINH THẦN BIẾN','Chương 01: Tần Vũ\n" +
            "\n" +
            "\n" +
            "Trời đang là mùa đông, tuyết rơi dầy khắp nơi, toàn kinh thành như được phủ thêm một lớp áo màu bạc. Viêm kinh thành rất lớn, khả dĩ có thể chứa số nhân khẩu là trăm vạn, người chịu trách nhiệm quản lý ba quận đông vực chính là Trấn Đông vương Tần Đức, phủ đệ cũng đặt tại kinh thành.\n" +
            "Phủ đệ của Trấn Đông vương chiếm một khoảng đất cực lớn, chính môn cả ngày lẫn đêm đều mở rộng. Cửa chính vào phủ rất rộng, có thể cùng lúc sáu bẩy người đi vào. Bạn đang đọc truyện tại Truyện FULL - www.Truyện FULL\n" +
            "Tại đại môn có luôn hai người đứng hai bên tả hữu của lối vào. Chỉ thấy đó là hai đại hán dũng mãnh thân trên không mặc y phục mà cởi trần. Họ đứng yên tựa như nham thạch điêu khắc mà thành, hai mắt luôn lạnh lùng nhìn lướt qua những người bộ hành đi ngang, sau lưng đeo huyết hồng sắc chiến đao, khí thế bức nhân.\n" +
            "Trong tiết đông lạnh giá hoa tuyết lất phất bay, nhiệt độ hạ xuống thấp mặt sông đều đã kết tinh thành băng nhưng hai đại hán hai thân trên vẫn cởi trần không hề mặc thêm gì cả. Nhưng điều làm cho mọi người kinh hãi chính là bên hai đại hán bất ngờ xuất hiện một lão hổ hung mãnh.\n" +
            "Lão hổ toàn thân hồng sắc rực lửa, thân thể dài khoảng hơn hai thước, đuôi ve vẩy trong không trung khiến không khí nhất thời xao động, từ đôi mắt hổ phát xuất tia hàn khí. Lão hổ chính thị được gọi là \"Liệt Hổ\"\n" +
            "Lúc đó từ Trấn Đông vương phủ xuất hiện hai đại hán giống như hai đại hán cởi trần đang đứng trước cửa, chỉ phân biệt nhờ vào liệt hổ hung mãnh họ dẫn theo, rồi họ thay đổi vị trí với nhau. Bên ngoài phủ đệ, dù là hào gia quý tộc hay là bình dân du dân tại Viêm kinh thành đều tự giác tránh đường đến gần Trấn Đông vương phủ.\n" +
            "Trong một tiểu viện u tĩnh tại Trấn Đông vương phủ.\n" +
            "Một trung niên nhân vận thanh y đang ngồi trên thạch kỷ, bên cạnh là một tiểu nam hài khả ái. Đứng trước mặt trung niên nhân là mười hai người, lão giả có, mĩ phụ có, hoặc là thanh niên cũng có…nhưng cả mười hai người này đều có điểm chung là đều mặc tử y.\n" +
            "\"Phụ vương, sao người lại gọi nhiều vị lão sư vậy?\" Hài tử Tần Vũ mới sáu tuổi đang ngồi trên đùi phụ thân, trong tay đang nghịch tuyết cầu, nghi hoặc nhìn phụ thân Tần Đức.\n" +
            "Tần Đức hòa ái nhìn nhi tử Tần Vũ, khẽ xoa đầu đoạn hướng về phía mười hai người kia điềm đạm nói: \"Các vị dậy dỗ Vũ nhi một khoảng thời gian, cũng đã tốn công không ít, không cần phải cân nhắc nữa, xin cho ta biết nhận xét. \"\n" +
            "Mười hai người kia nhìn nhau, sau cùng một lão giả có chòm râu bạc trắng tiến lên một bước, cung kính nói: \"Bẩm vương gia, chúng tại hạ đã quan sát về các phương diện, nhận thấy tam điện hạ đối với kỳ môn xảo kĩ rất có hứng thú, tuy nhiên đối với các vấn đề quyền thế không hề có chút hứng thú. Căn cứ vào những điều đó có thể phán đoán rằng tam điện hạ khó có khả năng phù hợp trở thành một người có vị trí cao.\"\n" +
            "Chỉ bằng vào vài ngày tiếp xúc với nam hài họ đã có thể đưa ra phán đoán như vậy, tựa như chém đinh chặt sắt. Tất nhiên Tần Đức trong lòng không thể hoài nghi được.\n" +
            "Tần Đức thở dài một tiếng, nhìn sang hài tử Tần Vũ ngây thơ chưa biết gì, cười khổ nói: \"Ta hiểu, Vũ nhi giống hệt mẹ nó, đối với quyền thế của thế tục không có một tia hứng thú, tuy nhiên nó sinh ra đã được định sẵn để trở thành…\"\n" +
            "Tần Đức đang nói đột nhiên ngừng lại, quay về phía sau phất tay nói: \"Thời gian qua đã làm phiền các ngươi nhiều, các người có thể li khai vương phủ.\" \"Vương gia, chúng tại hạ cáo từ!\"\n" +
            "Mười hai tử y nhân đồng thời cúi người, sau đó lần lượt rời khỏi tiểu trang viện u tĩnh.\n" +
            "Thời khắc đó, trong trang viện chỉ còn Tần Đức và nhi tử Tần Vũ. Tần Đức trầm mặc không nói gì, hồi lâu sau nhìn sang Tần Vũ, trong mắt chứa nhiều hàm ý khiến Tần Vũ mới chỉ là một đứa bé sáu tuổi không thể hiểu được.\n" +
            "\"Phụ vương, sao phụ vương không nói gì vậy?\" Tần Vũ trong lòng rất thắc mắc, nhưng nó vốn là đứa trẻ rất thông minh nên không tiếp tục làm phiền phụ thân. Từ nhỏ Tần Vũ đã mất mẫu thân, trong lòng nó thì phụ thân là trọng yếu nhất, ngoài ra còn có hai ca ca nữa. Rất lâu sau đó, Tần Đức vẫn ngồi như vậy và Tần Vũ cũng tiếp tục ngồi trên đùi của cha.\n" +
            "Đột nhiên, một tiếng hạc vang lên.\n" +
            "Chỉ thấy từ không trung một đạo bạch sắc tiên hạc bay tới, cưỡi phía trên là một trung niên tuấn nhã mang vẻ tiên phong đạo cốt, từ từ điều khiển tiên hạc hạ xuống trang viện. \"Phong huynh, Vũ nhi đan điền có vấn đề, huynh phải giúp ta tìm ra giải pháp…\" Tần Đức nhìn sang người trung niên, lo âu nói.\n" +
            "Phong Ngọc Tử nhìn sang Tần Đức, trong lòng đã tự nhiên đã hiểu rõ sự tình của hảo bằng hữu, chỉ thở dài: \"Vương gia, tại hạ đã nói rồi. Vũ nhi tại đan điền thập phần quái dị, hiện tại tu luyện nội công căn bản không có một tia hi vọng. Đã không thể tích tụ nội lực thì tự nhiên cũng không thể tu luyện nội công. Đan điền căn bản là do thiên sinh, trong hàng vạn người cũng không thể tìm được một người thứ hai nào như vậy, Phong Ngọc Tử ta thật sự không thể tìm ra giải pháp.\" Nghe lời đó, Tần Đức từ từ ngồi xuống trầm tư hồi lâu.\n" +
            "\"Phụ vương, nội lực là gì, đan điền không thể tích tụ nội lực là gì? Những vị lão sư lúc nãy cũng nói đến việc này, điều đó có nghĩa gì?\" Hài tử sáu tuổi Tần Vũ hai mắt nghi hoặc hỏi phụ thân. Lúc trước nó đã hỏi nhưng không được trả lời.\n" +
            "Tần Đức trong lòng chỉ biết cười khổ, ngoài miệng nhẹ nhàng nói: \"Vũ nhi, con hỏi nhiều như vậy làm gì, chẳng phải con đang rất vui sao? Không phải học nữa, con có thích trở về Vân Vụ sơn trang không?\n" +
            "Tần Vũ nhất thời mắt sáng lên như ngọc trong đêm, phấn chấn nói: \"A, con không phải học những quyển sách khô khan đó nữa sao? Về Vân Vụ sơn trang con thích ôn tuyền (suối nước nóng) ở đó, con còn thích ngắm sao, ngắm cảnh mặt trời mọc.ʺ\n" +
            "Tần Đức cười đáp: \"Tốt, tốt lắm Vũ nhi, con thích là tốt rồi, cha sẽ cho người đưa con về Vân Vụ sơn trang. Cả nghìn tinh binh ở đó đều do con sai bảo, nếu như con muốn gì thì có thể trực tiếp nói với Liên gia gia\"\n" +
            "\"Vâng, tuyệt quá, oa, Vân Vụ sơn trang là của con rồi, con có thể ngâm mình trong suối nước nóng cả ngày, sẽ tuyệt lắm đây.\" Tần Vũ hưng phần nói, sắc mặt hồng lên.\n" +
            "Trên mặt Tần Đức là một nụ cười hoàn toàn không phù hợp với hoàn cảnh, có điều Tần Vũ không thể phát hiện được.\n" +
            "\"Con thích là được rồi. Vũ nhi, trước tiên con phải ngủ một giấc đã, khi nào đến Vân Vụ sơn trang thì Liên gia gia sẽ gọi con dậy.\" Tần Đức cười nhẹ và xoa đầu Tần Vũ. \"Phụ vương tái kiến, Phong bá bá tái kiến.\" Tần Vũ vẫy hai tay, trực tiếp chạy thẳng về phòng mình.\n" +
            "Tần Đức nhìn Tần Vũ vào phòng rồi, sắc mặt bỗng trở nên nghiêm nghị rồi chuyển thân, hóa thành một đạo bóng mờ rồi biến mất trong hậu viện. Phong Ngọc Tử tựa như đã quen nên không hề tỏ ra ngạc nhiên.\n" +
            "Trong mật thất của vương phủ có ba người là Tần Đức, Phong Ngọc Tử và một hắc y thư sinh tay cầm chiết phiến. \"Vương gia, người thực sự đã quyết định rồi chứ?\" Hắc y thư sinh nhìn Tần Đức nghi hoặc hỏi. Tần Đức gật đầu đáp: \"Vũ nhi không thể trở thành người lãnh đạo, và cũng không thể trở thành cao thủ cấp tiên thiên, nó lại không hứng thú lĩnh hội tốt những gì được dậy dỗ. Đan điền quái dị của nó, ài, điều ta có thể làm cho nó có lẽ chỉ là cuộc sống khoảng mười năm vui vẻ yên bình, đợi chúng ta bắt đầu đầu kế hoạch cuối cùng, Vũ nhi nó sẽ không thể có những ngày yên ổn.\" Phong Ngọc Tử suy nghĩ hồi lâu rồi quyết định nói. \"Vương gia, kế hoạch này thực sự phải thực hiện sao, người phải biết rằng khi chúng ta thực hiện kế hoạch sẽ không thể biết được kết quả sẽ ra sao?\" Phong Ngọc Tử hỏi lại một lần nữa. Tần Đức thần sắc tức thời nghiêm túc, trong mắt hàn quang chớp động \"Ta không quản. Bất kể là vì tổ tiên Tần gia chúng ta hay là vì Tĩnh Di, kế hoạch này vẫn nhất định phải được thực hiện. Tĩnh Di lưu lại cho ta ba nhi tử, tuy nhiên Vũ nhi đan điền có vấn đề. Nhưng Phong nhi và Chính nhi một văn một võ, khả dĩ có thể thành đại sự. Từ Nguyên, đệ nhất \"ám kì\" đã bắt đầu triển khai chưa?\" Hắc y thư sinh Từ Nguyên hạ phe phẩy quạt nói: \"Vương gia yên tâm, mọi việc nhất thiết đều trong tầm kiểm soát.\" \"Tốt, rất tốt.\" Tần Đức trong mắt phát xuất một tia sát khí kinh nhân. Trấn Đông vương Tần Đức ở tại Tiềm Long đại lục. Tiềm Long đại lục diện tích rất lớn, cho đến giờ vẫn chưa ai có thể hiểu hết được. Phía đông của Tiềm Long đại lục là Hồng Hoang Vô Biên, trong vùng hồng hoang là núi non trùng điệp, cây cối dầy đặc, trong đó có vô số yêu thú. Càng đi sâu vào trong thì yêu thú càng lợi hại, đó là nguyên nhân khiến thượng tiên trên Tiềm Long đại lục không thể thăm dò toàn bộ vùng Hồng Hoang Vô Biên. Phía tây của Hồng Hoang Vô Biên có ba quốc gia lớn. Sở vương triều, Minh vương triều, Hán vương triều ba đại vương triều nhân khẩu tổng cộng gần trăm ức (1 ức=100,000), diện tích rộng lớn khiến người ta phải kinh hãi. Trong ba vương triều thì Sở vương triều là cường đại nhất, trong Sở vương triều có một gia tộc tách riêng độc lập là Tần gia. Tần gia chiếm cứ ba quận đông vực trong mười hai quận của Sở vương triều. Tại ba quận đông vực gần Hồng Hoang Vô Biên. Tần gia truyền qua hơn trăm năm tại ba quận đông vực căn cơ vô cùng thâm hậu, cho dù là hoàng đế của Sở vương triều đích thân đối phó thì cũng thập phần gian nan bởi vì Tần gia có một binh chủng đặc thù là Liệt Hổ quân.\n" +
            "Liệt hổ toàn thân xích hồng, thân hình to lớn, chính thị lão hổ. Phương pháp nuôi dưỡng liệt hổ trên quy mô lớn chính là điều cơ mật trọng yếu hạng nhất của Tần gia. Tần gia nắm trong tay sáu mươi vạn đại quân, trong đó có năm vạn Liệt Hổ quân, mỗi chiến sĩ trong Liệt Hổ quân đều cưỡi liệt hổ khi ra trận. Liệt hổ có lực công kích kinh thế hãi nhân, thêm vào chiến sĩ phía trên phối hợp có thể quét sạch mọi chướng ngại vật.\n" +
            "Duy chỉ năm vạn liệt hổ là có thể sử dụng hổ hống, khả nă ng này có thể triệt hạ hoàn toàn sĩ khí quân địch. Năm vạn liệt hổ quân có thể tiêu diệt hơn mười vạn đại quân kị binh phổ thông.\n" +
            "Tiềm Long đại lục vũ lực cực cao, ba quốc gia lớn đều có các tu tiên giả trấn quốc. Mỗi tu tiên giả tồn tại trong mắt phàm nhân đều tựa như thần tiên. Phi kiếm xuất ra có thể lấy đầu người ngoài trăm ngàn dặm, ngự kiếm phi hành bay lên đến tận chín tầng trời, chẳng phải là khả năng của thần tiên sao?\n" +
            "Vân Vụ sơn trang ngự tại Đông Lam sơn. Đông Lam sơn cao hơn ba nghìn thước, là một ngọn núi rất cao.\n" +
            "Hai năm sau. Lúc này Tần Vũ đã tám tuổi và cũng cao lên nhiều, trong mắt hiện lên vẻ trí tuệ tuy nhiên sâu trong đó lại ẩn chứa chút u buồn. Tần Vũ đang một mình đi trên sơn đạo, trên vai là một con ưng đen. \"Tiểu Hắc, đã qua hai năm rồi nhỉ, suốt hai năm phụ vương chỉ ghé qua thăm ta đúng một lần.\" Tần Vũ cắn hai môi, quay sang hắc ưng nói.\n" +
            "Con ưng nhỏ này một năm trước Tần Vũ du lãm Đông Lam sơn đã phát hiện ra, tiện thể bên thân có ưng đái nên kết bạn với nó. Tần Vũ thực sự rất cô độc. Sáu tuổi trở về trước còn có phụ thân bầu bạn, hai năm gần đây kể từ khi sáu tuổi chỉ nhìn thấy phụ thân đúng một lần.\n" +
            "Hắc ưng vỗ cánh, lông vũ bay vào mặt Tần Vũ khiến nó nhất thời nở một nụ cười.\n" +
            "Đi được một đoạn Tần Vũ đột nhiên nhìn thấy phía trước có một dựng phụ (phụ nữ có mang) gánh một gánh củi đang khó khăn đi tới, liền quay sang hắc ưng nói: \"Tiểu Hắc, chúng ta tới giúp a di kia nhé?\"\n" +
            "Hắc ưng tức thì vỗ cánh, rời khỏi vai Tần Vũ. Tần Vũ nhanh chóng chạy về phía dựng phụ nọ.\n" +
            "\"A di, a di để cháu gánh củi giúp cho.\" Tần Vũ hướng về phía phụ nhân nọ nói.\n" +
            "Phụ nhân nghe thấy thanh âm bèn nhìn lại bó củi trên vai, đưa tay áo lên lau mồ hồi rồi nhìn sang tiểu hài đồng Tần Vũ, cười nói: \"Tiểu oa nhi, cảm ơn cháu, ai di có thể mang được, chỉ còn một dặm nữa là đến tiểu thôn rồi\" nói rồi xốc lại bó củi trên vai rồi tiếp tục đi tới.\n" +
            "\"Tiểu oa nhi? Cháu không còn nhỏ nữa, cháu đã tám tuổi rồi, bó củi đó cháu có thể mang được.\" Tần Vũ nhìn sang dựng phụ, đột nhiên giành lầy bó củi rồi vác lên vai.\n" +
            "Bó củi đối với người bình thường thì không nặng lắm, nhưng với một hài tử mới tám tuổi thì đúng là rất nặng. Chỉ là Tần Vũ tại Vân Vụ sơn trang thường ngâm mình trong suối nước nóng nên thân thể cường tráng không giống như những đứa trẻ tám tuổi khác, ngang nhiên vác bó củi trên vai.\n" +
            "\"A di nhìn xem, cháu có thể mang được đúng không? Hà, a di không được gọi cháu là tiểu oa nhi nữa nhé.\" Tần Vũ đắc ý nói, không kể trên mặt mình có dính một vết nhọ.\n" +
            "Phụ nhân nọ cười nói: \"Khí lực quả không nhỏ, bất quá còn một dặm nữa, oa nhi cháu sẽ không chịu được đâu, thôi nhường lại để a di còn đi tiếp.\"\n" +
            "\"Ai nói cháu không thể chịu đến cùng.\"\n" +
            "Tần Vũ nhìn dựng phụ, hất tay một cái rồi nhanh chóng tiến về phía trước. Đang đi bỗng nhiên quay đầu lại nói: « Adi, cháu đã lên Đông Lam sơn nhiều lần rồi, được biết là ngoài một tiểu thôn trang ra thì không có nơi nào khác, chắc chắn là nơi đó đúng không. Nhanh lên, nhanh lên nào, a di đừng để cháu phải chờ đó!\"\n" +
            "Phụ nhân nọ bật cười: \"Hài tử này, không biết là con nhà ai, có đứa con thế này cha mẹ nó hẳn phải hạnh phúc lắm.\"\n" +
            "Tần Vũ mang bó củi trên vai bắt đầu cảm thấy khó khăn. Sau khi đi được một đoạn đường nó cảm thấy hai chân như nhũn ra. Có thể thượng sơn, sau lưng lại mang một bó củi thì thân thể Tần Vũ quả thật cường tráng. Bất quá nó mới chỉ là đứa trẻ tám tuổi. Một lúc sau, hai chân của Tần Vũ đột nhiên khịu xuống. \"Oa nhi…\"phụ nhân kêu thất thanh.\n" +
            "\"Cháu không sao đâu, chuyện này bình thường thôi.\" Tần Vũ quay đầu lại cười nói, trong ngữ khí phảng phất như là một đại lực sĩ. Nhưng sơn đạo gồ ghề, Tần Vũ lại va phải một hòn đá, không trụ được nên ngã xuống. \"Rầm!\" Tần Vũ toàn thân đập xuống đất\n" +
            "Dựng phụ tại vội vàng đi tới, nhặt những phiến gỗ lên và giúp Tần Vũ đứng dậy. Tần Vũ mồ hôi nhễ nhại, trên mặt đầy đất.\n" +
            "Tần Vũ buồn phiền nhìn phụ nhân nói: \"Adi, kỳ thật…cháu có thể mang được, chỉ là vấp phải hòn đá nên mới ngã.\"\n" +
            "\"Cháu giỏi lắm, a di biết là cháu có thể mang được, nhưng thôn trang đã ở phía trước rồi, cám ơn cháu.\"\n" +
            "Phụ nhân thu lại bó củi nhìn thấy Tần Vũ mặt dính bẩn bèn lau mặt cho nó, kiểm tra kĩ càng không thấy nó bị thương bèn bắt nó phải hứa sẽ về ngay nhà. Thấy Tần Vũ gật đầu đáp ứng mới quay về thôn trang.\n" +
            "Tần Vũ nhìn thôn trang còn cách hơn trăm bộ về phía trái, lắc đầu nói: \"Tiểu Hắc, chúng ta phải tìm đường khác thôi\" rồi cười nói: \"A di đã nghỉ ngơi được một lát, chắc đã có thể về làng được rồi.\"\n" +
            "Tần Vũ nở một nụ cười, trong lòng rất vui vẻ.\n" +
            "Từ một nơi bí mật gần đó, ba bóng nhân ảnh nhìn nhau. Họ chính là ba cao thủ ngầm đi theo để bảo hộ Tần Vũ. Tần Vũ chính là nhi tử của Trấn Đông vương, đường đường tam điện hạ. Làm sao có thể để nó đi một mình trên núi thế này được?\n" +
            "\"Tam điện hạ chỉ là một hài tử, tâm tư lương thiện, sao vương gia lại để tam điện hạ một mình tại Vân Vụ sơn trang nhỉ. Đã hai năm trôi qua rồi, mỗi lần nhìn bóng dáng tam điện hạ ngồi cô độc trong gió lạnh ban đêm lòng ta lại cảm thấy khó chịu.\" Một nhân ảnh thở dài nói.\n" +
            "Một nhân ảnh khác gật đầu tiếp: \"Mỗi lần tam điện hạ nhìn lên bầu trời đêm, thần tình đó khiến tim ta đau nhói, vương gia…ài!\"\n" +
            "\"Tóm lại, chắc vương gia có việc cần làm chúng ta không thể hiểu được. Việc chúng ta cần làm là phải tập trung bảo vệ tam điện hạ.\"\n" +
            "Đột nhiên…Tại sơn đạo xuất hiện một đại hán hung mãnh phi thường, nhãn thần sắc như dao cưỡi trên xích hồng sắc lão hổ phóng tới. Vừa nhìn thấy Tần Vũ từ xa đã cao giọng nói: \"Tam điện hạ, đại điện hạ và nhị điện hạ tới.\"\n" +
            "\"Đại ca và nhị ca đã tới!\"\n" +
            "Tần Vũ hai mắt hưng phấn, lập tức chạy tới chỗ đại hán, trèo lên trên lưng hổ cấp thiết thúc giục: \"Vương thúc, nhanh lên, chạy nhanh lên về Vân Vụ sơn trang nào.\"\n" +
            "Đại hán nọ giữ lấy Tần Vũ, sau đó điều khiển liệt hổ cấp tốc hạ sơn, để lại sau lưng một đám bụi mù mịt." +
            "\n" +
            "Vân Vụ sơn trang tọa lạc tại Đông Lam sơn. Bên ngoài luôn có một đội dũng sĩ dũng mãnh ngày đêm bảo hộ sơn trang nhưng những cao thủ ẩn mặt bên trong thì ngoại nhân căn bản không thể biết được. Hơn nữa Vân Vụ sơn trang là sơn trang của Trấn Đông vương, chỉ có ai chán sống mới có ý định xâm phạm.\n" +
            "Tại đại môn của Vân Vụ sơn trang có hai đại hán dũng mãnh như sư tử, toàn thân mặc hắc sắc chiến giáp đứng tại lối vào. Ánh mắt họ loang loáng lướt qua xung quanh hiện lên vẻ ngạo khí. Trên thân thể họ tự nhiên phát tán sát khí, quả đúng là thứ sát khí chân chính của những chiến sĩ tài năng đã kinh qua huyết chiến nơi sa trường hun đúc mà thành.\n" +
            "\"Tam điện hạ!\" Hai hắc giáp chiến sĩ đột nhiên quỳ xuống cung kính nói.\n" +
            "Tần Vũ vừa từ trên lưng hổ hạ xuống, hắc ưng đậu trên vai. Tần Vũ thời khắc đó rất hưng phấn và cao hứng liền nhanh chóng chạy vào trong đại môn đồng thời quay sang hai vị chiến sĩ cười hi hi nói: \"Hai vị thúc thúc, nhanh đứng lên nào.\"\n" +
            "Hai hắc giáp chiến sĩ đứng dậy, nhìn bóng thân ảnh nhỏ bé của Tần Vũ chạy vào trong trang viện trong mắt hiện lên một tia quan ái.\n" +
            "\"Hi hi, ta chắc chắn là đại ca và nhị ca đang ngâm mình ở ôn tuyền.\"\n" +
            "Tần Vũ căn bản không cần nghĩ nhiều, trực tiếp nhắm ôn truyền ở Tây uyển của Vân Vụ sơn trang chạy tới, miệng lẩm bẩm: \"Hà hà, hai vị ca ca tới Vân Vụ sơn trang, chưa được sự đồng ý của gia chủ đã tự động tiến nhập ôn tuyền…\"\n" +
            "Lát sau, Tần Vũ đã tới Tây uyển trong sơn trang.\n" +
            "Tần Vũ xoa hai tay, đột nhiên đưa tay phải lên chỉ thẳng vào hai bóng người ở trong ôn tuyền, ra giọng phẫn nộ nói: \"Các ngươi giỏi thật, chưa thèm hỏi ý kiến bổn trang chủ đã tự động tiến nhập ôn truyền trọng địa, a…\"\n" +
            "Tần Vũ đang cao hứng nói đột nhiên bị một cánh tay kéo xuống, đồng thời thân hình bất ổn chúi thẳng vào ôn tuyền.\n" +
            "\"Đệ chưa cởi y phục đâu, a!\" Tần Vũ hét lên thất thanh, chỉ thấy \"ầm\" một tiếng đã ngã vào ôn tuyền làm cho nước bắn lên tung tóe. Hắc ưng trên vai Tần Vũ hoảng loạn vỗ cánh bay lên cũng bị nước từ ôn tuyền bắn vào chút ít, suýt nữa thì từ hùng ưng biến thành một con gà mắc mưa.\n" +
            "\"Hắc hắc, Tần Vũ đệ không phải định làm cho hai vị đại ca, nhị ca chúng ta sợ chết khiếp đấy chứ, ta nghe mà cứ tưởng thật. Nhị ca và đại ca thì vất vả cả ngày còn Tần Vũ đệ thì suốt ngày vui vẻ ngâm mình trong ôn tuyền, hơn nữa lại là ôn tuyền của Vân Vụ sơn trang nữa cơ đấy!\" Một vị thiếu niên phẫn nộ đáp trả nhưng trong mắt lại ẩn chứa một tia vui vẻ.\n" +
            "\"Phì\" Tần Vũ phun ra một ngụm nước, toàn thân ướt đẫm tức giận nhìn sang thiếu niên.\n" +
            "\"Nhị ca, đệ biết đúng là huynh làm mà. Chỉ có huynh mới kéo đệ xuống nước, đại ca không đời nào làm như vậy cả.\"\n" +
            "Tần Vũ cởi bỏ y phục chỉ để lại một cái quần ngắn khi ngâm mình trong ôn tuyền, nhìn sang nhị ca Tần Chính.\n" +
            "\"Đệ nói đến đại ca hả? Ha ha, huynh ấy đang ngủ đó.\" Tần Chính cười ha hả nói.\n" +
            "\"Nhị đệ, đệ nghĩ rằng đại ca ta như lão trư, chỉ biết ăn và ngủ thôi phải không?\"\n" +
            "Bên cạnh ôn tuyền chỉ thấy một thiếu niên anh tuấn đang lười biếng mở mắt nhìn Tần Chính hỏi, đoạn quay sang Tần Vũ nói: \"Tiểu Vũ, ôn tuyền tại Vân Vụ sơn trang quả nhiên thần hiệu. Ngâm mình trong đó khiến huynh cảm thấy toàn thân thư thái, nếu đệ chịu khó ngâm mình trong đó hàng ngày thì toàn thân đệ cũng sẽ tráng kiện như huynh.\"\n" +
            "Thiếu niên đó chính là đại ca Tần Phong của Tần Vũ, niên kỉ là mười sáu nhưng vì tu luyện võ đạo nên phảng phất trông như thiếu niên đã mười tám tuổi. Đại ca Tần Phong là người mà Tần Vũ rất sùng bái, đã một lần nó tận mắt nhìn thấy đại ca một quyền xuất ra đã khiến một khối gỗ to lớn tan thành bụi phấn khiến Tần Vũ rất hâm mộ.\n" +
            "Nghe thấy đại ca nói rằng ôn tuyền thần hiệu, Tần Vũ tiến sâu hơn để nước ngập hơn ngực chỉ lộ đầu lên, đắc ý nói: \"Đúng vậy, ôn tuyền tại Vân Vụ sơn trang quả thật thần hiệu đúng như huynh nói vậy, hà không cảm ơn trang chủ là đệ đệ của huynh đi à!\" \"Tiểu tử này!\"\n" +
            "Đại ca Tần Phong và nhị ca Tần Chính đều mỉm cười.\n" +
            "Tần Vũ và hai vị thân sinh ca ca đã không gặp nhau một thời gian dài, từ khi tất cả đều chỉ mới là những đứa trẻ, bất quá Tần Phong và Tần Chính rất quý Tần Vũ. Đối với vị thân sinh đệ đệ này Tần Chính và Tần Phong thập phần sủng ái. Cùng cảnh không có mẫu thân, tự nhiên họ rất quan tâm đến đệ đệ. Đùa giỡn hồi lâu, Tần Vũ mới chịu ngồi yên trong lòng của ôn tuyền, Tần Phong và Tần Chính cũng ngồi xuống.\n" +
            "\"Phụ vương…\" Tần Phong tựa hồ như phát hiện bản thân đã lỡ lời, tức thì nói, \"kỳ thật không có gì cả, chỉ là quân đội tạm thời không có việc gì cả nên phụ vương đã cho phép huynh đến đây. Huynh giữa đường gặp nhị đệ nên đã đi cùng đệ ấy đến đây.\"\n" +
            "Tần Chính gật đầu quay sang Tần Vũ cười nói: \"Đệ chắc không biết lần này huynh về đây là có thời hạn, bất quá sau khi nghỉ ngơi cả nửa ngày trời đã đến lúc phải quay về.\"\n" +
            "\"Huynh cũng vậy, huynh phải đi cùng nhị đệ.\" Tần Phong hối lỗi nói.\n" +
            "\"Ôi, chỉ có nửa ngày thôi.\" Tần Vũ lên tiếng nói giọng điệu có phần thất vọng, vẻ hưng phấn hoàn toàn biến mất.\n" +
            "Tần Vũ có ba thân nhân chính là phụ thân và hai vị ca ca. Phụ thân thì bận rộn, hai năm nay chỉ đến thăm nó đúng một lần. Khó khăn lắm mới thấy mặt hai vị ca ca nhưng sau nửa ngày đã lại một thân một mình, có lẽ chỉ còn Tiểu Hắc trên vai làm bạn. Tần Phong và Tần Chính nhìn nhau, trong mắt hiện lên vẻ bất lực.\n" +
            "\"Đại ca, phụ vương phải đến Hồng Hoang Vô Biên chẳng phải là không dạy được huynh nhiều về cách điều binh?\" Tần Vũ đột nhiên cười đoạn tiếp tục hỏi: \"Đệ biết phụ vương điều binh vô cùng lợi hại, Liên gia gia thường kể với đệ.\"\n" +
            "\"Đúng vậy, phụ vương cầm quân đích thực rất lợi hại. Huynh đã theo phụ vương tiến hành quân kỳ diễn luyện cũng được dạy dỗ hơn nửa năm, tạm đáp ứng được yêu cầu của phụ thân.\"\n" +
            "Tần Phong tựa như đang hồi tưởng lại khi đó, bất giác nói: \"Phụ thân điều binh thật sự lợi hại phi thường!\" \"Đại ca!\"\n" +
            "Tần Chính nhìn vào mắt Tần Phong, Tần Phong đột nhiên hiểu ra, chỉ cười khổ biết bản thân mình đã lỡ lời.\n" +
            "Tần Vũ tựa hồ như không để ý đến những điều đó, trên thần sắc hưng phấn liên tục hỏi Tần Chính, Tần Phong về sự tình của họ thời gian đã qua. Ba huynh đệ trong ôn tuyền hàn huyên cho đến khi bóng tối buông xuống, đã đến lúc Tần Phong và Tần Chính phải ra về. Bên ngoài Vân Vụ sơn trang.\n" +
            "Tần Vũ mặc cẩm bào đen, nhìn sang Tần Phong và Tần Chính hai vị ca ca vẫy vẫy tay.\n" +
            "\"Đại ca nhị ca tái kiến.\" Trong mắt Tần Vũ tựa như sắp khóc.\n" +
            "Tần Phong và Tần Chính quay đầu lại cười với Tần Vũ. Hai người cưỡi liệt hổ, phía sau là trăm tinh binh khởi hành chỉ một lát sau là thân ảnh biến mất trên sơn đạo.\n" +
            "oOo\n" +
            "Dưới sơn đạo, Tần Phong và Tần Chính cưỡi liệt hổ song hành cùng nhau.\n" +
            "\"Đại ca, huynh cũng thấy đấy, Tiểu Vũ tâm tính không hợp với việc bày mưu tính kế và quyền mưu chi thuật, lại vì đan điền có vấn đề nên đã vô pháp tu luyện thành võ tướng. Như vậy, văn võ đều bất thành. Phụ vương lại tập trung hết tinh lực vào việc quân, Tiểu Vũ cả năm hiếm khi gặp phụ vương bản thân rất cô độc. Huynh nói phụ vương cùng huynh diễn luyện quân kỳ đến cả nửa năm, Tiểu Vũ sẽ cảm thụ thế nào.\" Tần Chính nhìn sang Tần Phong nói, thần sắc hiển nhiên rất không vui.\n" +
            "Tần Phong cười khổ nói: \"Nhị đệ, là huynh nhất thời không chú ý, bây giờ rất hối hận.\"\n" +
            "Thần sắc Tần Phong đột nhiên lạnh lùng nói: \"Nhị đệ, Tiểu Vũ thiên sinh đan điền đã có vấn đề, văn võ đều bất thành, không có khả năng tự bảo vệ bản thân. Chúng ta phải là người bảo hộ hảo Tiểu Vũ, tuyệt đối không để bất cứ kẻ nào khinh thường.\"\n" +
            "\"Bất cứ kẻ nào dám khinh thường Tiểu Vũ, đệ nhất định sẽ bắt kẻ đó phải trả một cái giá cực đắt!\" Trong mắt Tần Chính hiện lên một tia hàn quang.\n" +
            "Hai huynh đệ cùng với hộ vệ phía sau từ từ rời khỏi Đông Lam sơn, nhắm Viêm kinh thành thẳng tiến.\n" +
            "oOo\n" +
            "Đêm đã khuya, trên Đông Lam sơn.\n" +
            "Từng đợt hàn phong thổi tới, một bóng dáng nhỏ bé đứng đó, trên vai là một con hắc ưng. Tần Vũ ngắm nhìn những ngôi sao trên trời, trong mắt hiện lên vẻ thành thục so với lứa tuổi. Chỉ một mình đọc sách tại thư phòng, hoặc giả chỉ một mình lặng lẽ suy nghĩ, điều đó làm cho tư duy của Tần Vũ vượt xa một hài tử mới chỉ tám tuổi\n" +
            "\"Tiểu Hắc.\" Tần Vũ đột nhiên gọi nhưng mắt vẫn nhìn lên bầu trời đầy sao. Hắc ưng trên vai Tần Vũ động đậy, hai mắt chuyển động không hiểu tiểu chủ nhân gọi nó vì việc gì.\n" +
            "Trên mặt Tần Vũ đột nhiên hiện lên một nụ cười hạnh phúc: \"Tiểu Hắc ngươi có biết không, phụ vương thường bên cạnh ta, đối với ta thập phần quan ái. Sau khi mời mười hai vị lão sư tới, phụ vương đã để ta học tập với mười hai lão sư. Tuy ta không thích học những thứ đó nhưng bản thân vẫn nỗ lực tự học để có thể làm phụ vương vui lòng. Năm sáu tuổi ta đã biết đọc, phụ thân cũng gọi ta là thần đồng nhưng sau đó thì…\" Tần Vũ trầm mặc không nói tiếp.\n" +
            "\"Lúc sáu tuổi ta vẫn nhớ rõ, tại u tĩnh tiểu viện trong vương phủ bị mười hai lão sư đã nói rằng ta không thể trở thành người có địa vị lãnh đạo, sau đó Phong bá bá lại nói đan điền ta có vấn đề, không thể tích tụ nội lực nên không thể tu luyện võ công. Sau khi ta tới Vân Vụ sơn trang. Thì…Phụ vương không hề đến thăm, không quan tâm đến ta. Ta lúc đó vẫn không hiểu đan điền là gì, địa vị lãnh đạo là gì chỉ nghĩ là phụ vương cho ta tới đây để du ngoạn, nhưng…\"\n" +
            "Tần Vũ cắn hai môi, trong mắt hiện vẻ u buồn: \"Đã hai năm rồi, ta cũng đã có lần tò mò hỏi Vương thúc thúc đan điền và người có địa vị lãnh đạo là gì. Ta nghĩ ta cũng đã minh bạch được vì sao phụ thân không cho ta biết nguyên nhân.\"\n" +
            "Tần Vũ lại trầm mặc ngẩng đầu lên nhìn bầu trời đầy sao.\n" +
            "\"Ta thực sự không thích quyền mưu chi thuật trong sách. Thật ra ta đã cố ép bản thân mình học. Ta rất muốn nhìn thấy nụ cười trên mặt phụ vương, muốn phụ vương tự hào vì ta nhưng thực sự ta không đủ thâm độc để thực hiện những âm mưu trong sách…Ài, ta đã cố gắng ép bản thân học những thứ đó nhưng những gì mà ta cần biết là tâm kế mưu quyền thuật ta lại không thể đạt đuợc. Con không thể đạt được, phụ vương, con không thể đạt đuợc!\"\n" +
            "Tần Vũ khóc thầm, thân thể khẽ run lên. Bên cạnh Tiểu Hắc nhìn sang Tần Vũ, dùng đôi cánh của nó chạm vào mặt Tần Vũ.\n" +
            "Tần Vũ nhìn lên hắc ưng trên vai mình, ôm lấy hắc ưng và để nó trong lòng mình. Hắc ưng yên lặng ở trong lòng Tần Vũ, tựa hồ như hiểu được tâm tình của tiểu chủ nhân: \"Tiểu Hắc, ta thật sự rất muốn phụ vương khen ngợi, muốn nhìn thấy nụ cười trên mặt phụ vương, ta thực sự thực sự rất muốn…\"\n" +
            "Tần Vũ giọng ngày càng nhỏ dần.\n" +
            "oOo\n" +
            "Tại nơi bí mật, ba cao thủ đang âm thầm bảo hộ Tần Vũ trong lòng cũng cảm thấy ngậm ngùi.\n" +
            "Đột nhiên…\n" +
            "Một đạo tinh quang phá không gian nhất thời từ trong không trung xuất hiện, quang mang chói mắt. Lưu tinh mang ánh sáng siêu việt át hết tất cả các ngôi sao khác. \"Lưu tinh!\"\n" +
            "Tần Vũ hai mắt sáng lên, tức thì thả Tiểu Hắc khỏi lòng, nhanh chóng nhắm mắt hai tay chắp lại phía trước: \"Xin hãy để phụ vương quan tâm đến ta như người đối đãi với đại ca và nhị ca. Hãy đánh ta, trừng phạt ta đi ta không quản, ta sẵn sàng chấp nhận mọi giá.\" Tần Vũ chầm chậm mở mắt, nhìn lưu tinh lúc này đã tới nơi cuối chân trời.\n" +
            "\"Phụ vương năm đó đã nói, nếu khấn nguyện điều gì khi lưu tinh xuất hiện thì việc đó sẽ trở thành hiện thực. Phụ vương không khi nào lừa ta, nhất định việc đó sẽ trở thành hiện thực.\" Nhìn lên bầu trời đầy sao, nét mặt Tần Vũ hiện lên vẻ kiên định. Đột nhiên, trong lòng Tần Vũ lóe lên một ý nghĩ.\n" +
            "Tần Vũ trong mắt hiện lên tia phấn chấn, vỗ vỗ đầu mình nói: \"A, mình thật là ngốc quá, văn võ, văn võ, văn không thể thành công còn võ thì thế nào? Vương thúc đã nói trong thiên hạ tâm pháp nội công có vô số, chẳng lẽ không thể tìm được một loại phù hợp với đan điền của mình. Không cần phải nghĩ nữa, chẳng nhẽ luyện võ công nhất định phải luyện nội công?\"\n" +
            "Tần Vũ hoàn toàn mới chỉ là một hài tử mới tám tuổi nhưng vì chỉ có một thân một mình nên thường đọc sách, tâm trí thành thục hơn hẳn những đứa trẻ khác. Trong quá khứ Phong Ngọc Tử từng nói đan điền nó có vấn đề không thể tu luyện, khiến nó hình thành tư duy như vậy, thời khắc này đột nhiên tỉnh ngộ. Đan điền quái dị, thực sự không thể tu luyện võ công?\n" +
            "\"Ai dà, thời gian còn dài, chỉ cần ta nỗ lực giống như phụ vuơng từng nói thì chắc chắn sẽ thành công.\" Tần Vũ gật đầu tự đồng ý với những lời mình nói, trong mắt có một sự tự tin vô tả, thể hiện một sự quyết tâm vô cùng kiên định. \"Tiểu Hắc, chúng ta phải quay lại sơn trang!\" Tần Vũ nói, trong lòng có mục tiêu nên thực sự đã có thay đổi.\n" +
            "Hắc ưng đậu lên vai, Tần Vũ vô cùng cao hứng liên tục huýt sáo, vừa đi vừa nhún nhảy trên đường về Vân Vụ sơn trang. Lúc đó ba bóng nhân ảnh xuất hiện, biến thành ba bóng mờ nhắm hướng Tần Vũ đuổi theo." +
            "\n" +
            "\n" +
            "\"Là ai?\" Một hắc giáp chiến sĩ của Vân Vụ sơn trang lạnh giọng hỏi, người hắc giáp chiến sĩ còn lại mắt hướng về bóng người phía xa. Lúc hai hắc giáp chiến sĩ nhìn rõ người tới không ngờ là tam điện hạ Tần Vũ, trong lòng thất kinh vội vàng quỳ xuống cung kính chào \"Tam điện hạ!\"\n" +
            "Tần Vũ gật đầu, trên trán lấm tấm mồ hôi, hai mắt sáng lên, gương mặt hồng hào nói: \"Hai vị mau đứng dậy đi.\"\n" +
            "Nói xong cười với hai hắc giáp chiến sĩ rồi vội vã đi vào trong Vân Vụ sơn trang. Hai hắc giáp chiến sĩ nghi hoặc nhìn theo bóng Tần Vũ.\n" +
            "\"Tam điện hạ thượng sơn để ngắm sao trời, thường tới canh hai mới quay về, sao bây giờ đã về rồi nhỉ?\" Hắc giáp chiến sĩ bên trái nghi hoặc hỏi.\n" +
            "Hắc giáp chiến sĩ bên phải cũng mê hoặc gật đầu, hiển nhiên cũng không rõ nguyên nhân.\n" +
            "oOo\n" +
            "Liên Ngôn chính là người được Tần Vũ gọi là Liên gia gia. Liên Ngôn là một lão nhân ở Tần gia, đến như đương kim Trấn Đông Vương Tần Đức cũng do một tay ông ta nuôi nấng, Liên Ngôn tại Tần gia rất có ảnh hưởng. Hai năm trước, Tần Đức đã bảo Liên Ngôn tới Vân Vụ sơn trang để chiếu cố cho Tần Vũ. Tần Vũ như một cơn gió, trực tiếp nhằm thư phòng của Liên Ngôn tiến tới. Đến bên ngoài phòng liền lập tức đưa tay lên gõ cửa.\n" +
            "\"Cốc!\"\"Cốc!\"\"Cốc!\"\"Cốc!\"\"Cốc!\"…\n" +
            "\"Liên gia gia mau mở cửa, là Tiểu Vũ đây, con có điều khẩn yếu cần hỏi, gia gia mau mở cửa\" Tần Vũ cấp thiết gọi.\n" +
            "Một lát sau trong phòng phát ra ánh đèn: \"Tiểu Vũ đó à, gia gia vừa mới chợp mắt thì bị con đánh thức đó.\"\n" +
            "Một âm thanh thân thiết vang lên, cửa phòng đã mở. Một lão nhân hiền hòa khoảng lục tuần, trên người khoác áo mỏng xuất hiện trước mắt Tần Vũ.\n" +
            "\"Ai chà, Tiểu Vũ có chuyện gì vậy con? Sao con lại mồ hôi mồ kê nhễ nhại thế này?\" Liên Ngôn nhìn sang Tần Vũ.\n" +
            "Tần Vũ muốn nói gì đó, nhưng vì vừa gắng sức chạy đến đây nên giờ thở không ra hơi.\n" +
            "Liên Ngôn thấy vậy bèn nói: \"Lại đây, trước tiên vào phòng đã rồi nói tiếp.\"\n" +
            "Vừa nói vừa kéo Tần Vũ vào trong phòng. Hai người vào phòng bèn ngồi xuống ghế.\n" +
            "\"Không phải vội, có chuyện gì chờ cho bình tĩnh rồi hãy nói.\" Liên Ngôn nhìn sang Tần Vũ nói.\n" +
            "Tần Vũ hít vào một hơi thật sâu, sau đó quay sang Liên Ngôn, giọng nói thập phần kiên định: \"Liên gia gia, con phải tu luyện.\"\n" +
            "\"Tu luyện?\" Liên Ngôn hơi kinh ngạc, sau đó nở một nụ cười nói: \"Tiểu Vũ à, sao tự nhiên con lại nghĩ đến việc tu luyện?\"\n" +
            "Tần Vũ hơi khựng lại, sau đó hào hứng nói: \"Không có gì cả, chỉ là con nhìn các vị thúc thúc trong sơn trang ai cũng lợi hại cả, nên muốn tu luyện võ công. Liên gia gia, con có thể tu luyện võ công không?\"\n" +
            "Đối với khát vọng được phụ thân yêu quý vốn chôn vùi tại nơi sâu nhất trong tâm linh Tần Vũ tưởng chừng như đã bị vùi lấp trong tâm tưởng, về sau phải nỗ lực không ngừng, vì giờ đây đã có mục tiêu để phấn đấu.\n" +
            "\"Tiểu Vũ, con có biết võ công là gì không?\"Liên Ngôn không trả lời luôn mà chỉ hỏi lại.\n" +
            "Tần Vũ lắc đầu nói: \"Con chỉ biết là tu luyện võ công sẽ rất lợi hại, những thứ khác con không rõ lắm, hình như còn có cái gì gọi là nội công.\"\n" +
            "Là một hài tử mới tám tuổi, tuy đã đọc nhiều sách, nhưng bản thân nó vẫn có nhiều thứ không thể biết.\n" +
            "\"Vậy trước hết ta sẽ giảng lại tử tế cho con biết.\" Liên Ngôn cười nói.\n" +
            "Tần Vũ tức thì hai mắt sáng lên, nhìn chăm chú vào Liên Ngôn, tập trung tinh thần lắng nghe.\n" +
            "\"Trước tiên ta sẽ nói đến cao thủ. Cao thủ phân ra các cấp hậu thiên cao thủ, tiên thiên cao thủ…Hơn xa tiên thiên cao thủ chính là các thượng tiên.\" Liên Ngôn cười nói .\n" +
            "\"Ngày nay hậu thiên cao thủ tại Tiềm Long đại lục nhiều như lá rừng, không thể đếm hết được. Còn tiên thiên cao thủ tính riêng Sở Vương triều thôi đã có hơn trăm người.\"\n" +
            "\"Cả trăm người?\" Tần Vũ cả kinh, \"Sở Vương triều có hơn bốn triệu người, làm sao lại ít tiên thiên cao thủ được, chẳng nhẽ trong hàng nghìn hàng vạn người lại không có được một?\"\n" +
            "Liên Ngôn thở dài nói: \"Hậu thiên cao thủ nếu có phươn g pháp tu luyện đúng đắn cũng khả dĩ có thể đạt được nhưng để trở thành cấp tiên thiên cao thủ thì còn nhiều gian nan lắm. Để trở thành tiên thiên cao thủ thì phải đạt được hai yêu cầu: Thứ nhất, phải đạt đến cảnh giới viên mãn của hậu thiên. Thứ hai, phải có những cảm ngộ về tự nhiên thiên đạo.\"\n" +
            "Tần Vũ nhất thời nghi hoặc nói: \"Tự nhiên thiên đạo là cái gì vậy gia gia?\"\n" +
            "Liên Ngôn liền cười xòa: \"Tự nhiên thiên đạo chẳng là gì cả, nhưng mỗi người đều phải tự bản thân lãnh ngộ, không thể nói bằng lời. Có người đạt đến cảnh giới viên mãn của hậu thiên chỉ trong vòng mười năm nhưng vì vô pháp cảm ngộ không thể đột phá được bước cuối cùng nên tựu chung không thể trở thành tiên thiên cao thủ được. Một khi đã trở thành tiên thiên cao thủ, thọ mệnh có thể là năm trăm năm.\"\n" +
            "\"Năm trăm năm cơ ạ!\" Tần Vũ há hốc mồm kinh ngạc.\n" +
            "Liên Ngôn nhìn thấy biểu tình khả ái đó lại cười nói: \"Muốn trở thành tiên thiên cao thủ quả thập phần gian nan bởi vì khi trở thành tiên thiên cao thủ tự nhiên có thể sống lâu, thọ mệnh đến ngũ bách tuế. Tiên thiên cao thủ tu luyện tiên thiên chân khí bản chất khác hẳn với hậu thiên cao thủ, là hai đẳng cấp khác nhau hoàn toàn.\"\n" +
            "\"A! Liên gia gia, phía trên tiên thiên cao thủ chẳng phải là còn thượng tiên sao, họ rất lợi hại đúng không?\" Tần Vũ hai mắt sáng lên.\n" +
            "Tiên thiên cao thủ đã lợi hại như vậy, thượng tiên làm sao kém được?\n" +
            "\"Thượng tiên có thể dễ dàng mà thành sao?\" Liên Ngôn thở dài nói, \"thượng tiên đến hoàng đế gặp phải còn phải hành lễ gọi thượng tiên vô cùng kính trọng vì dù là hoàng đế nhưng họ vẫn có thể bị thượng tiên lấy mạng. Thượng tiên có thể ngự kiếm phi hành cao đến chín tầng trời, căn bản không phải là phàm nhân nữa!\"\n" +
            "\"Cao đến chín tầng trời?\"\n" +
            "Trong lòng Tần Vũ tự nhiên xuất hiện một bức tranh mình chân đạp phi kiếm bay cao đến chín tầng trời. Sự sảng khoái đó không thể mô tả được nhưng trong lòng tiểu Tần Vũ đang liên tưởng rằng mình có thể trở thành thượng tiên.\n" +
            "\"Cả Sở Vương triều có gần trăm tiên thiên cao thủ, có điều…cả trăm năm nay Sở Vương triều không xuất hiện được một thượng tiên. Hiện tại Sở vương triều có không quá ba vị thượng tiên. Trong ba đại thượng tiên thì có hai vị đã trở thành thượng tiên từ hơn ba trăm năm trước, ba trăm trở lại đây trở thành thượng tiên thì có Phong bá bá của con.\"\n" +
            "\"Phong bá bá?\" Tần Vũ nhớ lại Phong bá bá thân vận bạch y, thường cưỡi hạc. Phong bá bá chính là thượng tiên?\n" +
            "Liên Ngôn tiếp tục nói: \"Bất quá muốn trở thành thượng tiên thì tốt nhất là nên tới Hải Ngoại tiên đảo bái sư học nghệ. Hải Ngoại tiên đảo trừ thượng tiên của các nước, ai biết được là ở đâu? Những người bình thường nếu gặp mặt thượng tiên, họ có tư cách để hỏi lộ tuyến đến Hải Ngoại tiên đảo chăng?\"\n" +
            "\"Dù cho biết được, thì Hải Ngoại tiên đảo ở rất xa Tiềm Long đại lục, mỗi năm Tiềm Long đại lục có cả vạn người tìm đường ra Hải Ngoại tiên đảo mong bái sư học nghệ. Nhưng rời khỏi đất liền ra đại hải tất nhiên ẩn chứa rất nhiều nguy cơ, nghìn người tài năng ra đi thì chỉ có một người có thể sống sót đến được Hải Ngoại tiên đảo.\" Liên Ngôn cảm thán nói.\n" +
            "Tần Vũ tức thì hai mắt sáng lên hỏi: \"Liên gia gia, một năm có hơn mười người đến được Hải Ngoại tiên đảo, tại sao Tiềm Long đại lục lại có ít thượng tiên vậy?\"\n" +
            "Theo như lí giải của Tần Vũ, một năm có mười thượng tiên tại sao Tiềm Long đại lục lại không nhiều thượng tiên?\n" +
            "Toàn bộ Tiềm Long đại lục số thượng tiên đích thực rất nhỏ, trăm năm ngàn năm qua cộng lại chỉ có mười vị.\n" +
            "\"Cứ đến được Hải Ngoại tiên đảo là có thể trở thành thượng tiên chăng?\" Liên Ngôn lắc đầu nói, \"thượng tiên rất đặc biệt, đâu phải ai ai cũng có khả năng tu luyện thành, phải tu luyện đúng phương pháp. Cả ngàn người may ra mới có một người có tư chất tu luyện.\"\n" +
            "\"A, không phải vậy chứ. Những người tới Hải Ngoại tiên đảo một năm chỉ có mười người, cả trăm năm mới có thể tu luyện thành thượng tiên?\" Tần Vũ nhất thời cảm khái với sự khó khăn khi tu luyện thành thượng tiên.\n" +
            "Liên Ngôn đột nhiên đứng đậy, nhìn ra ngoài song cửa sổ.\n" +
            "\"Thượng tiên? Đó chỉ là một danh tự thôi. Tại đại lục có vô số cao thủ phong cuồng, vô số cao thủ muốn trở thành thượng tiên. Phi kiếm xuất ra sát nhân ngoài ngàn dặm chẳng phải là thần thông sao?\"\n" +
            "Liên Ngôn trong mắt có một tia khát vọng, nhưng sau đó lại cảm thán nói: \"Như phụ vương của con, thời khắc quan trọng cần có thượng tiên tương trợ. Nếu như quả thật thượng tiên tương trợ phụ vương con thì mục tiêu của phụ vương con có thể thực hiện.\"\n" +
            "Tim Tần Vũ đột nhiên đập mạnh.\n" +
            "\"Mục tiêu của phụ vương?\"\n" +
            "Đồng thời một cỗ khí ấm áp lưu chuyển toàn thân, khiến Tần Vũ lập tức cảm thấy toàn thân sung mãn liền nói:\n" +
            "\"Nếu như con tu luyện có thể trở thành thượng tiên chắc chắn rằng phụ vương sẽ rất cao hứng. Lúc đó con có thể tương trợ phụ vương.\"\n" +
            "Tưởng tượng rằng mình trở thành thượng tiên, bản thân có thể tương trợ phụ vương vương thì sẽ được phụ vương coi trọng, khát vọng được phụ thân yêu mến biến thành ngọn lửa trong tâm của Tần Vũ. \"Vì phụ vương, ta nhất định sẽ trở thành thượng tiên.\" Tần Vũ cắn chặt môi, trong mắt hiện lên tia kiên định.','https://img.anime47.com/imgur/Hqop5CL.jpg',1)";
    private String SQLQuery10 = "INSERT INTO truyen VALUES (null,'PHÀM NHÂN TU TIÊN','Chương 1: Sơn biên tiểu thôn\n" +
            "\n" +
            "\n" +
            "\"Anh ngố\" trợn trừng hai mắt, nhìn chằm chằm vào nóc nhà được tạo thành từ cỏ dại và bùn trộn lẫn. Toàn thân hắn được trùm bởi một cái áo bông đã cũ, ố vàng, nhìn không còn ra hình dạng ban đâu, phảng phất tán phát ra một ít mùi ẩm mốc.\n" +
            "\n" +
            "Bên cạnh hắn còn có một người nữa, là nhị ca Hàn Chú, đang ngủ rất say sưa. Thỉnh thoảng có tiếng ngáy nhè nhẹ phát ra từ đó.\n" +
            "\n" +
            "Cách giường chừng nửa trượng, là một vách tường đất đổ nát, vì thời gian đã quá lâu, trên vách tường đã xuất hiện vài vết nứt dài. Từ những vết nứt đó, loáng thoáng truyền đến thanh âm oán thán của Hàn mẫu, ngoài ra còn có thanh âm Hàn phụ đang hút thuốc rất là hấp dẫn.\n" +
            "\n" +
            "'' từ từ nhắm đôi mắt có chút bức bối lại. Muốn thật nhanh chìm vào giấc ngủ sâu. Trong lòng hắn biết rõ ràng, nếu bây giờ mà còn không ngủ ngay, ngày mai không thể nào dậy sớm được, cũng không thể cùng đám bạn cùng đi đốn củi được.\n" +
            "\n" +
            "\"Anh ngố\" họ Hàn tên Lập, loại danh tự có ý nghĩa như thế này cha mẹ hắn không có khả năng đưa ra. Cái này là do phụ thân hắn dùng rượu oa đầu chế bởi thô lương, cầu lão Trương trong thôn đặt cho.\n" +
            "\n" +
            "Lão Trương khi còn trẻ, đã từng làm thư đồng mấy năm cho một nhà có tiền trong thành. Là người duy nhất trong thôn nhận biết được vài chữ. Tên gọi của hầu hết tiểu hài tử trong thôn, đều là do lão Trương đặt cho.\n" +
            "\n" +
            "Hàn Lập bị người trong thôn gọi là \"Anh ngố\" không phải là do hắn ngố hay đần thật sự, ngược lại, hắn còn là đứa trẻ thông minh nhất làng, ngoài ra trông hắn so với những đứa trẻ khác trong làng không có gì khác biệt. Trừ những người trong nhà ra, hắn rất ít khi nghe thấy nguời ta gọi tên chính thức Hàn Lập của hắn, mà hầu như chỉ là \"Anh ngố\", và cái tên \"Anh ngố\" này vẫn được sử dụng cho đến tận bây giờ.\n" +
            "\n" +
            "Sở dĩ Hàn Lập bị mọi người ban cho hỗn danh \"anh ngố\" là vì trong thôn vốn đã có một \"anh ngốc\" rồi.\n" +
            "\n" +
            "Điều này cũng không có gì to tát cả, tất cả những đứa trẻ khác trong thôn đều có hỗn danh như \"cẩu oa\" hay \"nhị đản\", so với danh tự \"anh ngố\" thì còn khó nghe hơn.\n" +
            "\n" +
            "Cũng bởi vậy, Hàn Lập mặc dù không thích cách xưng hô này nhưng cũng chỉ có thể tự an ủi mình mà thôi.\n" +
            "\n" +
            "Hàn Lập bề ngoài trông không được vừa mắt, da tay thì đen đúa, đích thực là một đứa trẻ bình thường chốn làng quê. Tuy nhiên, nội tâm của cậu bé thì không hề nông nổi, so với những đứa bé cùng lứa tuổi thì chín chắn hơn nhiều. Hắn từ nhỏ đã hướng tới thế giới phồn hoa bên ngoài, mơ rằng có một ngày, hắn có thể ra khỏi thôn làng, đi xem xem cái thế giới phù hoa mà lão Trương thường nói đến.\n" +
            "\n" +
            "Khi Hàn Lập nghĩ đến ý tưởng này, hắn không dám đề cập ra cho người khác biết. Nếu không, nhất định làm cho mọi người trong thôn cảm thấy ngạc nhiên, một tiểu hài tử miệng còn chưa khô mùi sữa, thế mà dám mơ tưởng đến những ý nghĩ xa vời mà ngay cả một người lớn cũng chưa dám nghĩ đến. Cần phải biết rằng, những đưa trẻ khác cùng tuổi với Hàn Lập thì tầm tuổi này chỉ biết đuổi gà, bắt chó, tất nhiên là ở đây sẽ không nói đến những kẻ có ý nghĩ tha huơng cầu thực.\n" +
            "\n" +
            "Gia đình Hàn Lập có bảy miệng ăn, trên hắn có hai vị huynh trưởng, một tỷ tỷ, hắn trong nhà đứng thứ tư, ngoài ra hắn còn có một tiểu muội muội nữa. Năm nay hắn vừa mới mười tuổi, gia cảnh bần hàn, cả năm cũng không có mấy bữa được ăn no. Mọi người trong nhà đều chỉ mong được ăn đủ no, mặc đủ ấm.\n" +
            "\n" +
            "Hàn Lập lúc này, đang mơ mơ màng màng, tuy ngủ mà chưa ngủ, trong đầu vẫn còn phảng phất ý niệm: Ngày mai lên núi, nhất định sẽ mang về cho tiểu muội muội mà hắn yêu thương nhất thật nhiều hồng tương quả*, loại quả mà muội muội hắn thích nhất.\n" +
            "\n" +
            "Vào giữa trưa ngày thứ hai, Hàn Lập dưới ánh nắng chói trang, lưng gùi bó củi cao bằng nửa người hắn, trước ngực thì ôm một nắm đầy hồng tương quả, đang từ ngọn núi trở về nhà. Lúc này, hắn không hề biết rằng trong nhà đang có một vị khách đến chơi, mà vị khách này, chính là người cải biến vận mệnh của hắn.\n" +
            "\n" +
            "Vị quí khách này, cùng hắn có mối quan hệ huyết thống rất gần, ông ta chính là tam thúc ruột của hắn.\n" +
            "\n" +
            "Nghe nói, trong vùng, tại tửu lâu ở tiểu thành phụ cận, được nguời ta tín nhiệm đề bạt làm đại chưởng quĩ, chính là người mà cha mẹ hắn thường nói. Hàn gia trong vòng trăm năm trở lại đây, mới lại có thể xuất hiện một người như tam thúc của Hàn Lập.\n" +
            "\n" +
            "Hàn Lập từ nhỏ cho đến giờ, gặp mặt vị tam thúc này cũng chỉ vài lần. Đại ca của hắn được đi theo một lão thợ rèn trong thành để học việc cũng là do vị tam thúc này giới thiệu cho. Vị tam thúc này còn thường xuyên giấu mọi người cấp cho cha mẹ hắn đồ ăn thức uống, chiếu cố tận tình gia đình hắn. Cũng chính vì vậy, ấn tượng của Hàn Lập đối với vị tam thúc này rất là tốt, hắn cũng biết rằng tuy cha mẹ hắn không nói ra miệng nhưng trong tâm cũng rất cảm kích.\n" +
            "\n" +
            "Đại ca hắn chính là niềm kiêu hãnh của cả nhà, nghe nói làm thợ rèn học đồ, không kể ăn ở, mỗi tháng còn nhận được ba mươi đồng bạc trắng, đợi đến lúc xuất sư, có người thuê thì tiền kiếm được còn nhiều hơn nữa.\n" +
            "\n" +
            "Mỗi khi cha mẹ đề cập đến đại ca, thần thái đều bay bổng, trông khác hẳn so với thường ngày. Hàn Lập tuổi tuy nhỏ, nhưng cũng hâm mộ không thôi, công việc vừa lòng sớm đã có rồi, đó chính là theo một vị thủ nghệ sư phó trong tiểu thành học tập nấu ăn, sau đó sẽ trở thành một người nấu ăn có tay nghề.\n" +
            "\n" +
            "Ngay khi Hàn Lập nhìn thấy một người toàn thân diện y phục mới, khuôn mặt béo tròn, thì biết ngay đó là tam thúc của mình, tâm lý vô cùng hưng phấn.\n" +
            "\n" +
            "Bỏ lại đám củi ra sau nhà xong, liền tiến lên nhà làm lễ tham kiến tam thúc, ngoan ngoãn cất tiếng chào: \"tam thúc hảo\", rồi sau đó đứng yên một bên, nghe phụ mẫu và tam thúc trò chuyện phiếm.\n" +
            "\n" +
            "Tam thúc cười cười nhìn Hàn Lập, đánh giá hắn một hồi, luôn miệng khen hắn những lời như là \"nghe lời\" với \"hiểu việc\", sau đó lại quay đầu lại, tiếp tục trò chuyện với phụ mẫu hắn về mục đích chuyến đi lần này của lão.\n" +
            "\n" +
            "Hàn Lập tuổi còn chưa lớn hẳn, nên khi nghe tam thúc nói hắn cũng không hiểu hết, chỉ là hiểu được đại khái mà thôi.\n" +
            "\n" +
            "Nguyên lai là tam thúc của hắn làm việc ở một tiểu lâu, mà tiểu lâu này lại thuộc về một bang phái giang hồ có tên là \"Thất huyền môn\". Môn phái này chia ra làm ngoại môn và nội môn. Cách đây không lâu, tam thúc của hắn cũng đã chính thức trở thành đệ tử ngoại môn của môn phái đó, và có thể đứng ra đề cử hài đồng nhỏ tuổi ( từ bảy đến mười hai tuổi) tham gia khảo nghiệm chiêu thu đệ tử của Thất huyền môn.\n" +
            "\n" +
            "Cứ năm năm một lần, Thất huyền môn lại tổ chức kỳ thi chiêu lãm đệ tử, mà cuộc thi này sẽ được tổ chức trong tháng tới. Với một người không khéo, nhanh nhạy lại không có con cái, tự nhiên phải nghĩ đến đứa cháu Hàn Lập có độ tuổi thích hợp rồi.\n" +
            "\n" +
            "Cha của Hàn Lập vốn thận trọng, nghe đến những từ như \"giang hồ\" \"môn phái\", trong lòng có chút do dự, không đưa ra được chủ ý, liền vớ ngay lấy điếu cày, rít lên mấy tiếng \"ba tháp\" \"ba tháp\", sau đó ngồi yên tại chỗ, không nói câu gì nữa.\n" +
            "\n" +
            "Theo lời tam thúc nói, thì trong phương viên mấy trăm dặm, Thất huyền môn là môn phái xếp thứ nhất, thứ hai gì đó.\n" +
            "\n" +
            "Chỉ cần trở thành đệ tử nội môn, chẳng những sau này, vừa miễn phí tập võ, vừa không phải lo lắng chuyện ăn uống, mà mỗi tháng còn kiếm được một hai lượng bạc lẻ nữa. Hơn nữa cho dù không trúng tuyển trở thành đệ tử nội môn, thì cũng có hi vọng trở thành đệ tử ngoại môn giống như tam thúc của hắn, chuyên lo việc làm sinh ý cho Thất huyền môn.\n" +
            "\n" +
            "Nghe đến có khả năng mỗi tháng kiếm được một hai lượng bạc trắng, lại còn có thể có cơ hội trở thành người như tam thúc, Hàn phụ cuối cùng cũng đưa ra chủ ý, đáp ứng lời đề nghị của tam thúc.\n" +
            "\n" +
            "Tam thúc thấy Hàn phụ đáp ứng rồi, trong lòng rất cao hứng. Liền lưu lại vài lượng bạc, nói tháng sau sẽ đến dẫn Hàn Lập đi, trong khoảng thời gian này, cho hắn ăn uống tốt hơn một chút, bồi bổ thân thể để còn có thể tham gia ứng thí. Cuối cùng, tam thúc cùng cha mẹ hắn chào tạm biệt nhau, xoa xoa đầu hắn rồi ra khỏi cửa đi về.\n" +
            "\n" +
            "Hàn Lập mặc dù nghe không hoàn toàn hiểu những gì tam thúc vừa nói, nhưng có khả năng vào thành, có thể kiếm tiền thì hắn nghe là hiểu được.\n" +
            "\n" +
            "Nguyện vọng của hắn từ trước đến nay, mắt thấy có thể thực hiện được, hắn trong mấy buổi tối liên tiếp, hưng phấn nên ngủ không yên.\n" +
            "\n" +
            "Một tháng sau, tam thúc của hắn theo đúng thời gian ước định quay lại thôn để dẫn Hàn Lập đi. Trước khi đi, Hàn phụ dặn dò, động viên, chúc phúc Hàn Lập: Làm người phải thành thật, gặp chuyện thì nên nhẫn nhịn, không nên cùng người khác tranh chấp, mà Hàn mẫu dặn hắn cần phải chú ý thân thể, ăn ngủ cho tốt.\n" +
            "\n" +
            "Ngồi trên xe ngựa, nhìn thân ảnh cha mẹ xa dần, Hàn Lập cắn chặt hàm răng, cố gắng kìm nén không cho nước mắt chảy ra ngoài.\n" +
            "\n" +
            "Tuy hắn so với những đứa trẻ cùng trang lứa thì chín chắn hơn, nhưng dù sao thì hắn vẫn còn là một đứa trẻ mới mười tuổi, lần đầu tiên xa nhà làm cho hắn cảm thấy có chút bàng hoàng, thương cảm. Trong tâm lý còn non dại của hắn đã hạ quyết tâm, đợi đến khi kiếm được tiền rồi sẽ ngay lập tức rong ngựa trở về với cha mẹ, không xa rời nhau nữa.\n" +
            "\n" +
            "Hàn Lập từ trước không có nghĩ đến, chỉ là sau khi rời khỏi thôn làng hắn mới nhận ra, tiền đã không còn ý nghĩa với hắn như lúc xưa nữa rồi. Mà hắn mặc nhiên không biết rằng, con đường vận mệnh của hắn không giống như những người bình thường. Con đường tu tiên của hắn bắt đầu từ đây.\n" +
            "\n" +
            "* hồng tương quả: Hình như là quả trứng cá. " +
            "\n" +
            "Đây là một thị thành nhỏ, tuy nói là một tòa tiểu thành, nhưng thực ra nó chỉ to hơn thị trấn bình thường một ít thôi, mà tên của nó cũng được gọi là Thanh Ngưu trấn, chỉ những kẻ sơn dã phụ cận ít kiến thức mới gọi Thanh Ngưu trấn thành Thanh Ngưu thanh mà thôi. Cách gọi này cũng đã thành thói quen mấy chục năm ở đây mất rồi.\n" +
            "\n" +
            "Thanh ngưu trấn đích xác không lớn lắm, con đường chủ đạo Thanh ngưu chạy dọc trấn theo hướng Đông-Tây. Mà khách sạn ở đây thì cũng chỉ có đúng một cái Thanh ngưu khách sạn. Khách sạn nằm tít cuối trấn về phía tây. Khách vãng lai qua đây, nếu không muốn phải nằm ngoài đường thì không còn cách nào khác là phải làm khách tại khách sạn này.\n" +
            "\n" +
            "Vào lúc này, nếu chú ý ra ngoài, từ phía Tây thị trấn có một đoàn xe ngựa đang tiến vào Thanh ngưu trấn. Rất nhanh đoàn xe đi tới trước cửa Thanh ngưu khách sạn, đoàn xe cũng không dừng lại mà tiếp tục đi sau vào trong trấn, đến khi đi tới trước cửa Xuân Hương tửu lâu thì mới dừng lại.\n" +
            "\n" +
            "Xuân Hương tửu lâu cũng không tính là lớn, thậm chí nó còn có dáng vẻ hơi cũ cũ, tuy vậy người ta vẫn cảm nhận được từ nó nét gì đó cổ kính. Cũng bởi vì bây giờ đang là chính ngọ, khách nhân dùng bữa tại tửu lầu vẫn còn khá đông đúc, cho nên bên trong tửu lâu hầu như không còn chỗ trống nữa.\n" +
            "\n" +
            "Từ trên xe xuống là một lão béo mặt tròn có bộ râu quai nón dắt theo một đứa trẻ đen đúa tầm mười tuổi. Người đàn ông này khệnh khạng dẫn tiểu hài tử trực tiếp bước vào tửu lâu. Khách hàng trong tửu lâu cũng có người nhận ra lão béo, biết rằng lão là chưởng quĩ \"Hàn béo mập\" của tửu lâu, còn tiểu hài tử kia thì không một ai nhận biết ra.\n" +
            "\n" +
            "\"Lão Hàn, tên hắc tiểu tử này mà lớn lên thì trông giống lão lắm đây, không phải là lão lén sau lưng vợ ra ngoài trăng gió đấy chứ?\" Đột nhiên có người trêu ghẹo nói.\n" +
            "\n" +
            "Một lời vừa nói ra, chúng nhân bên cạnh lập tức cười to một trận.\n" +
            "\n" +
            "\"Phi (Ta nhổ)! Hắn là cháu ruột của ta, đương nhiên là phải có vài phần giống ta rồi.\" Lão béo chẳng những không tức giận, mà còn có vài phần đắc ý.\n" +
            "\n" +
            "Hai người này chính là nhân vật chính Hàn Lập của chúng ta và tam thúc của hắn, được mọi người trong trấn gọi là \"lão Hàn béo\" vừa đi liên tục ba ngày đường mới tới được Thanh ngưu trấn.\n" +
            "\n" +
            "Lão Hàn mập sau khi nói chuyện phiếm dăm ba câu với đám khách nhân liền dẫn Hàn Lập đi vào phía sau tửu lâu, tới một tòa tiểu viện vắng vẻ.\n" +
            "\n" +
            "\"Tiểu Lập, cháu ở trong phòng này nghỉ ngơi chút đi nhé, đợi đến khi quản sự nội môn tới, ta sẽ gọi cháu tới. Ta bây giờ phải đi tiếp đãi mấy vị khách kia một chút\" Lão Hàn mập chỉ vào một căn phòng trong nội viện, nói một cách hòa ái với hắn.\n" +
            "\n" +
            "Nói xong, liền quay người đi ra ngoài.\n" +
            "\n" +
            "Vừa ra tới cửa, lão cảm thấy có chút gì đó không được yên tâm, liền dặn dò thêm vài câu.\n" +
            "\n" +
            "\"Đừng nghịch ngợm đấy, trong trấn có rất nhiều người, tốt nhất là đừng ra khỏi tiểu viện.\"\n" +
            "\n" +
            "\"Vâng!\"\n" +
            "\n" +
            "Nhìn thấy Hàn Lập ngoan ngoãn đáp ứng, lão mới yên tâm đi ra.\n" +
            "\n" +
            "Hàn Lập nhìn tam thúc đi ra khỏi ngoài, cảm thấy mệt mỏi, liền nằm lăn ra giường đánh luôn một giấc, cư nhiên không có lấy một điểm sợ hãi thường thấy của một đứa trẻ phải xa nhà.\n" +
            "\n" +
            "Cho đến tận buổi tối thì có một người phục vụ mang cơm đến, tuy không phải là thịt ngon cá béo gì cả, nhưng cũng tính là vừa miệng. Sau khi ăn xong thì người phục vụ lại đến bưng chén bát ra ngoài. Lúc này tam thúc của hắn mới đỉnh đương đi đến.\n" +
            "\n" +
            "\"Thế nào? Thức ăn có vừa miệng hay không? Cháu có nhớ nhà không?\"\n" +
            "\n" +
            "\"Dạ, có chút chút ạ\" Hàn Lập ngoan ngoãn trả lời.\n" +
            "\n" +
            "Lão Hàn nghe Hàn Lập trả lời xong cảm thấy rất vừa lòng, sau đó liền cùng hắn nói chút chuyện phiếm, rồi hãnh diện kể lại những kinh nghiệm của lão đã trải qua cho Hàn Lập nghe. Dần dần, Hàn Lập không còn cảm thấy gò bó, hắn bắt đầu cùng tam thúc cười nói với nhau đủ chuyện.\n" +
            "\n" +
            "Cứ như vậy, hai ngày tiếp theo từ từ trôi qua.\n" +
            "\n" +
            "Đến ngày thứ ba, ngay lúc Hàn Lập vừa ăn cơm chiều xong, đang đợi tam thúc đến nói chuyện về giang hồ cố sự thì lại có một cỗ xe ngựa dừng lại trước cửa tửu lâu.\n" +
            "\n" +
            "Chiếc xe ngựa này toàn thân đen tuyền, loại xe như thế này không phải là thường thấy, đặc biệt, gây chú ý nhất chính là trước xe có gắn một lá cờ nhỏ màu đen. Trên lá cờ có thêu chữ \"Huyền\" màu trắng, viền hồng. Nó mang lại cho người ta một cảm giác thần bí khó nói.\n" +
            "\n" +
            "Nhìn thấy lá cờ nhỏ này, phàm là các tay giang hồ trong phương viên trăm dặm thì đều biết, tại địa phương này có nhân vật trọng yếu của môn phái đứng nhất nhì trong vùng \"Thất huyền môn\" giá lâm.\n" +
            "\n" +
            "\"Thất huyền môn\" còn được gọi là \"Thất tuyệt môn\", môn phái này được \"thất tuyệt thượng nhân\" danh tiếng lẫy lừng sáng lập ra cách đây hơn hai trăm năm. Môn phái này đã từng đứng đầu Kính Châu hơn mười năm, thậm chí còn lan tới Sổ Châu bên cạnh, thanh danh trong nước cũng lên cao chót vót. Tuy nhiên, từ khi \"Thất tuyệt chân nhân\" bệnh chết, thế lực \"thất huyền môn\" tựa như rớt xuống ngàn trượng, bị mấy môn phái khác liên thủ đẩy ra khỏi thủ phủ Kính Châu thành. Hơn trăm năm trước, tông môn đã bị bức bách di chuyển đến địa điểm vắng vẻ tiêu điều nhất của Kính Châu – Thái Hà sơn, từ đó về sau \"thất huyền môn\" đã bám rễ tại chỗ này, rớt xuống tam lưu tiểu thế lực ở địa phương.\n" +
            "\n" +
            "Có một câu nói rất đúng, lạc đà gầy thì vẫn còn hơn con ngựa to béo, Thất huyền môn dù sao thì cũng đã từng là một đại môn phái, tiềm lực bên trong thì không thể xem nhỏ được. Ngay lập tức đã không chế hơn chục tiểu trấn xung quanh Thanh ngưu trấn, có hơn ba bốn ngàn đệ tử, là một trong những bá chủ ở đây.\n" +
            "\n" +
            "Tại đây, bang phái duy nhất có khả năng đối kháng lại Thất huyền môn là Dã lang bang.\n" +
            "\n" +
            "Dã lang bang tiền thân vốn là đám mã tặc chuyên đốt phá, cướp bóc trong địa phận Kính châu, sau này do bị quan binh đuổi giết, một bộ phận theo hàng quan phủ, bộ phận còn lại hình thành lên Dã lang bang ngày nay. Nhưng, sự hung hăng tàn ác của mã tặc đã thấm vào máu, bọn chúng liều lĩnh cướp phá, giết người không gì là không dám. Cho nên, khi Thất huyền môn và Dã lang bang có xung đột thì Thất huyền môn cũng chỉ nằm ở thế hạ phong mà thôi.\n" +
            "\n" +
            "Dã lang bang khống chế hương trấn nhiều hơn hẳn, nhưng những trấn này lại không thể kinh doanh, cho nên khi luận về phú túc thì còn xa mới theo kịp những thành trấn thuộc về Thất huyền môn. Dã lang bang thập phần thèm muốn địa bàn mầu mỡ của Thất huyền môn, cho nên thương xuyên khơi mào cuộc chiến giữa hai bên. Việc này đã làm cho Thất huyền môn môn chủ hiện hành đau đầu không ít, và nó cũng chính là nguyên nhân khiến cho gần mười năm nay, Thất huyền môn liên tục chiêu thu nội đệ tử.\n" +
            "\n" +
            "Từ trên xe ngựa nhảy xuống một hán tử cao gầy tầm bốn mươi tuổi, động tác của hán tử này rất nhanh nhẹn, thể hiện bản lĩnh không hề yếu kém, tựa hồ đối với chỗ này rất quen thuộc. Trực tiếp đi thẳng vào căn phòng bên trong.\n" +
            "\n" +
            "Hàn Lập tam thúc vừa nhìn thấy người mới đến, lập tức cung kính làm lễ.\n" +
            "\n" +
            "\"Vương hộ pháp, lão nhân gia ngài thế nào lại tự thân dẫn người tới vậy?\"\n" +
            "\n" +
            "\"Hừ!\" Vương hộ pháp hừ lạnh một tiếng, vẻ mặt rất ngạo mạn.\n" +
            "\n" +
            "\"Trong khoảng thời gian không yên ổn này, cần phải gia tăng phòng vệ, trưởng lão lệnh cho ta tự thân thống lĩnh nhân lực, bớt nói linh tinh đi, tiểu hài tử này có phải là người mà ngươi tiến cử?\"\n" +
            "\n" +
            "\"Đúng vậy, đúng vậy, hắn vốn là cháu ruột của ta, mong rằng trên đường đi Vương hộ pháp chiếu cố tới hắn một chút.\"\n" +
            "\n" +
            "Lão Hàn mập thấy thần sắc hán tử có vẻ bất mãn, liền nhanh nhẹn lấy từ trong người ra một cái túi nặng nặng, kín đáo đặt vào tay.\n" +
            "\n" +
            "Vương hộ pháp nâng nâng cái túi, thần sắc có chút hòa hoãn xuống.\n" +
            "\n" +
            "\"Lão Hàn mập, ngươi biết cách làm người đấy! Ta nhất định sẽ chiếu cố cháu ngươi trên đường rồi. Thời gian không còn sớm nữa, khẩn trương lên đường thôi.\"" +
            "\n" +
            "Không khí trong xe không được trong lành cho lắm, điều này cũng phải thôi, hơn ba chục tiểu hài tử chen chúc trong một chiếc xe. Tuy nói là tiểu hài tử nhỏ hơn nhiều so với người trưởng thành, nhưng với số lương thế này, cũng đủ để làm bầu không khí trong xe trở nên khó thở.\n" +
            "\n" +
            "Hàn Lập tinh ranh đã chui ngay vào một góc nằm sâu trong xe, len lén đánh giá mấy tiểu hài đồng còn lại trong xe.\n" +
            "\n" +
            "Tới tham gia kỳ khảo thí nhập môn lần này, từ cách ăn mặc, ăn nói dễ dàng nhận thấy có ba dạng người.\n" +
            "\n" +
            "Loại người thứ nhất ngồi ở giữa xe, đang bị đám trẻ con vây quanh ủng hộ. Thiếu niên mặc cẩm y chính là thuộc dạng người thứ nhất này.\n" +
            "\n" +
            "Thiếu niên này tên gọi là Vũ Nham, năm nay mới mười ba tuổi, là đứa trẻ lớn tuổi nhất ở trong xe lúc này. Vốn tuổi của hắn đã vượt quá qui định, nhưng hắn có một vị biểu tỷ được gả cho một nhân vật có đại quyền trong Thất huyền môn, nên cho dù vượt quá tuổi qui định thì cũng không phải là vấn đề gì to tát. Gia đình Vũ Nham mở một võ quán, gia trung có chút giàu có, tuổi tuy còn nhỏ nhưng cũng đã có tập võ qua. Công phu tuy không lấy làm cao minh cho lắm, nhưng để đối phó lại với những đứa bé một điểm khí lực cũng không có như Hàn Lập thì có lẽ là dư sức.\n" +
            "\n" +
            "Rất hiển nhiên, loại người như Vũ Nham có tiền, có thế, tự nhiên sẽ trở thành \"đại ca\" của đại bộ phận đám tiểu hài tử trong xe.\n" +
            "\n" +
            "Một loại người khác tựu là những hài đồng ủng hộ Vũ Nham. Những hài đồng này xuất thân từ đủ loại gia cảnh như có người trong nhà có cửa hàng, có người thì phải đi làm công… nói chung những hài tử này đều có điểm chung: đều lớn lên trong thành trấn, có cơ hội ít nhiều quan sát cách xử sự những người có học vấn, trục lợi nhi hành (có lợi thì làm) đã thành bản sự rồi. Do đó mà những đứa trẻ này dốc sức ủng hộ Vũ Nham, cứ một điều \"Vũ thiếu gia\" hai điều \"Vũ thiếu gia\" mà gọi. Vũ Nham trước sự tôn vinh của bọn trẻ như vậy cũng coi như bình thường, hắn còn có cảm giác hưởng thụ sự tôn vinh đó.\n" +
            "\n" +
            "Còn loại người cuối cùng, tất nhiên là dạng người giống như Hàn Lập. Loại người này đến từ vùng đất hoang vu hẻo lánh, gia cảnh hầu như đều bần hàn, có gì ăn đó. Loại người như vậy trong xe rất là ít, chỉ có tầm năm sáu đứa trẻ mà thôi. Thần thái của bọn chúng đa phần là e dè, không dám nói năng với ai cái gì, chỉ ngồi mà nhìn người khác nói cười mà thôi. Những tiểu hài tử này cùng với những đứa trẻ đang huyên náo còn lại tạo thành một khung cảnh đối lập.\n" +
            "\n" +
            "Xe ngựa xuất phát từ Thanh ngưu trấn theo hướng Tây mà thẳng tiến, trên lộ trình còn đi qua thêm vài địa phương nữa, cũng tiếp thêm vài tiểu hài đồng nữa. Cuối cùng đến chiều ngày thứ năm thì cũng đi tới được Thái Hà sơn – tổng môn của Thất huyền môn.\n" +
            "\n" +
            "Hầu hết tiểu hài tử khi xuống xe đều bị cảnh quan tươi đẹp của Thái Hà sơn làm cho mê mẩn. Chỉ đến khi Vương hộ pháp lên tiếng thúc giục, mọi người mới thanh tỉnh trở lại rồi tiếp tục đi tới.\n" +
            "\n" +
            "Thái Hà sơn nguyên danh gọi là Lạc Phượng sơn, tương truyền rằng nơi đây từng có một con phượng hoàng ngũ sắc rớt xuống đây rồi hóa thành ngọn núi này. Sau này, người ta phát hiện cảnh sắc ngọn núi này vào lúc mặt trời xuống thì trông đẹp vô cùng, như là có đám mây hồng bao phủ trên đỉnh núi, do vậy mà ngọn núi bị người ta đổi tên thành Thái Hà sơn. Đương nhiên, ngọn núi này từ sau khi bị Thất huyền môn chiếm cứ, người ngoài đã không còn cơ hội thưởng ngoạn cảnh đẹp ở đây.\n" +
            "\n" +
            "Thái Hà sơn là một trong những ngọn núi lớn của Kính châu, ngoài trừ tòa Bách mãng sơn, thì ngọn núi này chiếm diện tích lớn nhất, phương viên mười dặm quanh ngọn núi này đều là núi non chập trùng. Tính ra trên núi này có hơn mười sơn phong (đỉnh núi) to nhỏ. Hầu hết chúng đều chiếm vị trí vô cùng hiểm yếu, do đó đều bị người của các phân đường Thất huyền môn chiếm cứ. Đỉnh núi chính của Thái Hà sơn là \"Lạc Nhật phong\" càng hiểm ác vô cùng, chẳng những nó là đỉnh cao nhất, mà ở đó cũng chỉ có duy nhất một con đường độc dạo dẫn lên núi, do vậy mà Thất huyền môn đem tổng đàn đặt lên đỉnh núi này. Còn đường này không những hiểm trở, mà dọc theo con đường Thất huyền môn còn thiết lập mười ba trạm gác cả minh cả ám, có thể nói là vạn vô nhất thất (ngàn vạn cái cũng không để lọt mất cái nào), không có gì để phải lo lắng.\n" +
            "\n" +
            "Hàn Lập đang nhìn ngó bốn xung quanh, bỗng nhiên thấy phía trước mọi người đều dừng lại, tiếp đó một âm thanh hào sảng truyền đến.\n" +
            "\n" +
            "\"Vương lão đệ, có chuyện gì mà đến bây giờ mới đến nơi? So với dự định thì trễ mất hai ngày thời gian rồi.\"\n" +
            "\n" +
            "\"Nhạc đường chủ, trên đường đi có chút chậm trễ, phiền ngài để tâm rồi.\" Vương hộ pháp đứng đầu đám người, cung kính hướng tới một vị lão giả mặt mũi hồng hào thi lễ. Bộ mặt ngang tàng khi đi đường của hắn đã được thay bằng một bộ mặt trông rất siểm nịnh.\n" +
            "\n" +
            "\"Đây là nhóm đệ tử thứ mấy được đưa đến vậy?\"\n" +
            "\n" +
            "\"Là nhóm thứ mười bảy.\"\n" +
            "\n" +
            "\"Ân!\" vị Nhạc đường chủ này khinh khỉnh nhìn xuống đám tiểu hài tử Hàn Lập.\n" +
            "\n" +
            "\"Đưa đến Thanh khách viện, để bọn chúng nghỉ ngơi một đêm cho tốt, sáng mai bắt đầu chọn lựa đệ tử rồi. Một khi bị loại, phải sớm đưa bọn chúng xuống núi, đừng để phạm vào qui định của bản môn.\n" +
            "\n" +
            "\"Tuân mệnh, Nhạc đường chủ!\"\n" +
            "\n" +
            "Được đi trên con đường đá dẫn lên núi, đám tiểu hài tử đều hưng phấn mãi không thôi, nhưng cũng chưa có ai dám lớn tiếng nói chuyện. Tuy bọn chúng đều chưa trưởng thành, nhưng cũng nhận biết được nơi này sẽ quyết định vận mệnh tương lai của mình.\n" +
            "\n" +
            "Vương hộ pháp vừa đi trước dẫn đường, vừa tươi cười chào hỏi những người gặp trên đường. Có thể nhìn ra hắn tại môn nội quen biết khá nhiều người, cho nên con đường sau này của hắn cũng khá lạc quan.\n" +
            "\n" +
            "Dọc đường chỉ thấy mọi người ở đây đều mặc áo bó ngắn màu xanh, trên thân hoặc đeo đao, hoặc dắt kiếm, cũng thỉnh thoảng có người đi tay không nhưng ở thắt lưng phồng phồng lên, khó mà đoán biết được ở đó là cái gì. Từ cử chỉ hành vi, có thể nhìn ra người đó thân thủ mạnh mẽ, chắc hẳn phải mang trong mình một thân công phu không sai.\n" +
            "\n" +
            "Hàn Lập được người ta dẫn đến một đỉnh núi thấp nhỏ, trên đỉnh núi có sẵn một căn thổ phòng. Hàn Lập được cho ngủ qua đêm ở đây để đến ngày mai chờ người dẫn đi. Trong giấc mộng, Hàn Lập mơ thấy mình mặc cẩm y, tay cầm kim kiếm, thân hoài tuyệt kỹ võ công, đánh cho con lão thợ rèn trong làng mà ngày trước hắn không đánh nổi một trận no nê, hết cả uy phong, đến tận ngày thứ hai vẫn chưa đứng lên nổi.\n" +
            "\n" +
            "Khi trời vừa sáng, Vương hộ pháp cũng không để mọi người được ăn bữa sáng, trực tiếp đem chúng nhân dẫn xuống núi, tới trước một khu rừng trúc rậm rạp. Tại đây, ngoài vị đường chủ họ Nhạc đã gặp ngày hôm qua còn có mấy người thanh niên lạ khác đã đứng chờ sãn.','https://static.8cache.com/cover/o/eJzLyTDT17WITwqMNNQtNKp01A_zNXY1ifQuc8301HeEghwTR_1IV8PsTO-w4HKTUP1yI0NT3QxjIyMANRgRnA==/pham-nhan-tu-tien.jpg',1)";
    private String SQLQuery11 = "INSERT INTO truyen VALUES (null,'TU LA VŨ THẦN','Chương 1: NGOẠI MÔN ĐỆ TỬ.\n" +
            "\n" +
            "\n" +
            "Luận tiềm lực, không tính thiên tài, nhưng huyền công vũ kỹ, đều có thể vô sư tự thông. Luận mị lực, thiên kim tiểu thư tính toán là cái gì, yêu nữ thánh nữ, đều yêu ta, muốn ngừng mà không được. Luận thực lực, mặc kệ ngươi có ngàn vạn chí bảo, nhưng cũng không địch lại linh giới đại quân của ta. Ta là ai? Thiên hạ chúng sinh xem ta là Tu La, lại không biết, ta dùng Tu La thành võ thần...Đi đến đỉnh phong.\n" +
            "\n" +
            "Đẳng cấp trong truyện: Linh Vũ, Nguyên Vũ, Huyền Vũ, Thiên Vũ, Vũ quân, Võ Vương, Vũ Đế, Vũ tổ....\n" +
            "\n" +
            "Đêm, trăng tròn trên cao, bầu trời đầy sao.\n" +
            "\n" +
            "Tại nơi chân trời, đã có cửu sắc lôi quang chớp lóa, vô cùng chói mắt.\n" +
            "\n" +
            "\"Trời sinh dị tượng, chắc chắn có thần thể phủ xuống.\"\n" +
            "\n" +
            "Cửu Châu đại lục, trên đỉnh hoàng thành, một vị kim y lão giả đang chắp tay đứng, nhìn lên bầu trời đêm.\n" +
            "\n" +
            "Ở phía sau, còn có mấy vạn danh hoàng thành cao thủ, chỉnh tề nửa quỳ trên mặt đất, như đang chờ đợi cái mệnh lệnh gì.\n" +
            "\n" +
            "\"Ông \"\n" +
            "\n" +
            "Đột nhiên, lôi quang ngưng tụ, rồi hóa thành một đạo cửu sắc thần lôi, từ trên cửu thiên ngân hà, đánh xuống.\n" +
            "\n" +
            "Trong sát na, đêm tối như biến thành ban ngày, thần lôi còn chưa có hạ xuống, mà đại địa đã bắt đầu ầm ầm rung động, kịch liệt run rẫy.\n" +
            "\n" +
            "Trong một chốc cửu sắc thần lôi, cùng đại lục tiếp xúc kia, cũng không có tạo thành phá hư đáng sợ nào, chỉ đột nhiên hư không tiêu thất.\n" +
            "\n" +
            "Cùng lúc đó, đại địa lần thứ hai bị bóng đêm bao phủ, ánh sáng chói của bầu trời đêm cũng là lờ mờ đi không ít, phảng phất như tinh hoa đã bị hút đi, khôi phục lại yên tĩnh như trước kia.\n" +
            "\n" +
            "Nhưng lúc này đây hai mắt của lão giả lại sáng sủa dị thường, thậm chí còn kích động khiến thân thể run rẩy, lão đưa ngón tay chỉ nơi sấm sét hạ xuống nói: \"Thanh Châu cảnh nội, toàn bộ những đứa nhỏ tối nay phủ xuống, hết thảy mang về hoàng thành cho ta!\"\n" +
            "\n" +
            "\"Tuân mệnh!\"\n" +
            "\n" +
            "Tiếng trả lời như sấm vang vọng khắp chân trời, mấy vạn danh hoàng thành cao thủ đi tới Thanh Châu, thề phải tìm cho được thần thể, để hoàng triều sử dụng.\n" +
            "\n" +
            "Thời gian trôi qua, đảo mắt đã qua năm năm, mọi người mặc dù còn nhớ rõ một màn kinh thiên ngày đó, nhưng không ai biết hoàng triều làm chuyện gì.\n" +
            "\n" +
            "Cửu Châu đại lục, Thanh Châu cảnh nội, tông môn san sát, Thanh Long Tông là một trong số đó.\n" +
            "\n" +
            "Hôm nay, lại đến ngày Thanh Long Tông mỗi năm một lần, tuyển nhận đệ tử, bên ngoài Thanh Long Tông, người đến tấp nập.\n" +
            "\n" +
            "Bất quá lúc này, bận rộn nhất đó là ngoại môn đệ tử, toàn bộ tông môn tiếp đãi, toàn bộ đặt ở trên đầu bọn họ.\n" +
            "\n" +
            "Ngoại môn đệ tử, không cần phí sức lấy lòng, trước không nói tại tông môn địa vị thấp, mà ngay cả ngoại nhân cũng là khinh thường bọn họ.\n" +
            "\n" +
            "Lý do rất đơn giản, phàm là ngoại môn đệ tử, nói rõ tư chất cực kém, chung thân khó có thành tựu lớn, tự nhiên bị mọi người khinh thường.\n" +
            "\n" +
            "\"Này, ngươi là cái thái độ gì vậy, ngươi biết ta là ai không?\" Một gã phụ nhân quần áo hoa lệ, dẫn theo một gã nam hài, chỉ vào một gã thiếu niên cả tiếng trách cứ.\n" +
            "\n" +
            "\"Thực sự xin lỗi, sắc trời đã tối, tông môn sắp sửa đóng cửa, hai vị hay là ngày mai trở lại a.\" Thiếu niên khuôn mặt thanh tú lộ rỏ vẽ non nớt, bất quá trên trán có nhất mạt anh khí.\n" +
            "\n" +
            "Hắn tên là Sở Phong, năm nay mười lăm tuổi, là một trong hàng vạn ngoại môn đệ tử của Thanh Long Tông.\n" +
            "\n" +
            "Bất quá dù là ngoại môn đệ tử, nhưng Sở Phong này không giống người thường, không có tự ti kém một bậc, không có đắm mình trầm luân, đối đãi mỗi người cũng đều không sợ hãi, thong dong tự nhiên.\n" +
            "\n" +
            "\"Ngày mai trở lại, ngươi cho ta là ngu ngốc sao? Ở đây thâm sơn dã lĩnh ngươi bảo mẫu tử chúng ta ở đâu?\"\n" +
            "\n" +
            "\"Ngươi phải an bài nơi ở cho ta, nếu không ta sẽ đi tìm trưởng lão các ngươi lý luận.\" Phụ nhân không nghe theo cũng không buông tha, lại chộp lấy vạt áo Sở Phong.\n" +
            "\n" +
            "\"Sở Phong đệ, gặp phải phiền phức hả?\" Lại đúng lúc này, một đạo thanh âm dịu dàng đột nhiên vang lên.\n" +
            "\n" +
            "Bình tĩnh nhìn lại, là một tử y thiếu nữ, đang chầm chậm đến, tuy rằng khóe môi mỉm cười nhếch lên, nhưng đôi mắt sắc bén này, lại chăm chú nhìn chằm chằm phụ nhân.\n" +
            "\n" +
            "Nhìn thấy thiếu nữ, sắc mặt phụ nhân nhất thời đại biến, nhất mạt nồng nặc sợ hãi hiện lên.\n" +
            "\n" +
            "Không bởi vì cái khác, mà chỉ vì tử sắc trường bào trên người thiếu nữ, lại là tiêu chí của nội môn đệ tử.\n" +
            "\n" +
            "Phụ nhân thầm kêu bất hảo, vốn tưởng rằng với thân phận của mình, có thể làm khó dễ một chút thiếu niên trước mắt.\n" +
            "\n" +
            "Không tưởng được, cái thiếu niên nhìn như bình thường này, lại có nội môn đệ tử làm hậu trường, đây chính là tồn tại mà bà không thể trêu vào.\n" +
            "\n" +
            "\"Không có việc gì không có việc gì, ta chỉ là theo vị tiểu huynh đệ này, hỏi chút việc mà thôi.\" Phụ nhân cười giải thích.\n" +
            "\n" +
            "Thiếu nữ đầu tiên là liếc mắt trừng bà, sau đó chỉ nói một chữ: \"Cút.\"\n" +
            "\n" +
            "Giờ khắc này, phụ nhân thân thể không khỏi run lên, sắc mặt đã trở nên tái nhợt.\n" +
            "\n" +
            "Bất quá bà cũng không có một chút do dự, nắm tay nam hài liền bước nhanh rời đi, trong lúc hoảng loạn đó lại va vào một người té ngã, chật vật đến cực điểm.\n" +
            "\n" +
            "Thấy thế, Sở Phong bất đắc dĩ lắc đầu, sau đó hướng thiếu nữ bên cạnh thi lễ nói: \"Đa tạ Sở Nguyệt sư tỷ \"\n" +
            "\n" +
            "\"Với ta mà ngươi còn khách khí, chúng ta là người một nhà mà.\" Sở Nguyệt có chút không vui.\n" +
            "\n" +
            "Nàng nói cũng không sai, Sở Phong cùng nàng đích thật là người một nhà, bọn họ đến từ một thế gia, Sở gia.\n" +
            "\n" +
            "Sở Nguyệt chính là biểu tỷ Sở Phong con của nhị bá, chỉ so với Sở Phong lớn hơn một tuổi.\n" +
            "\n" +
            "Bất quá, Sở Nguyệt tại ba năm trước đây đã thông qua nội môn khảo hạch, trở thành nội môn đệ tử, hôm nay đã là Linh Võ tứ trọng cao thủ.\n" +
            "\n" +
            "\"Tông môn quy củ, luôn luôn phải tuân thủ.\" Sở Phong giả lả cười nói.\n" +
            "\n" +
            "\"Ai\" nhưng mà nhìn Sở Phong như vậy, Sở Nguyệt cũng đau xót trong lòng: \"Sở Phong đệ, năm nay nội môn khảo hạch ngươi còn không tham gia sao? Lẽ nào, ngươi còn chưa có đạt được Linh Võ tam trọng?\"\n" +
            "\n" +
            "Sở Phong vẫn chưa trả lời, trên mặt vẫn như cũ lộ ra mỉm cười, không ai biết hắn đây là cái ý tứ gì.\n" +
            "\n" +
            "Thấy thế, Sở Nguyệt từ bên hông lấy xuống một cái túi gấm, nhét vào trong tay Sở Phong: \"Đem nó luyện hóa, là có thể giúp ngươi đột phá tam trọng.\" Text được lấy tại truyenyy[.c]om\n" +
            "\n" +
            "Sở Phong đem túi gấm mở ra, nhất thời một cổ linh khí bức người tán phát ra, một gốc cây tiên linh thảo cở ngón tay, sáng óng ánh nằm lăng trong đó.\n" +
            "\n" +
            "\"Sở Nguyệt tỷ, cái này quá quý trọng, ta không thể nhận.\" Sở Phong vội vàng trả lại cho Sở Nguyệt.\n" +
            "\n" +
            "Tiên linh thảo, chính là thánh dược tu võ, cực kỳ trân quý, đối với tu võ giả Linh Võ Cảnh, đều có công hiệu vô tận.\n" +
            "\n" +
            "Mà Sở gia để cho bọn họ tăng nhanh tu vi, hàng năm đều phụ cấp bọn họ mỗi người một gốc Tiên linh thảo.\n" +
            "\n" +
            "Nghĩ đến cây này của Sở Nguyệt, cũng là gia tộc phụ cấp, chỉ là Sở Nguyệt vẫn chưa dùng, trái lại là đem cho hắn, điều này làm cho Sở Phong rất cảm động, lại càng không đành lòng tiếp thu.\n" +
            "\n" +
            "\"Ta nói cho ngươi, ngươi cứ cầm đi, có còn là đệ đệ của ta hay không đó.\" Sở Nguyệt có chút không vui.\n" +
            "\n" +
            "\"Ơ, Sở Nguyệt tỷ lúc nào hào phóng như vậy rồi, Tiên linh thảo cư nhiên cũng muốn tặng người?\"\n" +
            "\n" +
            "\"Tỷ xem, ta cũng là đệ đệ của tỷ, vừa vặn gần đây sắp sửa đột phá Linh Võ tứ trọng, không bằng Sở Nguyệt tỷ đem Tiên linh thảo này tặng ta được không?\"\n" +
            "\n" +
            "Một gã thiếu niên cùng Sở Phong tuổi xấp xỉ đã đi tới, trên người đồng dạng cũng mặc y phục nội môn đệ tử.\n" +
            "\n" +
            "Hắn gọi Sở Chân, đồng dạng đến từ Sở gia, năm năm trước cùng Sở Phong cùng bái nhập Thanh Long Tông, chỉ bất quá lúc hai năm trước, hắn đã thành nội môn đệ tử.\n" +
            "\n" +
            "\"Sở Chân, ngươi đã từ lâu đột phá Linh Võ tam trọng, thành công ngưng tụ linh khí, dù là không có Tiên linh thảo cũng có thể lên như diều gặp gió.\"\n" +
            "\n" +
            "\"Nhưng Sở Phong đệ đến nay còn chưa ngưng tụ linh khí, Tiên linh thảo này đối với hắn càng trọng yếu.\" Sở Nguyệt đem Tiên linh thảo, mạnh mẽ nhét vào trong tay Sở Phong.\n" +
            "\n" +
            "\"Đúng vậy, tỷ nói không sai, đáng tiếc hắn không lĩnh tình của tỷ.\" Sở Chân giơ hai tay ra, cười lạnh.\n" +
            "\n" +
            "\"Ai nói ta không cần.\" Sở Phong lại mỉm cười, không chút khách khí đem Tiên linh thảo cất vào trong lòng, sau đó nói: \"Sở Nguyệt tỷ, Tiên linh thảo này là cho ta mượn, ngày sau chắc chắn xin trả gấp đôi.\"\n" +
            "\n" +
            "\"Ân, được.\" Thấy Sở Phong nhận lấy, Sở Nguyệt rất mừng, chỉ là tùy tiện trả lời, căn bản không nghĩ Sở Phong trả lại nàng.\n" +
            "\n" +
            "\"Ngươi lấy cái gì mà trả? Tiên linh thảo này cho ngươi dùng, quả thực là lãng phí.\" Bất quá sắc mặt Sở Chân, rất khó nhìn.\n" +
            "\n" +
            "Sở Phong cười cười vẫn không để ý đến hắn, mà là đối với Sở Nguyệt nói rằng: \"Sở Nguyệt tỷ, năm nay nội môn khảo hạch ta sẽ tham gia.\"\n" +
            "\n" +
            "\"Hừ, chỉ bằng ngươi? Ngươi nếu có thể thông qua nội môn khảo hạch, năm nay Tiên linh thảo gia tộc phụ cấp, ta sẽ đưa ngươi.\" Sở Chân khinh thường nhìn Sở Phong.\n" +
            "\n" +
            "\"Nói thế có thật không?\" Sở Phong cũng không tin.\n" +
            "\n" +
            "\"Sở Nguyệt tỷ làm chứng, bất quá nếu là ngươi không thể thông qua thì sao?\"\n" +
            "\n" +
            "\"Ta đây năm nay Tiên linh thảo, cũng sẽ về ngươi.\" Sở Phong lưu lại những lời này, rồi tiếp tục đầu nhập trong công tác của ngoại môn đệ tử.\n" +
            "\n" +
            "\"Sở Chân, chúng ta đều là người một nhà, ngươi vì sao luôn luôn làm khó Sở Phong?\" Sở Nguyệt không vui nhìn Sở Chân.\n" +
            "\n" +
            "\"Người một nhà? Sở Nguyệt tỷ ngươi hẳn là biết, Sở Phong này căn bản không phải người Sở gia ta.\"\n" +
            "\n" +
            "\"Tiến nhập tông môn năm năm đều không thể thông qua nội môn khảo hạch, quả thực là sỉ nhục Sở gia ta.\"\n" +
            "\n" +
            "\"Toàn bộ Sở gia, có ai mà ưa thích hắn? Cũng chỉ có tỷ đối với hắn tốt như vậy, lại còn đưa Tiên linh thảo của tỷ cho hắn dùng.\" Sở Chân rất là không giải thích được.\n" +
            "\n" +
            "\"Ngươi thực sự là gian ngoan mất linh.\" Sở Nguyệt có chút tức giận, liếc mắt trừng hắn, rồi liền bỏ đi.\n" +
            "\n" +
            "Ngược lại Sở Chân đứng tại chỗ nở nụ cười, hắn rất là cao hứng, tuy rằng Tiên linh thảo của Sở Nguyệt hắn không lấy được, thế nhưng hắn biết, năm nay Tiên linh thảo của Sở Phong, nhất định là của hắn.\n" +
            "\n" +
            "Trời tối hoàn toàn, nơi ngoại môn đệ tử nghỉ ngơi, một mảnh đen kịt.\n" +
            "\n" +
            "Bận rộn suốt một ngày, tất cả mọi người rất uể oải, liền ngủ sớm, chỉ có gian phòng của Sở Phong, là còn đèn sáng.\n" +
            "\n" +
            "Hắn ngồi xếp bằng tại đầu giường, lấy ra Tiên linh thảo mà Sở Nguyệt tặng hắn, thấp giọng nói: \"Hi vọng cây Tiên linh thảo này, có thể khiến ngươi ăn no.\"\n" +
            "\n" +
            "Nói xong, Sở Phong nhắm hai mắt lại, đem Tiên linh thảo kẹp trong song chưởng, niết xuất một đạo pháp quyết kỳ lạ.\n" +
            "\n" +
            "Ngay lúc này, linh khí trong Tiên linh thảo, cũng là bắt đầu theo lòng bàn tay Sở Phong, chảy vào trong cơ thể, cuối cùng hội tụ tại trong đan điền.\n" +
            "\n" +
            "Cùng lúc đó, trong đan điền Sở Phong lại truyền đến âm thanh nhấm nuốt, phảng phất như con gì đó đang ăn vậy.\n" +
            "\n" +
            "Nếu là nhìn xuyên thấu qua da, liền có thể phát hiện, ở chỗ sâu trong đan điền Sở Phong, một đoàn lôi điện đang chiếm giữ.\n" +
            "\n" +
            "Đoàn lôi điện này chia làm cửu sắc, mỗi loại màu sắc đều làm như một con lôi đình cự thú, tản mát ra khí tức đáng sợ không thuộc về phiến thiên địa này." +
            "\n" +
            "Chương 2: MỸ NỮ TRƯỞNG LÃO." +
            "\n" +
            "Sở Phong cũng không phải là người của Sở gia, mà là nghĩa tử Sở gia lão ngũ \"Sở Uyên\" thu dưỡng.\n" +
            "\n" +
            "Điều này làm cho, Sở Phong từ nhỏ liền bị người xa lánh, nhận hết khi nhục, nếu không phải Sở Uyên cực lực che chở, hắn đã sớm bị đuổi ra khỏi Sở gia, vì thế Sở Phong đối với Sở Uyên cực kỳ cảm ơn, thề phải trở thành kiêu ngạo của Sở Uyên, vì ông làm ra vẻ vang.\n" +
            "\n" +
            "Năm năm trước Sở Phong, vừa vặn được mười tuổi, chính là độ tuổi tu võ tốt nhất.\n" +
            "\n" +
            "Khi đó hắn, đối với tu võ tràn ngập chờ mong, bởi vì hắn muốn chứng minh mình trong thời gian tới.\n" +
            "\n" +
            "Nhưng hắn trăm triệu lần nghĩ không ra, trước khi bái nhập Thanh Long Tông một tháng, một đạo thần lôi bổ trúng thân thể hắn, tiến nhập trong đan điền của hắn.\n" +
            "\n" +
            "Lúc đầu, Sở Phong cho rằng đây là một hồi tạo hóa, bởi vì khi hắn tu võ, tiến bộ rất thần tốc, chỉ ngắn ngủi hai tháng liền đạt được Linh Võ nhị trọng.\n" +
            "\n" +
            "Tốc độ như vậy vượt qua lẽ thường, thế cho nên Sở Phong không dám đem việc này nói cho bất luận kẻ nào biết, mà là ẩn tàng thực lực yên lặng tu luyện.\n" +
            "\n" +
            "Thế nhưng ngày vui ngắn chẳng tầy gang, giữa lúc Sở Phong cho rằng, hắn đã thành thiên tài tu võ, thì thân thể hắn lại xuất hiện biến hóa.\n" +
            "\n" +
            "Chính loại biến hóa này, dẫn đến tu vi hắn trì trệ không tiến, bị cho rằng là hạng người thiên phú cực kém.\n" +
            "\n" +
            "\"Ông.\"\n" +
            "\n" +
            "Lúc này tiên linh thảo trong tay Sở Phong, đang luyện hóa bị đan điền hắn hấp thu.\n" +
            "\n" +
            "Luyện hóa tốc độ rất nhanh, nhanh đến vượt qua lẽ thường, bình thường mà nói với thực lực Sở Phong, cây tiên linh thảo này... ít nhất... phải cần luyện hóa một tháng.\n" +
            "\n" +
            "Nhưng lúc này chỉ là chốc lát, đã bị luyện hóa hơn phân nửa, đồng thời đan điền Sở Phong dường như cái động không đáy, rốt cục cũng có loại cảm giác bị lấp đầy.\n" +
            "\n" +
            "\"Ông.\" Đột nhiên, trong tay Sở Phong nổi lên một đạo quang mang, nửa cây tiên linh thảo trong nháy mắt liền tiêu tán.\n" +
            "\n" +
            "Cùng lúc đó, trong đan điền Sở Phong, cũng là xảy ra biến hóa nghiêng trời lệch đất.\n" +
            "\n" +
            "Chín đạo lôi đình cự thú tương hỗ lẫn nhau, nhanh chóng bắt đầu khởi động, rồi lại ngưng tụ, cuối cùng hóa thành một khỏa đan dạng vật thể.\n" +
            "\n" +
            "Lúc đan này thành hình, linh khí cuồn cuộn không ngừng, tự trong đó chạy ra, như thủy triều vậy cọ rửa thân thể Sở Phong, rất nhanh liền thẩm thấu ra toàn thân.\n" +
            "\n" +
            "\"Bá.\"\n" +
            "\n" +
            "Sở Phong bỗng nhiên mở hai mắt, trong mắt lại có lôi quang nhè nhẹ, một loại vui sướng không có ngôn ngữ nào diễn tả được, đọng ở trên mặt.\n" +
            "\n" +
            "\"Thành công rồi, trọn vẹn năm năm, ta Sở Phong rốt cục cũng thành công.\" Sở Phong mừng như điên không gì sánh được, hắn bỗng nhiên từ trên đầu giường nhảy xuống, vừa đi qua lại trên mặt đất, vừa đánh giá thân thể của chính mình.\n" +
            "\n" +
            "Tu võ một đường, cảnh giới được phân biệt là:\n" +
            "\n" +
            "Linh Võ, Nguyên Võ, Huyền Võ, Thiên Võ tứ đại cảnh giới, từng cảnh giới lại phân ra cửu trọng.\n" +
            "\n" +
            "Linh Võ nhất trọng, chủ yếu là thông qua phương pháp đặc thù rèn đúc thân thể, từ đó tăng cường thực lực.\n" +
            "\n" +
            "Bất quá tới Linh Võ nhị trọng rồi, nhất định phải sử dụng pháp quyết ngưng tụ ra linh khí, chỉ có thành công đem linh khí ngưng tụ ở đan điền, mới chân chính bước vào con đường tu võ.\n" +
            "\n" +
            "Sở Phong vì thân thể biến hóa, nên vô pháp ngưng tụ linh khí, bởi vì thần lôi trong đan điền hắn, dường như chín con dã thú đói khát, Sở Phong ngưng tụ linh khí, đều bị thần lôi này thôn phệ.\n" +
            "\n" +
            "Nhưng hắn vẫn chưa nản lòng thoái chí, bởi vì hắn phát hiện, thần lôi mặc dù thôn phệ linh khí, nhưng cũng có một hạn độ, chỉ cần liên tục hướng đan điền quán thâu linh khí, sẽ có một ngày có thể đem nó lấp đầy.\n" +
            "\n" +
            "Mà hôm nay, hắn rốt cục thành công.\n" +
            "\n" +
            "\"Loại cảm giác này thật mạnh, cuồn cuộn không ngừng linh khí, đang ở trong cơ thể lao nhanh, phảng phất như muốn phá thể mà ra.\"\n" +
            "\n" +
            "Sở Phong cảm giác bất khả tư nghị, hắn nghĩ không ra thần lôi lại trực tiếp ngưng tụ thành đan, chiếm giữ trong đan điền, đồng thời thần lôi lại tản mát ra linh khí, phi thường nồng nặc, quả thực vượt quá tưởng tượng.\n" +
            "\n" +
            "Hắn biết, coi như là hắn trong năm năm nay, không ngủ không nghĩ luôn tu luyện, cũng không có khả năng ngưng tụ ra, linh khí cường đại như vậy, mà sở dĩ như thế, cũng chính bởi vì thần lôi này.\n" +
            "\n" +
            "\"Ông.\" Nhưng đúng lúc này, Sở Phong thân thể đột nhiên cứng đờ, thần tình cũng là đại biến.\n" +
            "\n" +
            "Thần lôi đang biến hóa, hắn lực lượng trong nháy mắt tăng trưởng mấy lần, cư nhiên lần thứ hai đột phá, bước vào Linh Võ tứ trọng.\n" +
            "\n" +
            "\"Khổ tận cam lai a?\"\n" +
            "\n" +
            "Sở Phong nắm chặt nắm tay, cảm thụ được trong cơ thể lực lượng bạo tạc, hắn nghĩ trong năm năm nay ăn nhiều đau khổ đều đáng giá.\n" +
            "\n" +
            "Liên tục đột phá lưỡng trọng, loại phương thức biến cường bất khả tư nghị này, rốt cục cũng đã trở về.\n" +
            "\n" +
            "Đột nhiên, hắn đem ánh mắt sắc bén, hướng phía nội môn, thấp giọng nói: \"Sở Chân, tiên linh thảo của ngươi ta nhất định lấy rồi.\"\n" +
            "\n" +
            "Thanh Long Tông tuyển nhận đệ tử, hàng năm chỉ có một lần, mỗi lần duy trì liên tục mười ngày.\n" +
            "\n" +
            "Mười ngày sau, hàng năm một lần nội môn khảo hạch cũng sẽ bắt đầu, mà lúc này đây, Sở Phong yên lặng đã năm năm, rốt cục cũng tham gia.\n" +
            "\n" +
            "Địa điểm khảo hạch, là một tòa địa cung khổng lồ, trong đại điện địa cung người ta tấp nập, khoảng chừng trên vạn người.\n" +
            "\n" +
            "Những người này đại thể đều là Linh Võ tam trọng, bởi vì tất cả mọi người cũng biết, nội môn khảo hạch chí ít phải Linh Võ tam trọng mới có thể thông qua.\n" +
            "\n" +
            "Bất quá cũng có một bộ phận đệ tử Linh Võ nhị trọng, muốn đến đục nước béo cò, người như vậy hàng năm đều có, nhưng đại thể đều đã thất bại.\n" +
            "\n" +
            "Đáng nhắc tới chính là, còn có một bộ phân nhỏ Linh Võ tứ trọng, bọn họ cũng không phải như vậy tu luyện trì độn tài trí bình thường, ngược lại cũng có ít người chính là thiên tài.\n" +
            "\n" +
            "Bọn họ là cố ý tại Linh Võ tứ trọng mới là lúc, tới tham gia tuyển trạch nội môn khảo hạch, về phần nguyên nhân, đây chính là vì tưởng thưởng.\n" +
            "\n" +
            "Linh Võ tam trọng, đã có thể tu luyện vũ kỹ.\n" +
            "\n" +
            "Vũ kỹ là một loại thủ đoạn công kích cường đại, không chỉ có thể đem thực lực phát huy vô cùng nhuần nhuyễn, lại càng có thể thu được lực lượng cực hạn siêu việt nhân thể.\n" +
            "\n" +
            "Nguyên nhân chính là như vậy, vũ kỹ phi thường trân quý, ngay cả hào môn thế gia cũng là không có, đây cũng là nguyên nhân vì sao các đại thế gia, cũng muốn đem hậu nhân đưa vào tông môn bồi dưỡng.\n" +
            "\n" +
            "Bởi vì trong từng tông môn, đều có đại lượng vũ kỹ của riêng mình, mà ở Thanh Long Tông đây, chỉ cần trở thành nội môn đệ tử, liền có thể tu luyện vũ kỹ.\n" +
            "\n" +
            "Chỉ có điều, vũ kỹ cũng có chia ra phẩm giai, từ nhược đến cường chia làm cửu đoạn.\n" +
            "\n" +
            "Ở bên trong nội môn, có thể tu luyện đến tốt nhất, cũng chỉ là tam đoạn vũ kỹ.\n" +
            "\n" +
            "Nhưng trong hàng năm một lần nội môn khảo hạch, người chiếm thứ nhất thông qua khảo hạch, lại có thể lấy được một quyển tứ đoạn vũ kỹ.\n" +
            "\n" +
            "Vì thế có một số người, tình nguyện tại ngoại môn tu luyện, cũng không chịu tiến nhập nội môn, chỉ là vì bản tứ đoạn vũ kỹ này.\n" +
            "\n" +
            "\"Mau nhìn, đây không phải là Dương Thiên Vũ sao?\"\n" +
            "\n" +
            "\"Oa, thật là hắn, năm ấy mười ba tuổi, đã đạt được Linh Võ tứ trọng, xem ra đệ nhất lần này khảo hạch, không phải hắn thì còn ai chứ.\"\n" +
            "\n" +
            "Trong biển người, một gã thiếu niên non nớt khiến cho mọi người chú ý, chuẫn xác mà nói là một gã nam hài.\n" +
            "\n" +
            "Ngoại môn đệ tử chừng hơn mười vạn, đại đa số là không có tiếng tăm gì, nhưng có ít người cũng là tiêu điểm để quan tâm, loại người như thế hơn phân nửa là thiên tài, mà Dương Thiên Vũ là một trong số đó.\n" +
            "\n" +
            "\"Vậy cũng chưa hẳn, hắn Dương Thiên Vũ tư chất cho dù tốt, nhưng thủy chung chỉ là một hài tử, rất khó đoạt được đệ nhất.\"\n" +
            "\n" +
            "\"Thanh Long Tông ngọa hổ tàng long, có đôi khi thiên tài vị tất địch nổi người tài trí bình thường, tỷ như vị Đoạn Vũ Hiên kia vậy.\" Một gã ngoại môn đệ tử, đưa tay chỉ về phía một gã thiếu niên lạnh lùng.\n" +
            "\n" +
            "Người này tên là Đoạn Vũ Hiên, tiến nhập Thanh Long Tông đã có sáu năm, vốn là hạng người không có tiếng tăm gì.\n" +
            "\n" +
            "Nhưng tại mấy tháng trước, hắn lại đánh bại một gã Linh Võ tứ trọng nội môn đệ tử, từ đó về sau thanh danh lan xa, thành nhân vật tiêu điểm ở ngoại môn.\n" +
            "\n" +
            "\"Im lặng.\" Đột nhiên, một đạo thanh âm vang dội vang lên.\n" +
            "\n" +
            "Đưa mắt nhìn lại, tất cả mọi người không khỏi sửng sốt, chỉ thấy tại đại điện trên đài cao, xuất hiện hơn mười đạo thân ảnh.\n" +
            "\n" +
            "Những người này phần lớn là tuổi già lão giả, chính là ngoại môn trưởng lão, thế nhưng vị dẫn đầu kia, không chỉ có cực kỳ trẻ tuổi, mà chính là một vị nữ tử xinh đẹp.\n" +
            "\n" +
            "Nữ tử mặc một bộ y phục đỏ bó sát người, đem những đường cong xinh đẹp đều lộ ra, nhất là dưới làn váy, cặp chân ngọc tuyết trắng thẳng tắp, có thể nói là hoàn mỹ.\n" +
            "\n" +
            "Nữ tử không chỉ có thân thể mê người, khuôn mặt càng quyến rũ đến cực điểm, mắt hạnh môi đỏ mọng mặt trái xoan, quả thực là một khuôn mặt tiêu chuẩn hồ ly.\n" +
            "\n" +
            "Mà nàng, đó là Thanh Long Tông đại danh đỉnh đỉnh mỹ nữ trưởng lão, Tô Nhu.\n" +
            "\n" +
            "Tô Nhu này, là nhân vật nỗi danh, mười tuổi bái nhập Thanh Long Tông, mười hai tuổi tiến nhập nội môn, mười lăm tuổi đã thành hạch tâm đệ tử.\n" +
            "\n" +
            "Tất cả mọi người đối với nàng xem trọng, nghĩ có hi vọng trở thành Thanh Long Tông đệ nhất đệ tử, nàng lại đột nhiên làm trưởng lão.\n" +
            "\n" +
            "Đối với biến cố này, cũng không ai biết được nội tình, đến nay vẫn là một cái mê cục, được mọi ngươi bàn luận say sưa.\n" +
            "\n" +
            "\"Oa, cư nhiên là Tô Nhu trưởng lão, nàng không phải là nội môn trưởng lão sao? Sao lại đi tới ngoại môn chứ?\" Tô Nhu vừa hiện thân, toàn bộ nam đệ tử đều há to miệng, một ít người thậm chí còn chảy ra nước bọt. Đọc Truyện Online mới nhất ở truyen/y/y/com\n" +
            "\n" +
            "Ngoại môn đệ tử, tuổi đều rất nhỏ, phần lớn đều là thiếu niên, có một số còn là hài tử, đối với bọn họ cái tuổi này mà nói, Tô Nhu nữ tử như vậy thành thục khêu gợi, là có sức hấp dẫn nhất.\n" +
            "\n" +
            "Tô Nhu cũng hoàn toàn không có sắm vai trưởng lão, mà là quay sang mọi người cười quyến rũ, ôn nhu nói:\n" +
            "\n" +
            "\"Khảo hạch quy tắc rất đơn giản, từ đại môn phía sau ta đi vào, rồi từ một cái đại môn khác đi ra, liền thông qua khảo hạch.\"\n" +
            "\n" +
            "\"Duy nhất khác nhau là, đệ nhất danh thông qua khảo hạch, có thể nhận được một bản tứ đoạn vũ kỹ, đây chính là ở trong nội môn cũng đều tu luyện không được.\"\n" +
            "\n" +
            "\"Bất quá đáng nhắc tới chính là, năm nay đệ nhất danh, còn được nhận thêm một kiện phần thưởng đặc thù khác.\"\n" +
            "\n" +
            "\"Từ ý nghĩa nào đó mà nói, cái phần thưởng này, thậm chí so với hai loại trước còn muốn trân quý hơn ~\" nói đến đây, Tô Nhu cố ý kéo dài ngữ điệu, cái loại khí tức mê hoặc này, tràn ngập cả tòa đại điện.\n" +
            "\n" +
            "\n" +
            "Chương 3: KHẢO HẠCH BẮT ĐẦU." +
            "\n" +
            "\"Đến tột cùng là cái gì?\" Có người hiếu kỳ hỏi.\n" +
            "\n" +
            "\"Lẽ nào Tô Nhu trưởng lão muốn hiến thân sao?\" Có người không biết xấu hổ, hiện ý nghĩ kỳ quái này trong đầu.\n" +
            "\n" +
            "Tô Nhu tuy là trưởng lão, nhưng chỉ có 20 tuổi, so với các lão ngoan đồng trong tông môn, nàng càng bình dị dễ gần gũi, nguyên nhân chính là như vậy, nên rất nhiều người mới không hề cố kỵ.\n" +
            "\n" +
            "Đối với mọi người đang suy đoán, Tô Nhu chỉ là quyến rũ cười, vươn năm ngón tay mảnh khảnh, nói: \"Năm cây tiên linh thảo.\"\n" +
            "\n" +
            "\"Cái gì? Năm cây tiên linh thảo?\"\n" +
            "\n" +
            "\"Ta không có nghe lầm chứ? Đúng là tiên linh thảo, chính là năm cây?\" Lời này vừa nói ra, đại điện một mảnh hỗn loạn, tất cả mọi người vô pháp bình tĩnh.\n" +
            "\n" +
            "Tiên linh thảo rất là trân quý, ngay cả Sở gia, hàng năm cũng chỉ có thể phụ cấp mỗi người một cây mà thôi.\n" +
            "\n" +
            "Đối với người thường mà nói, tiên linh thảo này càng là vật báu vô giá, thấy cũng chưa từng thấy qua.\n" +
            "\n" +
            "Lúc này Thanh Long Tông lại xuất ra năm cây, đây đối với ngoại môn đệ tử mà nói, mê hoặc rất là lớn.\n" +
            "\n" +
            "Chỉ bất quá đối với đại bộ phận người đến mà nói, cũng chỉ có thể ngẫm lại, bởi vì bọn họ cũng đều biết tiên linh thảo kia cùng bọn họ vô duyên.\n" +
            "\n" +
            "Ngược lại, các đệ tử có mục tiêu đệ nhất, cả đám kích động, lại càng thêm kích động hơn.\n" +
            "\n" +
            "Thấy các đệ tử khí thế như vậy tăng vọt, Tô Nhu cũng là thoả mãn gật đầu, sau đó tay ngọc vung lên.\n" +
            "\n" +
            "Ở phía sau liền truyền ra \"Ầm ầm \" tiếng vang, đại môn cao tới mấy trượng, đang từ từ chậm rãi mở ra.\n" +
            "\n" +
            "\"Còn chờ cái gì nữa? Không muốn thông qua khảo hạch sao?\" Nhìn chúng đệ tử dại ra, Tô Nhu thản nhiên cười.\n" +
            "\n" +
            "\"Xông lên a ~~~~ \"\n" +
            "\n" +
            "Trong lúc nhất thời, từng trận hoan hô vang lên không ngừng, trên vạn danh ngoại môn đệ tử, như ngựa hoang thoát cương vậy, hướng phía đại môn phóng đi.\n" +
            "\n" +
            "Sở Phong cũng theo dòng người, một đường tiến về phía trước, cuối cùng tiến nhập trong một hang động thật sâu.\n" +
            "\n" +
            "Nham động này rất rộng, nhưng cũng rất tối tăm, nhìn thấy cũng không xa, mọi người đều biết có ẩn dấu nguy hiểm, tùy thời có thể phủ xuống.\n" +
            "\n" +
            "\"Xông lên a, vì tứ đoạn vũ kỹ, vì năm cây tiên thảo, xông lên ~~~ \"\n" +
            "\n" +
            "Nhưng mà cũng có ít người, vì tiền mà liều mạng, biết rõ có nguy hiểm, nhưng cứ lao lên đi đầu, đồng thời người như thế còn không phải là số ít.\n" +
            "\n" +
            "\"Bá bá bá\"\n" +
            "\n" +
            "Nhưng vừa đi tới được trăm mét, từng trận âm thanh xé gió liền tự phía trước truyền đến, vô số ngân châm từ trong nham bích phát ra, dường như mưa xối xả bắn về phía đoàn người.\n" +
            "\n" +
            "\"A ~~~~~~ \"\n" +
            "\n" +
            "\"Ô oa ~~~~ \"\n" +
            "\n" +
            "Trong lúc đó, các loại tiếng kêu thảm thiết vang vọng một mảnh, đệ tử xông vào phía trước bất ngờ không phòng bị, nên ngã xuống hơn phân nửa.\n" +
            "\n" +
            "Dù là như vậy, mọi người cũng vẫn như trước, không có chút lùi bước, liều mạng cuồn cuộn đi vào ở chỗ sâu trong huyệt động.\n" +
            "\n" +
            "Bởi vì bọn họ biết, ngân châm này tuy rằng lợi hại, nhưng sẽ không trí mạng, dù sao cũng là cơ quan, đối với Linh Võ tam trọng mà nói, chỉ cần cẩn thận một chút, là hoàn toàn có thể tránh né.\n" +
            "\n" +
            "Càng đi vào sâu, số lượng ngân châm cũng là càng ngày càng dày đặc, đồng thời thường xuyên có khiến mọi người trở tay không kịp.\n" +
            "\n" +
            "Dưới tình huống như vậy, đoàn người rất nhanh kéo ra khoảng cách, chạy nhanh phía trước không phải là hạng người đục nước béo cò, mà là Dương Thiên Vũ, Đoạn Vũ Hiên mấy cao thủ.\n" +
            "\n" +
            "Không thể không nói, Dương Thiên Vũ cùng Đoạn Vũ Hiên mấy người, đích xác là bất phàm.\n" +
            "\n" +
            "Người khác tại dưới cơn mưa ngân châm xối xả bước đi, rất là cẫn thận.\n" +
            "\n" +
            "Nhưng bọn hắn lại như giẫm trên đất bằng, đâu phải là xông vào cơ quan trận, mà là như mấy người đang thi chạy vậy.\n" +
            "\n" +
            "Sở Phong vẫn đi theo phía sau bọn họ, theo sau trong đại quân Linh Võ tam trọng, làm như vậy là có hai cái nguyên nhân.\n" +
            "\n" +
            "Thứ nhất, hắn không muốn làm chim đầu đàn.\n" +
            "\n" +
            "Thứ hai, tình huống của hắn rất đặc thù, còn không muốn bại lộ thực lực quá sớm.\n" +
            "\n" +
            "Cho nên hắn đang chờ đợi một thời cơ, một khi tất cả mọi người nhìn không thấy, nhưng hắn lại có thể siêu việt vượt qua mọi người.\n" +
            "\n" +
            "\"Đoạn Vũ Hiên, uổng cho ngươi tuổi lớn như vậy, lại chạy không qua ta một hài tử, ngươi không cảm thấy mất mặt sao?\"\n" +
            "\n" +
            "\"Hanh, tiểu tử xấu xa, tu võ một đường, không luận tuổi tác chỉ nói thực lực, muốn nói mạnh miệng, trước phải thắng ta cái đã.\"\n" +
            "\n" +
            "Trãi qua một đoạn thời gian chạy qua, đội ngũ phía trước, chỉ còn lại có hai đạo thân ảnh, đó là Đoạn Vũ Hiên cùng Dương Thiên Vũ.\n" +
            "\n" +
            "Mà hai người này đều là Linh Võ tứ trọng, một người thiên tư trác việt, một người kinh nghiệm lão đạo, hai người chẳng phân biệt được trên dưới.\n" +
            "\n" +
            "Bởi vì bọn họ biết, đối thủ cạnh tranh lớn nhất chính là đối phương, chỉ cần thắng đối phương, phần thưởng đệ nhất, liền đều là đến tay.\n" +
            "\n" +
            "\"Hô ~.\" Đột nhiên, từng trận tiếng gió từ phía trước truyền đến.\n" +
            "\n" +
            "Đưa mắt nhìn, hai người đều là kinh hãi, không khỏi chậm lại bước chân, bởi vì phía trước, lại xuất hiện nồng nặc sương mù.\n" +
            "\n" +
            "Nham động này vốn là hôn ám, hơn nữa có sương mù, tầm nhìn càng kém, đây cũng là bộ phận cơ quan then chốt gia tăng độ khó tránh né, cho dù là bọn họ hai người, cũng phải cẩn thận.\n" +
            "\n" +
            "\"Cơ hội tốt.\"\n" +
            "\n" +
            "Đây có thể là lúc mọi người lùi bước, Sở Phong lại mừng thầm, hắn đi nhanh về phía trước một bước, chỉ nghe sưu một tiếng, cả người như rời dây cung tiến về phía trước chạy vội đi.\n" +
            "\n" +
            "\"Bá.\"\n" +
            "\n" +
            "Lúc này Đoạn Vũ Hiên đang chuyên tâm tránh né ngân châm, một đạo bóng đen ở bên cạnh chợt lóe mà qua, còn không đợi hắn phản ứng, người nọ đã biến mất không thấy.\n" +
            "\n" +
            "\"Chẳng lẽ là ảo giác?\"\n" +
            "\n" +
            "Như vậy một màn, khiến Đoạn Vũ Hiên cảm thấy giật mình, lúc đầu còn tưởng là Dương Thiên Vũ, thế nhưng khi phát hiện Dương Thiên Vũ ở cách đó không xa, hắn lại trở nên hoảng hốt.\n" +
            "\n" +
            "Thành công bỏ qua mọi người, Sở Phong cũng không có lo lắng, hắn đem tốc độ nâng lên cực hạn.\n" +
            "\n" +
            "Trãi qua thời gian dài chạy trốn, hắn không có chút nào kiệt lực, trong cơ thể linh khí dường như là bất tận, cuồn cuộn không ngừng tự trong đan điền tràn ra.\n" +
            "\n" +
            "Không chỉ có như vậy, hắn tốc độ cùng lực đạo, thính giác cùng thị lực cũng đều viễn siêu hơn người tu vi ngang nhau, chí ít phải xa xa mạnh hơn Đoạn Vũ Hiên cùng Dương Thiên Vũ.\n" +
            "\n" +
            "Đối với loại này biến hóa, Sở Phong cũng không có nhiều lắm kinh ngạc, bởi vì... này chính là chỗ đặc thù của hắn.\n" +
            "\n" +
            "Loại này đặc thù, hắn năm năm trước cũng đã gặp qua, mà hôm nay loại đặc thù này trở về, khiến hắn có tự tin cường đại không gì sánh được, bởi vì tại trước mặt hắn, đã không ai có thể tự xưng là thiên tài.\n" +
            "\n" +
            "Một đường chạy nhanh, Sở Phong rốt cục xuyên qua cơ quan trận, đi ra nham động thâm thúy hôn ám, đi tới trong một tòa đại điện rộng lớn\n" +
            "\n" +
            "Mà ở đại điện nơi cuối cùng, có một tòa đài cao bằng đá, trên đài cao bày vài món vật phẩm, chính là tứ đoạn vũ kỹ, cùng năm cây tiên linh thảo.\n" +
            "\n" +
            "Thấy được mấy thứ này, Sở Phong có chút kích động, bất quá hắn cũng không có vội vã đi đến phía trước, mà là nhìn về phía đại điện hai bên mấy đạo cửa đá.\n" +
            "\n" +
            "\"Ở phía sau, là mãnh thú trong truyền thuyết sao?\" Sở Phong khóe miệng nhấc lên vẽ chờ mong.\n" +
            "\n" +
            "Hắn biết, trận khảo hạch này vừa mới bắt đầu, hắn sắp sửa đối mặt, là một loại thị huyết thành tính, sinh vật đáng sợ tàn nhẫn đến cực điểm, tên là mãnh thú.\n" +
            "\n" +
            "\"Tô Nhu trưởng lão mau đến xem, khiến kẻ khác giật mình rồi.\"\n" +
            "\n" +
            "\"Ta trấn thủ nơi này nhiều năm rồi, đây là lần đầu tiên nhìn thấy, đệ tử có thể dùng tốc độ như vậy thông quan.\"\n" +
            "\n" +
            "Địa cung trong một tòa thạch thất bí ẩn, một gã trưởng lão tuổi già, đang nhìn chằm chằm đám thạch tử thác loạn, trong ánh mắt tràn ngập khiếp sợ.\n" +
            "\n" +
            "Đây cũng không phải thạch tử bình thường, mà là cơ quan trong địa cung, chỉ có cơ quan bị đụng vào, thạch tử mới có thể thác loạn.\n" +
            "\n" +
            "Mà lúc này, những thạch tử thác loạn, liền nói rõ một việc, là đã có người thông qua cơ quan trận. Bạn đang đọc chuyện tại Truyện.YY\n" +
            "\n" +
            "Năm rồi khảo hạch, người nhanh nhất thông qua cơ quan cũng phải một canh giờ, thế nhưng lúc này, lại chỉ qua nửa canh giờ mà thôi.\n" +
            "\n" +
            "Biến cố này, khiến cho mọi người chú ý, trong thạch thất hơn mười người trưởng lão, tất cả đều tụ tập đến, đều là cảm thấy giật mình.\n" +
            "\n" +
            "\"Xem ra lần này ngoại môn trong hàng đệ tử, thật ra có nhân vật thú vị nha.\"\n" +
            "\n" +
            "Tô Nhu cũng bu lại, nàng xem toàn bộ thạch tử thác loạn, thoả mãn gật đầu: \"Đã như vậy, cũng sẽ không để hắn dễ dàng thông qua, để ta cho... hắn thêm chút lạc thú.\"\n" +
            "\n" +
            "Trong lúc nói, nàng đem ánh mắt ném về phía trên thạch tử, nơi đó có ba khối tảng đá hình tròn, khảm trong thạch bích.\n" +
            "\n" +
            "Đột nhiên, nàng quỷ dị cười, hướng ba khối thạch đầu \"Ba ba ba\" liền vỗ xuống phía dưới.\n" +
            "\n" +
            "\"Không nên đụng.\" Thấy thế, trưởng lão ở đây đều là kinh hãi.\n" +
            "\n" +
            "Nhưng mà đã trễ, lúc này ba khối thạch đầu đều bị Tô Nhu đè xuống.\n" +
            "\n" +
            "\"Làm sao vậy? Không phải ngươi nói cho ta biết, tảng đá này có thể phóng xuất mãnh thú sao?\" Nhìn các vị trưởng lão thần tình kinh hoảng, Tô Nhu cũng ý thức được có chút sai.\n" +
            "\n" +
            "\"Ba khối thạch đầu này đích xác có thể thả ra mãnh thú, nhưng không thể đồng thời kích khởi.\"\n" +
            "\n" +
            "\"Nếu là đồng thời kích khởi mà nói, sẽ đem toàn bộ mãnh thú giam giữ, toàn bộ thả ra.\"\n" +
            "\n" +
            "\"Đây là ba mươi con nhị giai mãnh thú, chín con tam giai mãnh thú, cùng một con tứ giai mãnh thú a.\" Nói ra lời này, Lý trưởng lão khuôn mặt đã tái nhợt, mà ngay cả thanh âm cũng có chút run run.\n" +
            "\n" +
            "Nhiều năm thủ ở chỗ này, hắn đối với mãnh thú vô cùng hiểu rỏ.\n" +
            "\n" +
            "Đó là quái vật hung tàn đáng sợ, cường đại hơn xa so với tu võ giả đồng trình tự.\n" +
            "\n" +
            "Lúc này, nhiều như vậy mãnh thú đồng thời phóng xuất, sẽ một hồi giết chóc vô pháp tránh khỏi.\n" +
            "\n" +
            "Chỉ cần nghĩ đến, lúc này trong địa cung trên vạn danh đệ tử, sẽ bị mãnh thú tàn sát, hắn quả thực là không dám suy nghĩ tiếp.\n" +
            "\n" +
            "\"Ngươi thế nào không sớm nhắc nhở ta.\"\n" +
            "\n" +
            "Giờ khắc này, Tô Nhu sắc mặt cũng là đại biến, nàng thân thể mềm mại búng lên, liền hóa thành một đạo tật phong, đồng thời cửa đá mở ra, nàng đã biến mất không thấy.\n" +
            "\n" +
            "\"Lý trưởng lão, nên làm cái gì bây giờ?\" Ánh mắt mọi người, đều ngưng tụ ở tại trên người vị trưởng lão tuổi già này.\n" +
            "\n" +
            "\"Còn có thể làm gì bây giờ, còn không mau đi cứu viện.\" Lý trưởng lão nộ quát một tiếng, liền xông ra ngoài.','https://medoctruyenchu.com/app/manga/uploads/covers/d892389c2c57a7ee73ebf68934bfbcac.jpg',1)";
    private String SQLQuery12 = "INSERT INTO truyen VALUES (null,'VÔ THƯỢNG SÁT THẦN','Chương 1: Tiêu Phàm Trọng Sinh\n" +
            "\n" +
            "\n" +
            "Chiến Hồn Đại Lục lấy thực lực vi tôn, chỉ có người nắm giữ Chiến Hồn mới có thể bước vào con đường tu luyện, bằng không vĩnh viễn chỉ có thể làm một người bình thường, đồng thời mức độ mạnh yếu của Chiến Hồn cũng đại biểu cho\n" +
            "\n" +
            "tu sĩ đó có thể tiến bao xa.\n" +
            "\n" +
            "Chiến Hồn tổng cộng chia làm Cửu Phẩm, Nhất Phẩm yếu nhất - Cửu Phẩm mạnh nhất, lấy Yêu Thú, Khí Vật, Thực Vật làm chủ. Về phần người nắm giữ Hỏa Diễm, Lôi Điện các loại Chiến Hồn đặc thù thì cơ bản chính làTuyệt Thế Thiên Tài ngàn năm khó gặp!\n" +
            "\n" +
            "Tiêu Thành, Tiêu gia phủ đệ!\n" +
            "\n" +
            "Tiêu Phàm chậm rãi mở mắt ra, nhìn chằm chằm những bóng người lạ lẫm mà quen thuộc trước mắt, trên mặt một vẻ mờ mịt, mình rõ ràng đang ở nhà a làm sao lại xuất hiện ở nơi này?\n" +
            "\n" +
            "\"Phế vật chính là phế vật, đây đã là lần thứ chín thức tỉnh Chiến Hồn rồi vậy mà mém chút đem bản thân giết chết! Hơn nữa còn bị Chiến Hồn Điện chủ động đá ra. Việc này đúng là lần đầu tiên được nhìn thấy, quả nhiên không hổ là Tiêu Thành đệ nhất phế!\"\n" +
            "\n" +
            "\"Đâu chỉ Tiêu Thành đệ nhất phế mà còn là đệ nhất ngốc, ngay cả một chút giác ngộ cũng không có, bất luận kẻ nào đều chỉ có ba lần cơ hội thức tỉnh Chiến Hồn, điểm thường thức ấy cũng không biết, cho dù chết cũng đáng đời!\"\n" +
            "\n" +
            "Tiêu Phàm nhìn thấy bóng người đứng bốn phía chỉ trỏ không khỏi nhíu mày, trong đầu vô số tin tức tràn vào, hắn trong nháy mắt hiểu rõ bản thân vậy mà trọng sinh vào trên người một thiếu niên trùng tên trùng họ: Tiêu Phàm.\n" +
            "\n" +
            "Nguyên bản Tiêu Phàm là thanh niên tốt thế kỷ 21ở Địa Cầu, hai mươi mấy tuổi dựa vào y thuật do tổ tiên truyền xuống đã trở thành y học thánh thủ số một số hai tại Hoa Hạ. Hắn có hai cái sở thích: thứ nhất là cất giữ một chút đồ vật cổ quái kỳ lạ, thứ hai chính là nghiên cứu y thuật.\n" +
            "\n" +
            "Hắn vừa tình cờ mang về một khỏa Thạch Đầu(cục đá) kỳ dị, lúc ấy trời trong vạn dặm lại vang lên tiếng sấm quỷ dị, nói đến quả thật trùng hợp, một tia sét kia vừa vặn bổ trúng đầu hắn.\n" +
            "\n" +
            "Lúc hắn tỉnh lại đã trọng sinh ở trên người thiếu niên Tiêu Phàm này, việc này mặc dù có chút cẩu huyết nhưng Tiêu Phàm lại không thể không thừa nhận, sự tình đã trải qua không thể nào thay đổi.\n" +
            "\n" +
            "Tiêu Phàm chính là phế vật của Tiêu gia danh phù kỳ thực(người giống như tên), bắt đầu từ lúc thức tỉnh Chiến Hồn năm bảy tuổi cho đến hiện tại đã qua chín năm, vậy mà không thành công lần nào.\n" +
            "\n" +
            "Lần này Tiêu Phàm thức tỉnh Chiến Hồn lần thứ chín, tiến vào Chiến Hồn Điện lại ngoài ý muốn chết ở bên trong, nhờ thế hắn mới có cơ hội phụ thể trọng sinh.\n" +
            "\n" +
            "Đang lúc Tiêu Phàm chuẩn bị đứng dậy, đột nhiên cảm giác trong đan điền phát ra một cỗ Hồn Lực bàng bạc xông vào bên trong kinh mạch, Tiêu Phàm đột nhiên cảm giác toàn thân tràn ngập lực lượng, tựa như đột phá một loại\n" +
            "\n" +
            "trói buộc nào đó.\n" +
            "\n" +
            "Ánh mắt Tiêu Phàm có chút ngốc trệ, kinh ngạc vô cùng, bên trong đan điền có một đạo hắc sắc hư ảnh, cảm giác giống như u linh, Tiêu Phàm biết rõ đây chính là Chiến Hồn mà hắn thức tỉnh.\n" +
            "\n" +
            "\"Về sau gọi ngươi là U Linh Chiến Hồn a!\" Tiêu Phàm trong lòng lắp bắp nói.\n" +
            "\n" +
            "Trong lúc lơ đãng, một đạo bạch quang lóe qua, tâm thần Tiêu Phàm lại rơi vào chỗ sâu trong đan điền có một viên đá màu trắng đang trôi nổi, viên đá màu trắng tản ra một cỗ khí tức thần bí, tựa như ngay cả Thần Hồn đều sẽ bị hút vào trong đó.\n" +
            "\n" +
            "Tiêu Phàm trong lòng kinh ngạc không thôi, thiếu chút nữa thì hô lên: \"Cái này không phải là viên Thạch Đầu kỳ dị trước đó hay sao?\"\n" +
            "\n" +
            "\"Tam Thiếu Gia đừng ở nơi đây tự làm mất mặt nữa, đi về đi.\" Đúng lúc này có một người áo đen tách đám người ra hướng về Tiêu Phàm đi tới, trong mắt đều là khinh miệt cùng xem thường.\n" +
            "\n" +
            "Tiêu Phàm lạnh lùng nhìn hắc y lão giả, liếc mắt liền nhận ra hắn, hắn chính là tên quản gia một mực phụ trách sinh hoạt thường ngày của Tiêu Phàm: Tiêu Trung.\n" +
            "\n" +
            "\"Đồ phế vật, còn không đi?\" Thấy Tiêu Phàm không để ý tới hắn, thần sắc trong mắt Tiêu Trung càng ngày càng băng lãnh, ngay cả xưng hô Tam Thiếu Gia đều không gọi, trong lòng nổi giận mắng: \"Thực không biết vì sao Tộc Trưởng đại nhân lại chiếu cố tên phế vật này như thế, tên này quả thất là sống chật chỗ chết chật đất.\"\n" +
            "\n" +
            "\"Ngươi nói cái gì? Lặp lại lần nữa!\" Tiêu Phàm thu liễm tâm thần, chậm rãi đứng dậy, con ngươi vô cùng băng lãnh, bản thân cỗ thân thể này mặc dù bị kêu là đồ bỏ đi suốt chín năm, nhưng tốt xấu vẫn là Thiếu Chủ của Tiêu gia, tôn tử của Tộc Trưởng Tiêu gia, há có thể để một tên hạ nhân nhục mạ?\n" +
            "\n" +
            "Hơn nữa, kiếp trước hắn vốn chính là một người cực kỳ cường thế, bằng không cũng không có khả năng một mình một tay dựng nên cơ nghiệp, ai nhìn thấy hắn cũng đều cung cung kính kính, lão bất tử này vậy mà vô lễ với hắn như thế, hắn không giận mới là lạ\n" +
            "\n" +
            "\"Ta nói ngươi là phế vật!\" Tiêu Trung cơ hồ gằn từng chữ một, mảy may không đem tam thiếu hắn để trong mắt, một tên phế vật không cách nào thức tỉnh Chiến Hồn, trong gia tộc căn bản không có bất kỳ cái gì địa vị gì.\n" +
            "\n" +
            "\"Ba!\"\n" +
            "\n" +
            "Vừa dứt lời, một đạo thanh âm thanh thúy vang lên, Trên mặt Tiêu Trung xuất hiện năm dấu tay màu đỏ rực rõ ràng.\n" +
            "\n" +
            "Một tát này không chỉ đem Tiêu Trung đánh cho hồ đồ mà còn đem những người khác dọa cho thất điên bát đảo, hiện tại tên phế vật này cũng dám động thủ với quản gia?\n" +
            "\n" +
            "Quan trọng là tốc độ của Tiêu Phàm vừa rồi đều làm cho bọn hắn nhìn trân trối! Tiêu Trung dù sao cũng là Chiến Linh trung kỳ, hắn lại bị một tên ngay cả Chiến Hồn đều chưa thức tỉnh tát cho một cái.\n" +
            "\n" +
            "Chẳng biết tại sao trong lòng mọi người đều dâng lên hàn ý, ánh mắt Tiêu Phàm vừa rồi làm tim bọn hắn đập nhanh một trận, hắn như hoàn toàn trở thành một người khác vậy!\n" +
            "\n" +
            "\"Chiến Hồn thức tỉnh, U Linh Chiến Hồn làm cho ta trong nháy mắt đột phá đến Chiến Linh trung kỳ, tên này trong thời gian chín năm mặc dù được xưng là phế vật nhưng vẫn kiên trì tu luyện, sức mạnh và tốc độ của cổ thân thể này rất nhanh đã thích ứng được với năng lực Chiến Linh trung kỳ!\" Tiêu Phàm trong lòng cũng rất kinh ngạc, tốc độ vừa mới bộc phát rõ ràng so với Chiến Linh trung kỳ bình thường nhanh hơn rất nhiều, khó trách Tiêu Trung cũng không kịp chuẩn bị.\n" +
            "\n" +
            "\"Làm nô tài phải có bộ dáng của nô tài, chủ tử đánh ngươi một cái, trong lòng ngươi nên cảm kích mới phải.\" Tiêu Phàm lạnh lùng trừng Tiêu Trung, hắn chuẩn bị phất tay áo đi.\n" +
            "\n" +
            "\"Đứng lại!\" Tiêu Trung phẫn nộ kêu lên, \"Ngươi cài đồ con hoang này, phế vật đi không ai nuôi, ngươi dám đánh ta? Ngươi biết ta là ai không?\"\n" +
            "\n" +
            "Tiêu Phàm không nói, từng bước một đi về hướng Tiêu Trung, con ngươi đen kịt vô cùng băng lãnh, kiếp trước thân nhân hắn mất sớm, một kiếp\n" +
            "\n" +
            "này hắn vẫn không có gặp qua cha mẹ mình. Lời nói của Tiêu Trung không thể nghi ngờ đã động đến nỗi đau trong lòng của Tiêu Phàm, cũng làm lửa giận trong lòng hắn nổi lên.\n" +
            "\n" +
            "Tiêu Trung nhìn thấy con ngươi đen kịt của Tiêu Phàm đang bộc phát khí thế, trong lòng sợ hãi tới cực điểm, ánh mắt đáng sợ kia của Tiêu Phàm giờ phút này nào giống một kẻ phế nhân.\n" +
            "\n" +
            "\"Ngươi bất quá là một tên phế nhân, lẽ nào ta còn sợ ngươi sao?\" Tiêu Trung lấy dũng khí, sau lưng hắn đột nhiên hiện lên hư ảnh một đầu Hắc Lang đang há to cái miệng như chậu máu cắn tới hướng Tiêu Phàm.\n" +
            "\n" +
            "\"Nhất Phẩm Chiến Hồn Hắc Phong Lang?\" Tiêu Phàm trong mắt lóe lên vẻ dữ tợn, ý nghĩ hơi động, sau lưng đột nhiên hiện ra một đạo hư ảnh đen kịt, một cỗ hàn khí cuồng bạo xuất ra.\n" +
            "\n" +
            "Trong chớp mắt, Tiêu Phàm cảm giác lực lượng toàn thân tăng vọt, trong lòng kinh ngạc, mức độ cường đại của U Linh Chiến Hồn vượt qua hắn dự liệu, Tinh Khí Thần của hắn trong nháy mắt tăng đến cực hạn, cho dù Chiến Linh hậu kỳ, thậm chí Chiến Linh đỉnh phong giờ phút này Tiêu Phàm cũng dám chiến một trận.\n" +
            "\n" +
            "U Linh Chiến Hồn ngưng tụ thành một cái lợi trảo to lớn hướng về Hắc Phong Lang gào thét đến, móng vuốt sắc bén dị thường, Hư ảnh Hắc Lang đột nhiên tan vỡ hóa thành một trận hắc vụ tiêu tán trong hư không.\n" +
            "\n" +
            "Tiêu Trung hét thảm một tiếng, máu tươi trong miệng phun ra, sắc mặt trắng bệch, trong nháy mắt ngã xuống đất bất tỉnh nhân sự.\n" +
            "\n" +
            "\"Chiến, Chiến Hồn?\" Đám người kinh hãi nhìn bóng đen sau lưng Tiêu Phàm, da đầu có chút tê dại, tên này không phải phế vật sao? Làm sao có thể thức tỉnh Chiến Hồn cường đại như thế!\n" +
            "\n" +
            "Tiêu Phàm lạnh lùng liếc mắt nhìn Tiêu Trung, khinh thường nói: \"Ta biết ngươi là ai, không phải là một con chó sao? D(ộng một cái liền cắn Chủ tử, lưu ngươi lại làm gì!\"\n" +
            "\n" +
            "\"Hắn là một con chó, nhưng cũng là chó của Tiêu Thiên ta, đánh chó còn phải nhìn mặt chủ nhân, chó của ta khi nào đến phiên phế vật ngươi đến giáo huấn?\" Đột nhiên từ phía sau đám người truyền đến một đạo âm thanh." +
            "\n" +
            "Chương 2: Liên Tiếp Đột Phá" +
            "\n" +
            "Đám người vừa nghe đến cái tên Tiêu Thiên này đều lộ ra vẻ kính sợ, tự giác tách ra một con đường, chỉ thấy một người nam tử mặc bạch sắc cừu bào đi thẳng tới.\n" +
            "\n" +
            "Hắn mặt một bộ áo bào màu trắng mày kiếm mắt sáng, mặt như ngọc quan, tư thế hiên ngang, trong tay quạt xếp nhẹ nhàng vũ động càng là làm nổi bật lên khí chất siêu phàm thoát tục!\n" +
            "\n" +
            "Người tới chính là Tiêu gia đại thiếu gia: Tiêu Thiên, cũng là đệ nhất thiên tài Tiêu gia hiện tại, nắm trong tay Tứ Phẩm Chiến Hồn Truy Phong Lang, hắn hiện tại 18 tuổi đã là cảnh giới Chiến Sĩ hậu kỳ. Trong thế hệ trẻ cùng tuổi bên trong Tiêu Thành cơ hồ không có địch thủ.\n" +
            "\n" +
            "Cảnh giới tu luyện của Chiến Hồn Đại Lục từ thấp đến cao được chia thành: Chiến Linh, Chiến Sĩ, Chiến Sư, Chiến Tôn, Chiến Tông, Chiến Vương, Chiến Hoàng, Chiến Đế, Chiến Thánh các loại, về phần Chiến Thần cơ hồ chỉ còn tồn tại trong truyền thuyết, Chiến Hồn Đại Lục rất nhiều năm qua chưa từng nghe nói qua.\n" +
            "\n" +
            "Trong đó mỗi một cảnh giới lại phân làm tiền kỳ, trung kỳ, hậu kỳ cùng đỉnh phong bốn tiểu cảnh giới.\n" +
            "\n" +
            "Toàn bộ Tiêu Thành, Chiến Tôn cũng chỉ có thể đếm được trên đầu ngón tay, về phần Chiến Tông, trừ phi nắm giữ Ngũ Phẩm Chiến Hồn, bằng không liền không có khả năng trở thành Chiến Tông!\n" +
            "\n" +
            "Cũng khó trách Tiêu Thiên ngạo khí như thế, Tiêu Thành chỉ là một tòa thành nhỏ ở biên hoang, mạnh nhất cũng chỉ là Tứ Phẩm Chiến Hồn, người nắm giữ Tứ Phẩm Chiến Hồn trong Tiêu Gia đều cực kỳ thưa thớt, mà Tiêu Thiên chính là trong những người ít ỏi đó, hắn chỉ cần không vẫn lạc liền có thể trở thành cường giả Chiến Tôn.\n" +
            "\n" +
            "Thậm chí có tin đồn Tiêu Thiên trong tương lai chính là Tiêu gia Gia Chủ!\n" +
            "\n" +
            "\"Đại thiếu gia, ngài nhất định phải thay tiểu nhân làm chủ a, tiểu nhân là chó của ngài làm sao có thể để ngoại nhân khi dễ?\" Nhìn thấy Tiêu Thiên đến, Tiêu Trung đột nhiên tỉnh lại, ôm đùi Tiêu Thiên bắt đầu khóc rống lên.\n" +
            "\n" +
            "Tiêu Phàm lạnh lùng liếc mắt nhìn Tiêu Trung, tên gia hỏa vừa rồi lại giả chết, vả lại giả vô cùng giống, bây giờ lại còn làm ác nhân cáo trạng trước, Tiêu Phàm tự nhiên cũng không khách khí trừng mắt lạnh lùng nói: \"Quản tốt chó của ngươi, không nên thả ra để nó tùy tiện cắn người.\"\n" +
            "\n" +
            "Dứt lời, Tiêu Phàm quay người rời đi, hắn đối với Chiến Hồn của Chiến Hồn Đại Lục cảm thấy cực kỳ hứng thú, hắn muốn biết tình trạng hiện tại trong cơ thể của mình.\n" +
            "\n" +
            "Hơn nữa hắn vừa mới thức tỉnh Chiến Hồn chỉ là Chiến Linh trung kỳ, Tiêu Thiên lại là Tiêu gia đệ nhất thiên tài, sớm đã là Chiến Sĩ hậu kỳ, hắn sẽ không ngốc đến mứứng đối cứng cùng Tiêu Thiên!\n" +
            "\n" +
            "\"Ta cho ngươi rời đi sao?\" Tiêu Thiên lạnh lùng một tiếng, lách mình chặn trước người Tiêu Phàm, trên mặt lộ ra nụ cười đầy thâm ý.\n" +
            "\n" +
            "\"Chó khôn không cản đường.\" Tiêu Phàm biết rõ tên này hôm nay chắc chắn sẽ không từ bỏ ý đồ, đã như vậy thì liền cường thế đối mặt.\n" +
            "\n" +
            "Ầm! Vừa dứt lời, Tiêu Phàm cảm giác cảm giác hổ khẩu một trận đau nhức, không đợi hắn phản ứng một cái nắm đấm trùng điệp nện lên bộ ngực hắn, ngũ tạng lục phủ chấn động phun ra một ngụm máu tươi.\n" +
            "\n" +
            "Thân hình hắn lui lại mấy bước, quỳ một chân xuống đất, hai mắt đỏ bừng, khóe miệng máu tươi không ngừng chảy, gân xanh trên trán như là tiểu trùng ngo ngoe.\n" +
            "\n" +
            "\"Tiểu tạp chủng, ngươi dám mắng ta là chó!\" Con ngươi Tiêu Thiên vô cùng băng lãnh, ánh mắt lóe sát khí.\n" +
            "\n" +
            "Tiêu Phàm che ngực gian nan đứng dậy, hắn rốt cuộc biết Chiến Linh trung kỳ chênh lệch với Chiến Sĩ hậu kỳ, khác biệt như trời với đất, hắn thậm ch còn không thấy Tiêu Thi xuất thủ thế nào.\n" +
            "\n" +
            "\" Tiêu Thiên ngươi cũng là dựa vào cảnh giới để đè người, nếu là cùng cùng giai, ta giết ngươi như giết chó!\" Tiêu Phàm dữ tợn cười một tiếng lau máu nơi khóe miệng, không có mảy may nhượng bộ.\n" +
            "\n" +
            "\"Ngươi là đang nằm mơ à, chỉ bằng phế vật ngươi cũng dám so sánh với Đại thiếu?\" Tiêu Trung không nghĩ tới Tiêu Phàm dám nói chuyện như thế với Tiêu Thiên, không khỏi trào phúng lên.\n" +
            "\n" +
            "\"Tiểu tạp chủng, hôm nay ta không chấp nhặt với ngươi, nếu như ngươi thật có gan thì niên hội gia tộc một tháng sau liên gặp nhau trên đài, ta chờ ngươi.\" Gặp Tiêu Phàm không nói, Tiêu Thiên híp mắt cười lên, khoát tay một cái nói, \"Chúng ta đi!\"\n" +
            "\n" +
            "\"Đại thiếu, ngài chậm một chút.\" Tiêu Trung hấp tấp theo sau lưng Tiêu Thiên, quả thực giống như một đầu chó xù.\n" +
            "\n" +
            "\"Phế vật chính là phế vật, ngay cả một quyền của đại thiếu cũng đỡ không nổi, một tháng sau đoán chừng đại thiếu đã đột phá Chiến Sĩ đỉnh phong, phế vật này vừa mới thức tỉnh Chiến Hồn, liền tự cho rằng bản thân tài giỏi, đợi đến lúc đó đại thiếu một cái ngón tay đều có thể bóp chết hắn!\"\n" +
            "\n" +
            "\"Nói không đúng sao, hôm nay vận khí phế vật này tốt, đại thiếu tâm tình không tệ, bằng không đại thiếu không chỉ đánh hắn thổ huyết, mà cho hắn chí ít nửa năm không rời được giường.\"\n" +
            "\n" +
            "Đám người nghị luận, ánh mắt cùng nhau tụ tập trên người Tiêu Phàm, tràn ngập châm chọc và khinh thường.\n" +
            "\n" +
            "Tiêu Phàm ngoảnh mặt làm ngơ, con ngươi sắc bén vô cùng, trong lòng kiên định nói: \"Yên tâm, niên hội một tháng sau ta sẽ tham gia, đến lúc đó ta muốn đem thiên tài trong miệng các ngươi chà đạp ở dưới chân!\"\n" +
            "\n" +
            "Trở lại chỗ ở rách rưới của bản thân, Tiêu Phàm cau mày ầm nghĩ thiếu niên Tiêu Phàm mặc dù là một đồ bỏ đi, nhưng dù gì cũng là Tiêu gia tam thiếu, cái địa phương này còn không bằng ổ chó.\n" +
            "\n" +
            "Hắn đối với thiếu niên Tiêu Phàm này ngược lại có chút bội phục, không cha không mẹ, bắt sống một mình từ lúc bảy tuổi, khi đó vẫn chỉ là một đứa bé, thật kh biết làm sao hắn có thể sống đến bây giờ.\n" +
            "\n" +
            "\"Thế giới này thực sự là tàn khốc a, thực lực vi tôn, căn bản không hề nói đến bất kỳ tình thân nào.\" Tiêu Phàm trong mắt lóe qua vẻ khinh miệt.\n" +
            "\n" +
            "Sau đó hắn liền bắt đầu tu luyện, muốn chuẩn bị cho niên hội một tháng sau của gia tộc, đệ tử tu luyện bên ngoài đến lúc đó đều sẽ trở về, rất nhiều người nhất định sẽ vũ nhục hắn!\n" +
            "\n" +
            "Mới vừa rồi bị Tiêu Thiên một kích đánh bay, Tiêu Phàm cũng minh bạch mình cùng Tiêu Thiên có chênh lệch khá lớn, trong một tháng đột phá cảnh giới Chiến Sĩ vẫn không đủ, thời gian đối với hắn mà nói rất trọng yếu!\n" +
            "\n" +
            "Đêm tịch mịch như nước!\n" +
            "\n" +
            "Tiêu Phàm ngồi xếp bằng trong căn phòng rách rưới, sau lưng hắn một đạo hắc sắc hư ảnh hoàn toàn hoà vào bên trong đêm tối, đó chính là U Linh Chiến Hồn.\n" +
            "\n" +
            "Tiêu Phàm phát hiện thời điểm sử dụng U Linh Chiến Hồn, toàn thân Tinh Khí Thần đều sẽ tăng lên tới cực hạn, hắn tốc độ tu luyện cũng tăng lên gấp bội.\n" +
            "\n" +
            "Liên tục sử dụng U Linh Chiến Hồn đối với Hồn Lực của hắn tiêu hao cực lớn, bất quá hắn vẫn một mực kiên trì, nếu ông trời đã cho hắn cơ hội trọng sinh, hắn tự nhiên muốn hảo hảo sống tốt một lần.\n" +
            "\n" +
            "Thiên địa linh khí cuồn cuộn mà chảy vào bên trong đan điền, Bạch Thạch tỏa ra quang mang yếu ớt, thương thế trong cơ thể nhanh chóng phục hồi như cũ, Bạch Thạch thần bí kia đối với trị thương lại có trợ giúp rất lớn, điều này làm Tiêu Phàm ngạc nhiên vô cùng.\n" +
            "\n" +
            "Tiêu Phàm tâm thần khẽ động, thiên địa linh khí liền rót vào cơ thể hắn, ngưng tụ thành Hồn Lực càng to lớn, so sánh với Hồn Lực trước đó càng thêm tinh thuần, mặc dù Hồn Lực tiêu hao rất nhanh, nhưng Tiêu Phàm rõ ràng cảm thụ được khí tức bản thân đang không ngừng mạnh lên.\n" +
            "\n" +
            "Tiêu Phàm hô hấp đều đặn, hơi thở tinh tế, sắc mặt bình tĩnh tường hòa, Hồn Lực trong cơ thể không ngừng lưu động rửa sạch gân cốt cùng kinh mạch.\n" +
            "\n" +
            "Lúc này thân thể hắn giống như một cái động không đáy điên cuồng hấp thu thiên địa linh khí xung quanh, sau một hồi cỗ khí tức này mới hài hòa trở lại.\n" +
            "\n" +
            "Đôi mắt hắn từ từ mở ra, một tia tinh quang lóe lên rồi biến mất, hắn chậm rãi đứng dậy, trên mặt lộ ra vẻ hài lòng, trong một đêm hắn liên tiếp đột phá, bây giờ đã là Chiến Linh hậu kỳ!\n" +
            "\n" +
            "Bất quá hắn còn chưa có ý định dừng lại, Chiến Linh cảnh chỉ mới là nhập môn tại Chiến Hồn Đại Lục, Tiêu Thiên cũng không phải mục tiêu cuối cùng của hắn.\n" +
            "\n" +
            "Cường giả chân chính thân lượn cửu thiên, hô phong hoán vũ, đó mới cảnh giới chân chính mà hắn hướng đến.\n" +
            "\n" +
            "Sau khi Tiêu Phàm tỉnh lại cũng đã đến giữa trưa ngày hôm sau, hắn hít một hơi tự nhủ: \"Đột phá Chiến Linh cảnh hậu kỳ cũng nên đi Chiến Kỹ Các chọn lựa chiến kỹ.\"" +
            "\n" +
            "Chương 3: Vô Tận Chiến Điển" +
            "\n" +
            "Chiến Kỹ Các, hậu nhân Tiêu gia thức tỉnh Chiến Hồn đều có thể đi vào, tuy nhiên chiến kỹ bên trong đều vô cùng bình thường, tuyệt học chân chính dĩ nhiên không thể nào để ở đây.\n" +
            "\n" +
            "Huống chi lấy tu vi Chiến Linh hậu kỳ của Tiêu Phàm cũng chỉ có thể quan sát một chút chiến kỹ bí tịch phổ thông mà thôi.\n" +
            "\n" +
            "\"Xin chào Đại Trưởng Lão.\" bên ngoài Chiến Kỹ Các, tại cửa ra vào có một lão giả tóc trắng đang ngồi xem một quyển sách đến nhập thần, người Tiêu gia tiến vào Chiến Kỹ Các đều cung kính chào hỏi hắn.\n" +
            "\n" +
            "Tiêu Phàm đi tới cửa chỉ muốn tìm hiểu một chút nhưng mà lão giả tóc trắng lại trực tiếp ném cho Tiêu Phàm một tấm thẻ bài bằng gỗ, nói: \"Ngươi có thể chọn ba loại chiến kỹ rồi đem ra đây đăng ký.\"\n" +
            "\n" +
            "\"Đa tạ Đại Trưởng Lão.\" Tiêu Phàm hơi hơi thi lễ, tiếp nhận tấm bảng gỗ đi vào Chiến Kỹ Các.\n" +
            "\n" +
            "Chiến Kỹ Các có ba tầng, Tiêu Phàm rất kinh ngạc phát hiện tàng thư ở Tiêu gia đúng là không ít, tầng thứ nhất có ba hàng giá sách, mỗi một hàng đều có đến mấy trăm bản thư tịch.\n" +
            "\n" +
            "Đọc lướt qua vài bản thư tịch liền trực tiếp đặt xuống, bất đắc dĩ lắc đầu:\n" +
            "\n" +
            "\"Những thứ này đều không phải Chiến Kỹ a, chắc Chiến Kỹ đặt ở tầng hai.\"\n" +
            "\n" +
            "Thư tịch ở tầng hai Chiến Kỹ Các không nhiều, cũng chỉ có chừng một trăm quyển, Tiêu Phàm Hồn Lực đảo qua cuối cùng rơi vào một quyển Chiến Kỹ Nhị Phẩm tên Mê Tung Bộ.\n" +
            "\n" +
            "\"Mê Tung Bộ, Chiến Kỹ Thân Pháp Nhị Phẩm, tổng cộng chia làm tứ trọng, luyện tới đỉnh phong, Quỷ Ảnh Mê Tung...\" Tiêu Phàm mở ra thư tịch, trong miệng thì thầm vài câu.\n" +
            "\n" +
            "Đối với chiến kỹ hắn cũng biết một chút, công pháp ngoại trừ chia thành Cửu Phẩm còn phân thành các loại công pháp như: công kích, phòng ngự, trị liệu, thân pháp. Mê Tung Bộ này chính là một loại Chiến Kỹ về thân pháp, Nhị Phẩm mặc dù không quá mạnh nhưng chiến kỹ trị liệu cùng chiến kỹ thân pháp đều là thập phần thưa thớt, cho nên quyển Nhị Phẩm Mê Tung Bộ này cũng coi như hiếm thấy.\n" +
            "\n" +
            "\"Chọn nó vậy, Thân Pháp Chiến Kỹ so với Phòng Ngự Chiến Kỹ càng thêm khó có được, tiếp theo lại chọn một bộ Chiến Kỹ Công Kích và một bộ Chiến Kỹ Phòng Ngự vậy. Còn Chiến Kỹ Trị Liệu xem chừng cả tòa Tiêu Thành này cũng chẳn có.\" Tiêu Phàm âm thầm trầm tư nhanh chóng lật xem bí tịch, hắn đem toàn bộ nội dung Mê Tung Bộ ghi nhớ vào trong đầu.\n" +
            "\n" +
            "Cũng có lẽ là bởi vì quá mức chú tâm nên bất tri bất giác đã khởi động U Linh Chiến Hồn, sau một nén nhang Tiêu Phàm đột nhiên tỉnh lại, dưới chân vừa động ngay lập tức tại chỗ lưu lại một đạo tàn ảnh, trong nháy mắt xuất hiện ở một nơi khác, Hồn Lực trong người lập tức tiêu hao một phần ba.\n" +
            "\n" +
            "Tiêu Phàm ngốc trệ tại chỗ, lắp bắp nói: \"Không thể nào, đã luyện đến đệ tứ trọng?\"\n" +
            "\n" +
            "Cũng khó trách hắn khiếp sợ như vậy, tu luyện Nhị Phẩm Chiến Kỹ đối với những cường giả mà nói thì rất đơn giản, nhưng hắn chỉ là Chiến Linh hậu kỳ, tu luyện Nhị Phẩm Chiến Kỹ nhất định sẽ có chút khó khăn.\n" +
            "\n" +
            "Nhưng lúc này mới qua bao lâu? Hắn lại đem Chiến Kỹ Nhị Phẩm: Mê Tung Bộ luyện đến đệ tứ trọng, nếu như không phải chính hắn vừa mới thi triển thì hắn còn tưởng bản thân mình đang nằm mơ.\n" +
            "\n" +
            "\"Chẳng lẽ ta chính là kỳ tài võ học trong truyền thuyết? Gặp qua một lần liền nhớ, vô sự tự thông?\" Tiêu Phàm trong lòng có chút tự luyến, mắt lộ ra tinh quang nói: \"Thử lại thử một lần nữa.\"\n" +
            "\n" +
            "Tiêu Phàm lại chọn lựa một loại Chiến Kỹ Công Kích Nhất Phẩm: Tam Trọng Lãng, Tam Trọng Lãng có Tam Trọng, luyện đến tầng thứ ba liền có uy thế như sóng biển.\n" +
            "\n" +
            "Nhưng thời gian lần này lại vô cùng nhắn, chỉ vẻn vẹn không đến nửa chén trà nhỏ mà hắn đã tu luyện tới tầng thứ ba, mỗi một chi tiết đều được hắn xem xết cực kỳ kỹ lưỡng, thậm chí còn có một chút lĩnh ngộ mới.\n" +
            "\n" +
            "Mặc dù hắn đã có phỏng đoán nhưng vẫn bị chấn kinh như cũ, ánh mắt hắn lại quét về các Chiến Kỹ khác trên giá sách, trầm ngâm nói: \"Ở đây có hơn một trăm bộ chiến kỹ, ta hiện tại không có thời gian luyện thành tất cả, trước tiên ghi nhớ nội dung sau đó ra ngoài từ từ luyện vậy.\"\n" +
            "\n" +
            "\"Phá Lãng Thủ, Thanh Phong Đao Quyết, Phi Hồng Thất Kiếm, Kim Cương Chỉ...\"\n" +
            "\n" +
            "Hơn một trăm loại chiến kỹ, quyền pháp có chừng 50 loại, kiếm pháp cùng đao pháp có nhiều hơn 20 loại, thối pháp cùng chưởng pháp cũng có 7 ~8 loại, ít nhất chính là chỉ pháp, chỉ có 4 loại.\n" +
            "\n" +
            "Phá Lãng Thủ, bàn tay nhất định phải cương nhu dung hòa mới có thể đạt tới cảnh giới lấy nhu thắng cương, Thanh Phong Đao Quyết yêu cầu rất cao đối với lực lượng cùng thân pháp. Chỉ có năm chiêu thế nhưng mỗi một chiêu đều cần có lực lượng bá đạo cùng thân pháp nhẹ nhàng phối hợp, Phi Hồng Thất Kiếm yêu cầu bản thân phải có tốc độ cực cao bằng không căn bản không thể thi triển ra được uy lực...\n" +
            "\n" +
            "Tiêu Phàm nhớ kỹ những chiến kỹ này trong lòng lại càng chờ mong, nhưng nữa ngày sau đó hắn cũng chỉ chọn được thêm mười bản chiến kỹ nữa mà thôi.\n" +
            "\n" +
            "\"Vô Tận Chiến Điển?\" Ánh mắt Tiêu Phàm rơi vào một bản bí tịch cực kỳ cũ nát ở chỗ thấp nhất trên giá sách.\n" +
            "\n" +
            "Mở ra xem, Tiêu Phàm nhíu mày, bí tịch này không có giới thiệu cái gì, chỉ có miêu tả chiêu thức, nhìn qua vô cùng đơn giản, nếu như không phải danh tự tương đối bá khí thì Tiêu Phàm cũng không thèm nhìn một cái.\n" +
            "\n" +
            "\"A?\" Tiêu Phàm mém chút kêu lên thành tiếng, vào lúc ánh mắt của hắn nhìn vào Vô Tận Chiến Điển liền phát hiện một điều quỷ dị, tranh minh hoạ\n" +
            "\n" +
            "giống như sống lại, những bức tranh như như đang diễn luyện trong mắt hắn.\n" +
            "\n" +
            "Tiêu Phàm lắc lắc cái đầu, tưởng mình xem nhiều chiến kỹ quá nên bị mờ mắt, thầm nghĩ: \"Chiến kỹ này khẳng định không đơn giản, muốn mang ra ngoài xem ra có chút phiền phức, vạn nhất không được vậy phải nghĩ biện pháp sao chép lại.\"\n" +
            "\n" +
            "Hắn lên tầng ba nhìn một chút cũng không còn thấy thứ gì hấp dẫn nữa liền cầm bí tịch Vô Tận Chiến Điển đi tới chỗ Đại Trưởng Lão để đăng ký.\n" +
            "\n" +
            "\"Vô Tận Chiến Điển? Ngươi chọn bản chiến kỹ này?\" Đại Trưởng Lão nhíu mày, \"Vô Tận Chiến Điển này nhiều năm như vậy đều bị phủ đầy bụi bặm ngươi lẽ nào không hoài nghi ư? Người khác không cách nào tu luyện, ngươi cảm thấy ngươi có thể sao? Ta cho ngươi một cơ hội nữa vào chọn lại ba quyển bí tịch khác, tránh làm lãng phí thời gian tu luyện của ngươi.\"\n" +
            "\n" +
            "Tiêu Phàm biết rõ Đại Trưởng Lão có ý tốt, cung kính thi lễ, ngữ khí thập phần kiên quyết nói: \"Đại Trưởng Lão, ta muốn chọn bản bí tịch này!\"\n" +
            "\n" +
            "Đại Trưởng Lão nhìn thấy Tiêu Phàm tự tin như vậy, lại lắc lắc đầu nói: \"Nếu ngươi đã không nghe ta khuyên bảo vậy ta cũng không còn gì để nói, bản sách nát này không cần đăng ký, ngươi cầm đi đi.\"\n" +
            "\n" +
            "Tiêu Phàm sững sờ, vội vàng nói: \"Đa tạ Đại Trưởng Lão.\"\n" +
            "\n" +
            "Tiêu Phàm thu hồi Vô Tận Chiến Điển rời đi Chiến Kỹ Các, trong lòng nghi ngờ không thôi, bất quá rất nhanh liền bị kích động thay thế.\n" +
            "\n" +
            "Đại Trưởng Lão nhìn theo thân ảnh Tiêu Phàm đang biến mất, thở dài nói: \" Người tu luyện Vô Tận Chiến Điển đến cuối cùng đều đem mình luyện đến điên điên khùng khùng, ngươi cầm đi cũng được, tốt nhất là đừng trả lại.\"\n" +
            "\n" +
            "Tiêu Phàm tự nhiên không biết suy nghĩ trong lòng của Đại Trưởng Lão, hắn đắc ý ôm Vô Tận Chiến Điển trở lại trong sân liền bắt đầu điên cuồng tu luyện.\n" +
            "\n" +
            "So sánh với chiến kỹ khác thì Vô Tận Chiến Điển này xác thực quỷ dị hơn, trong một đêm hắn đều không hiểu, bất quá hắn cũng không phải không có thu hoạch được gì, hắn cảm thấy như hiểu như không.\n" +
            "\n" +
            "Nếu là chiến kỹ khác, hắn đã sớm thành thạo rồi, còn nếu không hiểu, hắn cũng dứt khoát mặc kệ, thời gian còn có không đến một tháng, gia tộc niên hội sắp đến, đối với Tiêu Phàm mà nói điều quan trọng nhất hiện tại là nâng cao thực lực lên.\n" +
            "\n" +
            "Sáng sớm hôm sau, Tiêu Phàm mang theo một chuôi kiếm thép, chuẩn bị một chút lương khô, mang theo Vô Tận Chiến Điển hướng thâm sơn bên ngoài Tiêu Thành mà đi.','https://sstruyen.com/assets/img/story//xvo-thuong-sat-than.jpg.pagespeed.ic.qT3N2DXpVa.webp',1)";
    private String SQLQuery13 = "INSERT INTO truyen VALUES (null,'ĐẤU LA ĐẠI LỤC','Chương 1: Đấu La Đại Lục (1)\n" +
            "\n" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n','https://toplist.vn/images/800px/cau-be-chan-cuu-va-cay-da-co-thu-230184.jpg',1)";
    private String SQLQuery14 = "INSERT INTO truyen VALUES (null,'ĐẤU LA ĐẠI LỤC','Chương 1: Đấu La Đại Lục (1)\n" +
            "\n" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n','https://toplist.vn/images/800px/cau-be-chan-cuu-va-cay-da-co-thu-230184.jpg',1)";
    private String SQLQuery15 = "INSERT INTO truyen VALUES (null,'ĐẤU LA ĐẠI LỤC','Chương 1: Đấu La Đại Lục (1)\n" +
            "\n" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n','https://toplist.vn/images/800px/cau-be-chan-cuu-va-cay-da-co-thu-230184.jpg',1)";
    private String SQLQuery16 = "INSERT INTO truyen VALUES (null,'ĐẤU LA ĐẠI LỤC','Chương 1: Đấu La Đại Lục (1)\n" +
            "\n" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n','https://toplist.vn/images/800px/cau-be-chan-cuu-va-cay-da-co-thu-230184.jpg',1)";
    private String SQLQuery17 = "INSERT INTO truyen VALUES (null,'ĐẤU LA ĐẠI LỤC','Chương 1: Đấu La Đại Lục (1)\n" +
            "\n" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n','https://toplist.vn/images/800px/cau-be-chan-cuu-va-cay-da-co-thu-230184.jpg',1)";
    private String SQLQuery18 = "INSERT INTO truyen VALUES (null,'ĐẤU LA ĐẠI LỤC','Chương 1: Đấu La Đại Lục (1)\n" +
            "\n" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n" +
            "" +
            "\n','https://toplist.vn/images/800px/cau-be-chan-cuu-va-cay-da-co-thu-230184.jpg',1)";




    // tạo bảng tại pương thức này
    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Thực hiện các câu lệnh truy vấn không trả về kết quả
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery9);
        db.execSQL(SQLQuery10);
        db.execSQL(SQLQuery11);
        db.execSQL(SQLQuery12);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //pương thức lấy tất cả tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TAIKHOAN,null);
        return res;
    }
    // phuowgn thức add tài khoản vào dâtbase
    public void AddTaikhoan(Taikhoan taikhoan){
        SQLiteDatabase db = this.getWritableDatabase();

        // thực hiện insert thông qua ContentValues
        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taikhoan.getmTenTaikhoan());
        values.put(MAT_KHAU,taikhoan.getmMatKhau());
        values.put(EMAIL,taikhoan.getmEmail());
        values.put(PHAN_QUYEN,taikhoan.getmPhanQuyen());

        db.insert(TABLE_TAIKHOAN,null,values);

        // đóng lại khi không dùng
        db.close();
        Log.e("ADD TK","TC");
    }

    // Lấy 3 truyện mới nhất
    public Cursor getData1(){
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 3 ",null);
//
//        return res;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN,null);
        return res;
    }

    // lấy tất cả truyện
    public Cursor getData2() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN,null);
        return res;
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 3 ",null);
//
//        return res;
    }
    // Thêm truyện
    public void AddTruyen(Truyen truyen){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEN_TRUYEN,truyen.getTenTruyen());
        values.put(NOI_DUNG,truyen.getNoiDung());
        values.put(IMAGE,truyen.getAnh());
        values.put(ID_TAI_KHOAN,truyen.getID_TK());

        db.insert(TABLE_TRUYEN,null,values);
        db.close();
    }
    //delete truyện
    public int delete(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        int res = db.delete(TABLE_TRUYEN,ID_TRUYEN+"="+i,null);
        return res;
    }
}
