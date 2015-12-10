-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: icookdb
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping events for database 'icookdb'
--

--
-- Dumping routines for database 'icookdb'
--
/*!50003 DROP PROCEDURE IF EXISTS `GetFoodByID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetFoodByID`(in Idsearch int)
BEGIN
select MaterialDetail, Tutorial, Source, UserID from icookdb.tbl_fooddetail tmp where  tmp.FoodID = Idsearch; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SearchFood_Material` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SearchFood_Material`(in Stringsearch varchar(2000),in member int,in ignorenumber int)
BEGIN
	declare search varchar(2000) default Stringsearch;
    
	declare pointerFirst int(11) default 1;
    
	declare pointerLast int (11) default 0;
    
	declare maxlength int(11) default 0;
    
	declare tmp varchar(255) default '';
    set maxlength = length(search);
	DROP table dataSearch;
    CREATE TEMPORARY TABLE IF NOT EXISTS dataSearch  (
    SELECT *
    FROM iCookDB.tbl_food ic    
    );
	DROP table dataSearchtmp;
    CREATE TEMPORARY TABLE IF NOT EXISTS dataSearchtmp (
     SELECT *
    FROM dataSearch ic   
    );
    DROP table dataSearchtmp1;
    CREATE TEMPORARY TABLE IF NOT EXISTS dataSearchtmp1 (
	SELECT *
    FROM dataSearch ic   
    );
    
	processsearch: while ( pointerLast <> length(search)) do
    set tmp = '';
	set pointerLast = LOCATE(';',search);
    
	set tmp = SUBSTRING(search FROM pointerFirst FOR pointerLast-1);
    
	if tmp = '' then LEAVE processsearch; end if;
    
    set tmp = concat('%',tmp,'%');
	
    DROP table dataSearch;
	CREATE TEMPORARY TABLE IF NOT EXISTS dataSearch  (
    select t1.FoodID, t1.FoodName, t1.Description,t1.AvatarLink,t1.VisitNum, t1.ListMaterial, t1.CategoryID from dataSearchtmp t1
	INNER JOIN  (select t2.FoodID, t2.FoodName, t2.Description,t2.AvatarLink,t2.VisitNum, t2.ListMaterial, t2.CategoryID from dataSearchtmp1 t2 where t2.ListMaterial like tmp collate utf8_general_ci) t
	on t1.FoodID =t.FoodID
	);
    
    DROP table dataSearchtmp;
    CREATE TEMPORARY TABLE IF NOT EXISTS dataSearchtmp  (
	SELECT *
    FROM dataSearch ic  
    );
    DROP table dataSearchtmp1;
    CREATE TEMPORARY TABLE IF NOT EXISTS dataSearchtmp1  (
	SELECT *
    FROM dataSearch ic  
    );
    
	set search = SUBSTRING(search FROM pointerLast+1 FOR length(search));
	end while processsearch;
    
	select * from dataSearch order by VisitNum DESC limit member offset ignorenumber; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-10 20:04:39
