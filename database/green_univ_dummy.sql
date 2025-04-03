USE green_univ;

###############################################
# 작성자: id3ntity99(이현민)
# 설명 : 더미 데이터(가짜 데이터) 삽입 스크립트
###############################################

INSERT INTO `user` VALUES 
("abc123", SHA2("abc@123", 256), "김철수", "Hong Gil Dong", "m", "대한민국", "010203-1234567", "abc123@example.com", "010-1111-2222", "12345", "부산광역시 남구", "행복아파트 101동 501호", "admin", 1, NOW(), NULL),

("jjm123", SHA2("jjm@123", 256), "진재문", "Hong Gil Dong", "m", "대한민국", "630512-1234567", "jjm123@ks.ac.kr", "010-2222-3333", "12345", "부산광역시 남구", "행복아파트 101동 501호","professor", 1, NOW(), NULL),
("prof121", SHA2("abc@123", 256), "김국어","Hong Gil Dong", "m", "대한민국", "010203-1234561", "prof121@example.com", "010-1111-2201", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof122", SHA2("abc@123", 256), "김영어","Hong Gil Dong", "m", "대한민국", "010203-1234562", "prof122@example.com", "010-1111-2202", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof123", SHA2("abc@123", 256), "김일어","Hong Gil Dong", "m", "대한민국", "010203-1234563", "prof123@example.com", "010-1111-9784", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof124", SHA2("abc@123", 256), "김중어","Hong Gil Dong", "m", "대한민국", "010203-1234564", "prof124@example.com", "010-1111-2203", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof125", SHA2("abc@123", 256), "김역사","Hong Gil Dong", "m", "대한민국", "010203-1234565", "prof125@example.com", "010-1111-2205", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof126", SHA2("abc@123", 256), "김경제","Hong Gil Dong", "m", "대한민국", "010203-1234566", "prof126@example.com", "010-1111-2206", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof127", SHA2("abc@123", 256), "김경영","Hong Gil Dong", "m", "대한민국", "010203-9908213", "prof127@example.com", "010-1111-2207", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof128", SHA2("abc@123", 256), "김법학","Hong Gil Dong", "m", "대한민국", "010203-1234568", "prof128@example.com", "010-1111-2208", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof129", SHA2("abc@123", 256), "김철학","Hong Gil Dong", "m", "대한민국", "010203-1234569", "prof129@example.com", "010-1111-2209", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof130", SHA2("abc@123", 256), "김정치","Hong Gil Dong", "m", "대한민국", "010203-1234510", "prof130@example.com", "010-1111-2210", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof131", SHA2("abc@123", 256), "김행정","Hong Gil Dong", "m", "대한민국", "010203-1234511", "prof131@example.com", "010-1111-2211", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof132", SHA2("abc@123", 256), "김사회","Hong Gil Dong", "m", "대한민국", "010203-1234512", "prof132@example.com", "010-1111-2212", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof133", SHA2("abc@123", 256), "김유아","Hong Gil Dong", "m", "대한민국", "010203-1234513", "prof133@example.com", "010-1111-2213", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof134", SHA2("abc@123", 256), "김수학","Hong Gil Dong", "m", "대한민국", "010203-1234514", "prof134@example.com", "010-1111-2214", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof135", SHA2("abc@123", 256), "김물리","Hong Gil Dong", "m", "대한민국", "010203-1234515", "prof135@example.com", "010-1111-2215", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof136", SHA2("abc@123", 256), "김화학","Hong Gil Dong", "m", "대한민국", "010203-1234516", "prof136@example.com", "010-1111-2216", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof137", SHA2("abc@123", 256), "김천문","Hong Gil Dong", "m", "대한민국", "010203-1234517", "prof137@example.com", "010-1111-2217", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof138", SHA2("abc@123", 256), "김지구","Hong Gil Dong", "m", "대한민국", "010203-1234518", "prof138@example.com", "010-1111-2218", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof139", SHA2("abc@123", 256), "김생명","Hong Gil Dong", "m", "대한민국", "010203-1234519", "prof139@example.com", "010-1111-2219", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof140", SHA2("abc@123", 256), "김생물","Hong Gil Dong", "m", "대한민국", "010203-1234520", "prof140@example.com", "010-1111-2220", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof141", SHA2("abc@123", 256), "김해양","Hong Gil Dong", "m", "대한민국", "010203-1234521", "prof141@example.com", "010-1111-2221", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof142", SHA2("abc@123", 256), "김기계","Hong Gil Dong", "m", "대한민국", "010203-1234522", "prof142@example.com", "010-1111-2983", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof143", SHA2("abc@123", 256), "김전자","Hong Gil Dong", "m", "대한민국", "010203-1234523", "prof143@example.com", "010-1111-2223", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof144", SHA2("abc@123", 256), "김전기","Hong Gil Dong", "m", "대한민국", "010203-1234524", "prof144@example.com", "010-1111-2224", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof145", SHA2("abc@123", 256), "김컴공","Hong Gil Dong", "m", "대한민국", "010203-1234525", "prof145@example.com", "010-1111-2225", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof146", SHA2("abc@123", 256), "김건축","Hong Gil Dong", "m", "대한민국", "010203-1234526", "prof146@example.com", "010-1111-2226", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof147", SHA2("abc@123", 256), "김재료","Hong Gil Dong", "m", "대한민국", "010203-1234527", "prof147@example.com", "010-1111-2227", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof148", SHA2("abc@123", 256), "김화공","Hong Gil Dong", "m", "대한민국", "010203-1234528", "prof148@example.com", "010-1111-2228", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof149", SHA2("abc@123", 256), "김국교","Hong Gil Dong", "m", "대한민국", "010203-1234529", "prof149@example.com", "010-1111-2229", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof150", SHA2("abc@123", 256), "김영교","Hong Gil Dong", "m", "대한민국", "010203-1234530", "prof150@example.com", "010-1111-2230", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof151", SHA2("abc@123", 256), "김수교","Hong Gil Dong", "m", "대한민국", "010203-1234531", "prof151@example.com", "010-1111-2231", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof152", SHA2("abc@123", 256), "김윤리","Hong Gil Dong", "m", "대한민국", "010203-1234532", "prof152@example.com", "010-1111-2232", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof153", SHA2("abc@123", 256), "김교육","Hong Gil Dong", "m", "대한민국", "010203-1234533", "prof153@example.com", "010-1111-2233", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof154", SHA2("abc@123", 256), "김사회","Hong Gil Dong", "m", "대한민국", "010203-1234534", "prof154@example.com", "010-1111-2234", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof155", SHA2("abc@123", 256), "김역교","Hong Gil Dong", "m", "대한민국", "010203-1234535", "prof155@example.com", "010-1111-2235", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof156", SHA2("abc@123", 256), "김체육","Hong Gil Dong", "m", "대한민국", "010203-1234536", "prof156@example.com", "010-1111-2236", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof157", SHA2("abc@123", 256), "김특수","Hong Gil Dong", "m", "대한민국", "010203-1234537", "prof157@example.com", "010-1111-2237", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof158", SHA2("abc@123", 256), "김경대","Hong Gil Dong", "m", "대한민국", "010203-1234538", "prof158@example.com", "010-1111-2238", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof159", SHA2("abc@123", 256), "김제대","Hong Gil Dong", "m", "대한민국", "010203-1234539", "prof159@example.com", "010-1111-2239", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof160", SHA2("abc@123", 256), "김행대","Hong Gil Dong", "m", "대한민국", "010203-1234540", "prof160@example.com", "010-1111-2240", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof161", SHA2("abc@123", 256), "김교대","Hong Gil Dong", "m", "대한민국", "010203-1234541", "prof161@example.com", "010-1111-2241", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof162", SHA2("abc@123", 256), "김산업","Hong Gil Dong", "m", "대한민국", "010203-1234542", "prof162@example.com", "010-1111-2242", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),



("prof163", SHA2("abc@123", 256), "박옥자","Hong Gil Dong", "m", "대한민국", "010203-1234543", "prof163@example.com", "010-1111-2243", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof164", SHA2("abc@123", 256), "제갈민수","Hong Gil Dong", "m", "대한민국", "010203-1234544", "prof164@example.com", "010-1111-2244", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("prof165", SHA2("abc@123", 256), "김미영","Hong Gil Dong", "m", "대한민국", "010203-1234545", "prof165@example.com", "010-1111-2245", "12345", "부산광역시 남구", "행복아파트 101동 501호", "professor", 1, NOW(), NULL),
("hgd123", SHA2("abc@123", 256), "홍길동","Hong Gil Dong", "m", "대한민국", "010203-9875643", "hgd123@example.com", "010-2222-1234", "12345", "부산광역시 남구", "행복아파트 101동 501호", "student", 1, NOW(), NULL),
("kyh123", SHA2("abc@123", 256), "김영희","Hong Gil Dong", "m", "대한민국", "010203-9875642", "kyh123@example.com", "010-2222-1233", "12345", "부산광역시 남구", "행복아파트 101동 501호", "student", 1, NOW(), NULL),
("kmj123", SHA2("abc@123", 256), "김민지","Hong Gil Dong", "m", "대한민국", "010203-9875641", "kmj123@example.com", "010-2222-1232", "12345", "부산광역시 남구", "행복아파트 101동 501호", "student", 1, NOW(), NULL);
INSERT INTO `user` VALUES ("hs1202", SHA2("abc@123", 256), "한선" , "Han Seon", "f", "대한민국", "051202-1234567",  "hs1202@example.com", "010-8434-5604", "12345", "부산광역시 남구", "행복아파트 1010동 1002호", "student", 1, NOW(), NULL);

INSERT INTO `club` SET `name`="배드민턴 중앙동아리", `content`="배트민턴 중앙동아리를 소개합니다!";
INSERT INTO `club` (`name`, `content`, `url`) VALUES 
("연극 동아리 Masquerade", "연극 중앙동아리 Masquerade를 소개합니다!", "https://instagram.com"),
("코딩 동아리 Code:us", "코딩 동아리 Code:us를 소개합니다!", "https://facebook.com");

INSERT INTO `image` VALUES (1, "/foo/bar", "/baz/qaz");


-- 단과대학
-- 강의등록 페이지의 단과대학 선택 옵션을 하드코딩 할 수 없으므로 별도의 테이블 지정
INSERT INTO `college` VALUES 
(1, "인문사회대학", "College of Humanities and Social Sciences", "역사와 전통을 자랑하는 그린대학교 인문사회대학", 1),
(2, "자연과학대학", "College of Natural Sciences", "역사와 전통을 자랑하는 그린대학교 자연과학대학", 1),
(3, "공과대학", "Colege of Engineering", "역사와 전통을 자랑하는 그린대학교 공과대학", 1),
(4, "사범대학", "College of Education", "역사와 전통을 자랑하는 그린대학교 사범대학", 1),
(5, "대학원", "Graduate School", "대한민국을 이끌어가는 그린대학교 대학원", 1);

INSERT INTO `department` VALUES 
(101, 1, "2002", "국어국문학과", "Department of Korean", "051-123-1001", "26호관 401호"),
(102, 1, "2002","영어영문학과", "Department of English", "051-123-1002", "26호관 401호"),
(103, 1, "2002","일어일문학과", "Department of Japanese", "051-123-1003", "26호관 401호"),
(104, 1, "2002","중어중문학과", "Department of Chinese", "051-123-1004", "26호관 401호"),
(105, 1, "2002","역사학과", "Department of History", "051-123-1005", "26호관 401호"),
(106, 1, "2002", "경제학과", "Department of Economics", "051-123-1006", "26호관 401호"),
(107, 1, "2002", "경영학과", "Department of Business Administration", "051-123-1007", "26호관 401호"),
(108, 1, "2002", "법학과", "Department of Law", "051-123-1008", "26호관 401호"),
(109, 1, "2002", "철학과", "Department of Philosophy", "051-123-1009", "26호관 401호"),
(110, 1, "2002", "정치외교학과", "Department of Political Science and Diplomacy", "051-123-1010", "26호관 401호"),
(111, 1, "2002", "행정학과", "Department of Public Administration", "051-123-1011", "26호관 401호"),
(112, 1, "2002", "사회복지학과", "Department of Social Welfare", "051-663-4509", "26호관 401호"),
(113, 1, "2002", "유아교육학과", "Department of Early Childhood Education", "051-123-1013", "26호관 401호"),
(201, 2, "2002", "수학과", "Department of Mathematics", "051-123-2001", "26호관 401호"),
(202, 2,"2002", "물리학과", "Department of Physics", "051-123-2002", "26호관 401호"),
(203, 2,"2002", "화학과", "Department of Chemical", "051-123-2003", "26호관 401호"),
(204, 2,"2002", "천문학과", "Department of Astronomy", "051-123-2004", "26호관 401호"),
(205, 2,"2002", "지구과학과", "Department of Earth Sciences", "051-123-2005", "26호관 401호"),
(206, 2,"2002", "생명과학과", "Department of Life Sciences", "051-123-2006", "26호관 401호"),
(207, 2,"2002", "미생물학과", "Department of Microbiology", "051-123-2007", "26호관 401호"),
(208, 2,"2002", "해양학과", "Department of Oceanography", "051-123-2008", "26호관 401호"),
(301, 3,"2002", "기계공학과", "Department of Mechanical Engineering", "051-123-3001", "26호관 401호"),
(302, 3,"2002", "전자공학과", "Department of Electronic Engineering", "051-123-3002", "26호관 401호"),
(303, 3,"2002", "전기공학과", "Department of Electrical Engineering", "051-123-3003", "26호관 401호"),
(304, 3,"2002", "컴퓨터공학과", "Department of Computer Engineering", "051-123-3004", "26호관 401호"),
(305, 3,"2002", "건축공학과", "Department of Architectural Engineering", "051-123-3005", "26호관 401호"),
(306, 3,"2002", "재료공학과", "Department of Materials Engineering", "051-123-3006", "26호관 401호"),
(307, 3,"2002", "화학공학과", "Department of Chemical Engineering", "051-123-3007", "26호관 401호"),
(401, 4, "2002","국어교육과", "Department of Korean Language Education", "051-123-4001", "26호관 401호"),
(402, 4, "2002","영어교육과", "Department of English Education", "051-123-4002", "26호관 401호"),
(403, 4, "2002","수학교육과", "Department of Mathematics Education", "051-123-4003", "26호관 401호"),
(404, 4, "2002","윤리학과", "Department of Ethics", "051-123-4004", "26호관 401호"),
(405, 4, "2002","교육학과", "Department of Education", "051-123-4005", "26호관 401호"),
(406, 4, "2002","사회교육과", "Department of Social Education", "051-123-4006", "26호관 401호"),
(407, 4, "2002","역사교육과", "Department of History Education", "051-123-4007", "26호관 401호"),
(408, 4, "2002","체육교육과", "Department of Physical Education", "051-123-4008", "26호관 401호"),
(409, 4, "2002","특수교육과", "Department of Special Education", "051-123-4009", "26호관 401호"),
(501, 5, "2002","경영대학원", "Business School", "051-123-5001", "26호관 401호"),
(502, 5, "2002","경제대학원", "School of Economics", "051-123-5002", "26호관 401호"),
(503, 5, "2002","행정대학원", "School of Public Administration", "051-123-5003", "26호관 401호"),
(504, 5, "2002","교육대학원", "Graduate School of Education", "051-123-5004", "26호관 401호"),
(505, 5, "2002","산업대학원", "Graduate School of Industry", "051-123-5005", "26호관 401호");

INSERT INTO `faq` (`category`, `question`, `answer`) VALUES 
("휴복학 관련", "일반휴학 연장은 몇 학기까지 가능한가요?", "휴학연장은 1회에 2학기 가능하고 총 6학기 휴학 가능합니다"),
("휴복학 관련", "복학하려고 하는데 어떻게 신청하나요??", "휴학연장은 1회에 2학기 가능하고 총 6학기 휴학 가능합니다"),
("휴복학 관련", "등록금 납부 및 등록 후 일반 휴학 가능한가요? 환불은 언제되나요??", "휴학연장은 1회에 2학기 가능하고 총 6학기 휴학 가능합니다"),
("휴복학 관련", "군휴학을 하려면 입영통지서 말고 어떤 서류가 필요하나요?", "휴학연장은 1회에 2학기 가능하고 총 6학기 휴학 가능합니다"),
("교과 및 학사 관련", "학과별 교과과정과 학사안내를 확인하고 싶은데, 어떻게 확인할 수 있나요?", "홈페이지 내 대학요람(대학생활 안내)를 통해 해당 입학년도, 해당 학과의 교과과정과 학사안내를 확인하세요"),
("교과 및 학사 관련", "복수전공 취소 또는 부전공 전환 신청은 어떻게 하나요?", "홈페이지 내 대학요람(대학생활 안내)를 통해 해당 입학년도, 해당 학과의 교과과정과 학사안내를 확인하세요"),
("교과 및 학사 관련", "수강신청은 어떻게 하나요??", "홈페이지 내 대학요람(대학생활 안내)를 통해 해당 입학년도, 해당 학과의 교과과정과 학사안내를 확인하세요"),
("수강신청 관련", "4학년 2학기에도 최소 12학점을 수강해야 하나요?", "수강신청 안내를 참고하시기 바랍니다."),
("수강신청 관련", "9학기 이상 등록자는 수강신청학점에 따라 등록금이 달라지나요?", "수강신청 안내를 참고하시기 바랍니다."),
("수강신청 관련", "수강신청은 어떻게 하나요??", "수강신청 안내를 참고하시기 바랍니다.");

-- 교수번호 = P + 학과번호 + 교수 고유번호(총 7자리).
-- 예시: P + 112(사회복지학과 번호) + 001(교수 고유번호) = P112001

-- 인문사회대학 교수
INSERT INTO `professor` VALUES 
("P101001", "prof121", 101, "Yale University", "1996-02-13", "국어국문학과", "phd", "2013-01-01", "in", "full",  1),
("P102001", "prof122", 102, "Yale University", "1996-02-13", "영어영문학과", "phd", "2013-01-01", "in", "full", 1),
("P103001", "prof123", 103, "Yale University", "1996-02-13", "일어일문학과", "phd", "2013-01-01", "in", "full", 1),
("P104001", "prof124", 104, "Yale University", "1996-02-13", "중어중문학과", "phd", "2013-01-01", "in", "full", 1),
("P105001", "prof125", 105, "Yale University", "1996-02-13", "역사학과", "phd", "2013-01-01", "in", "full", 1),
("P106001", "prof126", 106, "Yale University", "1996-02-13", "경제학과", "phd", "2013-01-01", "in", "full", 1),
("P107001", "prof127", 107, "Yale University", "1996-02-13", "경영학과", "phd", "2013-01-01", "in", "full", 1),
("P108001", "prof128", 108, "Yale University", "1996-02-13", "법학과", "phd", "2013-01-01", "in", "full", 1),
("P109001", "prof129", 109, "Yale University", "1996-02-13", "철학학과", "phd", "2013-01-01", "in", "full", 1),
("P110001", "prof130", 110, "Yale University", "1996-02-13", "정치외교학과", "phd", "2013-01-01", "in", "full", 1),
("P111001", "prof131", 111, "Yale University", "1996-02-13", "행정학과", "phd", "2013-01-01", "in", "full", 1),
("P112001", "jjm123", 112, "Yale University", "1996-02-13", "사회복지학과", "phd", "2013-01-01", "in", "full", 1),
("P113001", "prof133", 113, "Yale University", "1996-02-13", "유아교육학과", "phd", "2013-01-01", "in", "full", 1);

-- 자연과학대학 교수
INSERT INTO `professor` VALUES 
("P201001", "prof134", 201, "Yale University", "1996-02-13", "수학과", "phd", "2013-01-01", "in", "full", 1),
("P202001", "prof135", 202, "Yale University", "1996-02-13", "물리학과", "phd", "2013-01-01", "in", "full", 1),
("P203001", "prof136", 203, "Yale University", "1996-02-13", "화학과", "phd", "2013-01-01", "in", "full", 1),
("P204001", "prof137", 204, "Yale University", "1996-02-13", "천문학과", "phd", "2013-01-01", "in", "full", 1),
("P205001", "prof138", 205, "Yale University", "1996-02-13", "지구과학과", "phd", "2013-01-01", "in", "full", 1),
("P206001", "prof139", 206, "Yale University", "1996-02-13", "생명과학과", "phd", "2013-01-01", "in", "full", 1),
("P207001", "prof140", 207, "Yale University", "1996-02-13", "미생물과학과", "phd", "2013-01-01", "in", "full", 1),
("P208001", "prof141", 208, "Yale University", "1996-02-13", "해양학과", "phd", "2013-01-01", "in", "full", 1);

-- 공과대학 교수
INSERT INTO `professor` VALUES 
("P301001", "prof142", 301, "Yale University", "1996-02-13", "기계공학과", "phd", "2013-01-01", "in", "full", 1),
("P302001", "prof143", 302, "Yale University", "1996-02-13", "전자공학과", "phd", "2013-01-01", "in", "full", 1),
("P303001", "prof144", 303, "Yale University", "1996-02-13", "전기공학과", "phd", "2013-01-01", "in", "full", 1),
("P304001", "prof145", 304, "Yale University", "1996-02-13", "컴퓨터공학과", "phd", "2013-01-01", "in", "full", 1),
("P305001", "prof146", 305, "Yale University", "1996-02-13", "건축공학과", "phd", "2013-01-01", "in", "full", 1),
("P306001", "prof147", 306, "Yale University", "1996-02-13", "재료공학과", "phd", "2013-01-01", "in", "full", 1),
("P307001", "prof148", 307, "Yale University", "1996-02-13", "화학공학과", "phd", "2013-01-01", "in", "full", 1);

-- 사범대학 교수
INSERT INTO `professor` VALUES 
("P401001", "prof149", 401, "Yale University", "1996-02-13", "국어교육과", "phd", "2013-01-01", "in", "full", 1),
("P402001", "prof150", 402, "Yale University", "1996-02-13", "영어교육과", "phd", "2013-01-01", "in", "full", 1),
("P403001", "prof151", 403, "Yale University", "1996-02-13", "수학교육과", "phd", "2013-01-01", "in", "full", 1),
("P404001", "prof152", 404, "Yale University", "1996-02-13", "윤리학과", "phd", "2013-01-01", "in", "full", 1),
("P405001", "prof153", 405, "Yale University", "1996-02-13", "교육학과", "phd", "2013-01-01", "in", "full", 1),
("P406001", "prof154", 406, "Yale University", "1996-02-13", "사회교육학과", "phd", "2013-01-01", "in", "full", 1),
("P407001", "prof155", 407, "Yale University", "1996-02-13", "역사교육과", "phd", "2013-01-01", "in", "full", 1),
("P408001", "prof156", 408, "Yale University", "1996-02-13", "체육교육과", "phd", "2013-01-01", "in", "full", 1),
("P409001", "prof157", 409, "Yale University", "1996-02-13", "특수교육과", "phd", "2013-01-01", "in", "full", 1);

-- 대학원 교수
INSERT INTO `professor` VALUES 
("P501001", "prof158", 501,  "Yale University", "1996-02-13", "경영대학원", "phd", "2013-01-01", "in", "full", 1),
("P502001", "prof159", 502, "Yale University", "1996-02-13", "경제대학원", "phd", "2013-01-01", "in", "full", 1),
("P503001", "prof160", 503,  "Yale University", "1996-02-13", "행정대학원", "phd", "2013-01-01", "in", "full",1),
("P504001", "prof161", 504, "Yale University", "1996-02-13", "교육대학원", "phd", "2013-01-01", "in", "full", 1),
("P505001", "prof162", 505, "Yale University", "1996-02-13", "산업대학원", "phd", "2013-01-01", "in", "full", 1);

-- article 
INSERT INTO `article` (`id`, `user_id`, `title`, `category`, `status`, `content`, `register_date`) VALUES 
(1, "abc123", "[공지사항] 그린대학교 웹사이트 신규 개설 안내", "notice", "open", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW()),
(2, "abc123", "[뉴스] 그린대학교 웹사이트 신규 개설 안내", "news", "open", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW()),
(3, "abc123", "[칼럼] 그린대학교 웹사이트 신규 개설 안내", "column", "open", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW()),
(4, "abc123", "[취업정보] 그린대학교 웹사이트 신규 개설 안내", "employment", "open", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW()),
(5, "abc123", "미답변 질문 테스트입니다.", "qna", "open", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW()),
(6, "abc123", "답변된 질문 테스트입니다.", "qna", "close", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW()),
(7, "abc123", "답변 테스트입니다.", "qna", "open", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW());
INSERT INTO `article` (`id`, `user_id`, `title`, `category`, `status`, `content`, `register_date`) VALUES 
(8, "abc123", "[취업정보] 그린대학교 웹사이트 신규 개설 안내", "employment", "close", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW());
INSERT INTO `article` (`id`, `user_id`, `title`, `category`, `status`, `content`, `register_date`) VALUES 
(9, "abc123", "그린대학교 웹사이트 신규 개설 안내", "bulletin", "open", "그린대학교 웹사이트가 개설되었음을 알려드립니다. 자세한 사항은 '자주묻는질문' 페이지를 확인해주세요.", NOW());
INSERT INTO `article` (`id`, `user_id`, `title`, `category`, `status`, `content`, `register_date`) VALUES
(10, "abc123", "파일첨부 테스트", "resources", "open", "파일첨부 테스트입니다.", NOW());
INSERT INTO `article` (`id`, `user_id`, `title`, `category`, `status`, `content`, `register_date`) VALUES
(11, "abc123", "파일첨부 테스트 그리고 게시물의 제목의 길이가 제대로 concat 되는지 테스트 중입니다.", "resources", "open", "파일첨부 테스트입니다.", NOW());

-- reply_article(article.category가 reply와 같은 article들의 모임)
INSERT INTO `qna` VALUES
(5, NULL, 0, NULL),
(6, 7, 1, "1234");

-- comment
INSERT INTO `comment` VALUES 
(1, "abc123", 1, "공지사항 게시물 댓글 테스트입니다.", NOW()),
(2, "abc123", 2, "뉴스 게시물 댓글 테스트입니다.", NOW()),
(3, "abc123", 3, "칼럼게시물 댓글 테스트입니다.", NOW()),
(4, "abc123", 4, "취업정보 게시물 댓글 테스트입니다.", NOW()),
(5, "abc123", 5, "미답변 질문 게시물 댓글 테스트입니다.", NOW()),
(6, "abc123", 6, "답변된 질문 게시물 댓글 테스트입니다.", NOW()),
(7, "abc123", 7, "답변 게시물 댓글 테스트입니다.", NOW()),
(8, "abc123", 7, "복수의 게시물 댓글 테스트입니다.", NOW());
