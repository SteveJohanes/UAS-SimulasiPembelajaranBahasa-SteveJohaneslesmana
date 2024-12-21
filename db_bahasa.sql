-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for db_bahasa
DROP DATABASE IF EXISTS `db_bahasa`;
CREATE DATABASE IF NOT EXISTS `db_bahasa` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_bahasa`;

-- Dumping structure for table db_bahasa.bahasa
DROP TABLE IF EXISTS `bahasa`;
CREATE TABLE IF NOT EXISTS `bahasa` (
  `kodebhs` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `namabhs` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `gambar` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `carabaca` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`kodebhs`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_bahasa.bahasa: ~142 rows (approximately)
DELETE FROM `bahasa`;
INSERT INTO `bahasa` (`kodebhs`, `namabhs`, `gambar`, `carabaca`) VALUES
	('H001', 'a', 'img\\a.png', 'a'),
	('H002', 'i', 'img\\i.png', 'i'),
	('H003', 'u', 'img\\u.png', 'u'),
	('H004', 'e', 'img\\e.png', 'e'),
	('H005', 'o', 'img\\o.png', 'o'),
	('H006', 'sa', 'img\\sa.png', 'sa'),
	('H007', 'shi', 'img\\shi.png', 'shi'),
	('H008', 'tsu', 'img\\tsu.png', 'tsu'),
	('H009', 'se', 'img\\se.png', 'se'),
	('H010', 'so', 'img\\so.png', 'so'),
	('H011', 'ta', 'img\\ta.png', 'ta'),
	('H012', 'chi', 'img\\chi.png', 'chi'),
	('H013', 'tsu', 'img\\tsu.png', 'tsu'),
	('H014', 'te', 'img/te.png', 'te'),
	('H015', 'to', 'img/to.png', 'to'),
	('H016', 'ka', 'img/ka.png', 'ka'),
	('H017', 'ki', 'img/ki.png', 'ki'),
	('H018', 'ku', 'img/ku.png', 'ku'),
	('H019', 'ke', 'img/ke.png', 'ke'),
	('H020', 'ko', 'img/ko.png', 'ko'),
	('H021', 'na', 'img/na.png', 'na'),
	('H022', 'ni', 'img/ni.png', 'ni'),
	('H023', 'nu', 'img/nu.png', 'nu'),
	('H024', 'ne', 'img/ne.png', 'ne'),
	('H025', 'no', 'img/no.png', 'no'),
	('H026', 'ha', 'img/ha.png', 'ha'),
	('H027', 'hi', 'img/hi.png', 'hi'),
	('H028', 'hu', 'img/hu.png', 'hu'),
	('H029', 'he', 'img/he.png', 'he'),
	('H030', 'ho', 'img/ho.png', 'ho'),
	('H031', 'ma', 'img/ma.png', 'ma'),
	('H032', 'mi', 'img/mi.png', 'mi'),
	('H033', 'mu', 'img/mu.png', 'mu'),
	('H034', 'me', 'img/me.png', 'me'),
	('H035', 'mo', 'img/mo.png', 'mo'),
	('H036', 'ya', 'img/ya.png', 'ya'),
	('H037', 'yu', 'img/yu.png', 'yu'),
	('H038', 'yo', 'img/yo.png', 'yo'),
	('H039', 'ra', 'img/ra.png', 'ra'),
	('H040', 'ri', 'img/ri.png', 'ri'),
	('H041', 'ru', 'img/ru.png', 'ru'),
	('H042', 're', 'img/re.png', 're'),
	('H043', 'ro', 'img/ro.png', 'ro'),
	('H044', 'wa', 'img/wa.png', 'wa'),
	('H045', 'o', 'img/o.png', 'o'),
	('H046', 'n', 'img/n.png', 'n'),
	('H047', 'ga', 'img/ga.png', 'ga'),
	('H048', 'gi', 'img/gi.png', 'gi'),
	('H049', 'gu', 'img/gu.png', 'gu'),
	('H050', 'ge', 'img/ge.png', 'ge'),
	('H051', 'go', 'img/go.png', 'go'),
	('H052', 'za', 'img/za.png', 'za'),
	('H053', 'ji', 'img/ji.png', 'ji'),
	('H054', 'zu', 'img/zu.png', 'zu'),
	('H055', 'ze', 'img/ze.png', 'ze'),
	('H056', 'zo', 'img/zo.png', 'zo'),
	('H057', 'da', 'img/da.png', 'da'),
	('H058', 'ji', 'img/ji.png', 'ji'),
	('H059', 'zu', 'img/zu.png', 'zu'),
	('H060', 'de', 'img/de.png', 'de'),
	('H061', 'do', 'img/do.png', 'do'),
	('H062', 'ba', 'img/ba.png', 'ba'),
	('H063', 'bi', 'img/bi.png', 'bi'),
	('H064', 'bu', 'img/bu.png', 'bu'),
	('H065', 'be', 'img/be.png', 'be'),
	('H066', 'bo', 'img/bo.png', 'bo'),
	('H067', 'pa', 'img/pa.png', 'pa'),
	('H068', 'pi', 'img/pi.png', 'pi'),
	('H069', 'pu', 'img/pu.png', 'pu'),
	('H070', 'pe', 'img/pe.png', 'pe'),
	('H071', 'po', 'img/po.png', 'po'),
	('K001', 'a', 'img/kaa.png', 'a'),
	('K002', 'u', 'img/kau.png', 'u'),
	('K003', 'i', 'img/kai.png', 'i'),
	('K004', 'e', 'img/kae.png', 'e'),
	('K005', 'o', 'img/kao.png', 'o'),
	('K006', 'sa', 'img/kasa.png', 'sa'),
	('K007', 'shi', 'img/kashi.png', 'shi'),
	('K008', 'kasu', 'img/kasu.png', 'kasu'),
	('K009', 'kase', 'img/kase.png', 'kase'),
	('K010', 'kaso', 'img/kaso.png', 'kaso'),
	('K011', 'kata', 'img/kata.png', 'kata'),
	('K012', 'kachi', 'img/kachi.png', 'kachi'),
	('K013', 'katsu', 'img/katsu.png', 'katsu'),
	('K014', 'te', 'img/kate.png', 'te'),
	('K015', 'to', 'img/kato.png', 'to'),
	('K016', 'ka', 'imgkaka.png', 'ka'),
	('K017', 'ki', 'img/kaki.png', 'ki'),
	('K018', 'ku', 'img/kaku.png', 'ku'),
	('K019', 'ke', 'img/kake.png', 'ke'),
	('K020', 'ko', 'img/kako.png', 'ko'),
	('K021', 'na', 'img/kana.png', 'na'),
	('K022', 'ni', 'img/kani.png', 'ni'),
	('K023', 'nu', 'img/kanu.png', 'nu'),
	('K024', 'ne', 'img/kane.png', 'ne'),
	('K025', 'no', 'img/kano.png', 'no'),
	('K026', 'ha', 'img/kaha.png', 'ha'),
	('K027', 'hi', 'img/kahi.png', 'hi'),
	('K028', 'hu', 'img/kahu.png', 'hu'),
	('K029', 'he', 'img/kahe.png', 'he'),
	('K030', 'ho', 'img/kaho.png', 'ho'),
	('K031', 'ma', 'img/kama.png', 'ma'),
	('K032', 'mi', 'img/kami.png', 'mi'),
	('K033', 'mu', 'img/kamu.png', 'mu'),
	('K034', 'me', 'img/kame.png', 'me'),
	('K035', 'mo', 'img/kamo.png', 'mo'),
	('K036', 'ya', 'img/kaya.png', 'ya'),
	('K037', 'yu', 'img/kayu.png', 'yu'),
	('K038', 'yo', 'img/kayo.png', 'yo'),
	('K039', 'ra', 'img/kara.png', 'ra'),
	('K040', 'ri', 'img/kari.png', 'ri'),
	('K041', 'ru', 'img/karu.png', 'ru'),
	('K042', 're', 'img/kare.png', 're'),
	('K043', 'ro', 'img/karo.png', 'ro'),
	('K044', 'wa', 'img/kawa.png', 'wa'),
	('K045', 'o', 'img/kao.png', 'o'),
	('K046', 'n', 'img/kan.png', 'n'),
	('K047', 'ga', 'img/kaga.png', 'ga'),
	('K048', 'gi', 'img/kagi.png', 'gi'),
	('K049', 'gu', 'img/kagu.png', 'gu'),
	('K050', 'ge', 'img/kage.png', 'ge'),
	('K051', 'go', 'img/kago.png', 'go'),
	('K052', 'za', 'img/kaza.png', 'za'),
	('K053', 'ji', 'img/kaji.png', 'ji'),
	('K054', 'zu', 'img/kazu.png', 'zu'),
	('K055', 'ze', 'img/kaze.png', 'ze'),
	('K056', 'zo', 'img/kazo.png', 'zo'),
	('K057', 'da', 'img/kada.png', 'da'),
	('K058', 'ji', 'img/kaji.png', 'ji'),
	('K059', 'zu', 'img/kazu.png', 'zu'),
	('K060', 'de', 'img/kade.png', 'de'),
	('K061', 'do', 'img/kado.png', 'do'),
	('K062', 'ba', 'img/kaba.png', 'ba'),
	('K063', 'bi', 'img/kabi.png', 'bi'),
	('K064', 'bu', 'img/kabu.png', 'bu'),
	('K065', 'be', 'img/kabe.png', 'be'),
	('K066', 'bo', 'img/kabo.png', 'bo'),
	('K067', 'pa', 'img/kapa.png', 'pa'),
	('K068', 'pi', 'img/kapi.png', 'pi'),
	('K069', 'pu', 'img/kapu.png', 'pu'),
	('K070', 'pe', 'img/kape.png', 'pe'),
	('K071', 'po', 'img/kapo.png', 'po');

-- Dumping structure for table db_bahasa.ujian
DROP TABLE IF EXISTS `ujian`;
CREATE TABLE IF NOT EXISTS `ujian` (
  `kodesoal` varchar(3) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `soal` varchar(100) DEFAULT NULL,
  `jawaban` varchar(50) DEFAULT NULL,
  `gambar` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_bahasa.ujian: ~0 rows (approximately)
DELETE FROM `ujian`;
INSERT INTO `ujian` (`kodesoal`, `soal`, `jawaban`, `gambar`) VALUES
	('S01', 'hiragana apa ini', 'a', 'img\\a_test.jpg'),
	('S02', 'katakana apa ini', 'ka', 'img\\ka_test.jpg');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
