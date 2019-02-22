-- MySQL dump 10.13  Distrib 5.6.6-m9, for Win64 (x86_64)
--
-- Host: 192.168.2.19    Database: Bregaboys
-- ------------------------------------------------------
-- Server version	5.1.73

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
-- Table structure for table `CategoriaSalario`
--

DROP TABLE IF EXISTS `CategoriaSalario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CategoriaSalario` (
  `codigoCategoriaSalario` int(11) NOT NULL,
  `valorCategoriaSalario` float DEFAULT NULL,
  PRIMARY KEY (`codigoCategoriaSalario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CategoriaSalario`
--

LOCK TABLES `CategoriaSalario` WRITE;
/*!40000 ALTER TABLE `CategoriaSalario` DISABLE KEYS */;
INSERT INTO `CategoriaSalario` VALUES (1,1000),(2,2500),(3,5000),(4,7500);
/*!40000 ALTER TABLE `CategoriaSalario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `codigoCliente` int(11) NOT NULL,
  `nomeCliente` varchar(256) DEFAULT NULL,
  `telefoneCliente` varchar(12) DEFAULT NULL,
  `emailCliente` varchar(256) DEFAULT NULL,
  `codigoEndereco` int(11) NOT NULL,
  PRIMARY KEY (`codigoCliente`),
  KEY `fk_Cliente_Endereco1_idx` (`codigoEndereco`),
  CONSTRAINT `fk_Cliente_Endereco1` FOREIGN KEY (`codigoEndereco`) REFERENCES `Endereco` (`codigoEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'Vinícius Meng','54 3326-3790','vinimeng@hotmail.com',11),(2,'Jaspion Silveira','57 3352-9965','tatsumako@tutsuni.com',12),(3,'Yudi Jiraya ','69 3256-8456','praistaition@rapjapa.com',13),(4,'Priscila Sakura','53 3569-9878','anime@virji.com',14),(5,'Guy Gardner','75 3215-7880','lanterneverdegay@dc.com',15),(6,'Bruce Wayne','56 3369-9889','nsouobatman@batman.com',16),(7,'Alan Harper','54 3358-7691','alinho@2emeio.com',17),(8,'Luke Starkiller','58 3225-9876','lukeson@banela.com',18),(9,'George Abrams','54 3358-9699','georginhopik@disney.com',19),(10,'JJ Lucas','54 3226-8996','jjlucas@starwars.com',20);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Compra`
--

DROP TABLE IF EXISTS `Compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Compra` (
  `codigoCompra` int(11) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `codigoTransportadora` int(11) NOT NULL,
  PRIMARY KEY (`codigoCompra`),
  KEY `fk_Compra_Cliente_idx` (`codigoCliente`),
  KEY `fk_Compra_Transportadora1_idx` (`codigoTransportadora`),
  CONSTRAINT `fk_Compra_Cliente` FOREIGN KEY (`codigoCliente`) REFERENCES `Cliente` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_Transportadora1` FOREIGN KEY (`codigoTransportadora`) REFERENCES `Transportadora` (`codigoTransportadora`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Compra`
--

LOCK TABLES `Compra` WRITE;
/*!40000 ALTER TABLE `Compra` DISABLE KEYS */;
INSERT INTO `Compra` VALUES (1,2,1),(2,3,2),(3,4,2),(4,5,5),(5,10,9);
/*!40000 ALTER TABLE `Compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CompraProduto`
--

DROP TABLE IF EXISTS `CompraProduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CompraProduto` (
  `codigoCompra` int(11) NOT NULL,
  `codigoProduto` int(11) NOT NULL,
  `quantidadeProduto` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoCompra`,`codigoProduto`),
  KEY `fk_Compra_has_Produto_Produto1_idx` (`codigoProduto`),
  KEY `fk_Compra_has_Produto_Compra1_idx` (`codigoCompra`),
  CONSTRAINT `fk_Compra_has_Produto_Compra1` FOREIGN KEY (`codigoCompra`) REFERENCES `Compra` (`codigoCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_has_Produto_Produto1` FOREIGN KEY (`codigoProduto`) REFERENCES `Produto` (`codigoProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CompraProduto`
--

LOCK TABLES `CompraProduto` WRITE;
/*!40000 ALTER TABLE `CompraProduto` DISABLE KEYS */;
/*!40000 ALTER TABLE `CompraProduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Endereco`
--

DROP TABLE IF EXISTS `Endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Endereco` (
  `codigoEndereco` int(11) NOT NULL,
  `rua` varchar(256) DEFAULT NULL,
  `bairro` varchar(256) DEFAULT NULL,
  `estado` varchar(256) DEFAULT NULL,
  `cidade` varchar(256) DEFAULT NULL,
  `pais` varchar(256) DEFAULT NULL,
  `numeroCasa` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Endereco`
--

LOCK TABLES `Endereco` WRITE;
/*!40000 ALTER TABLE `Endereco` DISABLE KEYS */;
INSERT INTO `Endereco` VALUES (1,'Nilva Suzete da Silva Pinto','Arcobaleno','Rio Grande do Sul','Caxias do Sul','Brasil',10),(2,'Júlio de Castilhos','Centenário','Rio Grande do Sul','Farroupilha','Brasil',11),(3,'Murilo Meyer','Azenha','Rio Grande do Sul','Porto Alegre','Brasil',12),(4,'Luiz Lopes','Pio X','Rio Grande do Sul','Bento Gonçalves','Brasil',13),(5,'Marechal Deodoro','Centro','Rio Grande do Sul','Carlos Barbosa','Brasil',14),(6,'Dionisio Justa','Fátima','Rio Grande do Sul','Caxias do Sul','Brasil',15),(7,'Luana Vespero','Cinquentenário','Rio Grande do Sul','Caxias do Sul','Brasil',16),(8,'Joana Galil','Restinga','Rio Grande do Sul','Porto Alegre','Brasil',17),(9,'Paula Oliveira','Colônia','Rio Grande do Sul','Bento Gonçalves','Brasil',18),(10,'Rasputin Fonseca','Vitorino','Rio Grande do Sul','Bento Gonçalves','Brasil',19),(11,'Laís Silveira','Cruzeiro','Rio Grande do Sul','Caxias do Sul','Brasil',20),(12,'Ana Joaquina de Paula','Menino Deus','Rio Grande do Sul','Porto Alegre','Brasil',21),(13,'Jair Nunes','Centro','Rio Grande do Sul','Canoas','Brasil',22),(14,'Luiz Hoppengar','Oriental','Rio Grande do Sul','Canoas','Brasil',23),(15,'Wilson Tombini Lima','Horto','Rio Grande do Sul','Alvorada','Brasil',24),(16,'Jörgen Klapp','Alemão','Rio Grande do Sul','Nova Hartz','Brasil',25),(17,'João Silva','Rural','Rio Grande do Sul','Esmeralda','Brasil',26),(18,'Maria Roberta Silveira','Centro','Rio Grande do Sul','Pinhal da Serra','Brasil',27),(19,'Helena Suzana de Bruno','Jarari','Rio Grande do Sul','Cazuza Ferreira','Brasil',28),(20,'Jair Mauro de Pena','Pedra Curva','Rio Grande do Sul','Pedra Lisa','Brasil',29),(21,'Maurício Jonas ','Tigroso','Rio Grande do Sul','Campestre do Tigre','Brasil',30),(22,'Das Palmeiras','Parque','Rio Grande do Sul','Vacaria','Brasil',31),(23,'Gurizada Fandangueira','Kiss','Rio Grande do Sul','Santa Maria','Brasil',32),(24,'Hilbert Viana','Alegrete','Rio Grande do Sul','Uruguaiana','Brasil',33),(25,'Gurilana','Uruguaiana','Rio Grande do Sul','Alegrete','Brasil',34),(26,'Vale das Alegrias','Passo Fino','Rio Grande do Sul','Passo Fundo','Brasil',35),(27,'Porto Alegre','Guaipequinha','Rio Grande do Sul','Jaguarão','Brasil',36),(28,'Presidente Castelo Branco','Jardim Olivia','Rio Grande do Sul','Arroio do Sal','Brasil',37),(29,'Das Laranjeiras','Pedra','Rio Grande do Sul','Torres','Brasil',38),(30,'Pirarucu','Jundiaí','Rio Grande do Sul','Tramandaí','Brasil',39),(31,'Nogueira da Silva','Canoeiros','Rio Grande do Sul','Capão da Canoa','Brasil',40),(32,'Thiago Viado','Inteligente Magro','Rio Grande do Sul','Anta Gorda','Brasil',41),(33,'Bozo','Triste','Rio Grande do Sul','Feliz','Brasil',42),(34,'Petrobrax','Novo Óleo','Rio Grande do Sul','Nova Petrópolis','Brasil',43),(35,'Vinagrete','Novo Pastel','Rio Grande do Sul','Novo Hamburgo','Brasil',44),(36,'Usina','Gasômetro','Rio Grande do Sul','Porto Alegre','Brasil',45),(37,'Central','Desvio Rizzo','Rio Grande do Sul','Caxias do Sul','Brasil',46),(38,'Júlio de Castilhos','Centro','Rio Grande do Sul','Farroupilha','Brasil',47),(39,'Boulevard Voltaire','11.º Arrondissement','Ilha da França','Paris','França',50),(40,'Lama','Lama','Minas Gerais','Mariana','Brasil',49);
/*!40000 ALTER TABLE `Endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fornecedor`
--

DROP TABLE IF EXISTS `Fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Fornecedor` (
  `codigoFornecedor` int(11) NOT NULL,
  `nomeFornecedor` varchar(256) DEFAULT NULL,
  `telefoneFornecedor` varchar(12) DEFAULT NULL,
  `emailFornecedor` varchar(256) DEFAULT NULL,
  `codigoEndereco` int(11) NOT NULL,
  PRIMARY KEY (`codigoFornecedor`),
  KEY `fk_Fornecedor_Endereco1_idx` (`codigoEndereco`),
  CONSTRAINT `fk_Fornecedor_Endereco1` FOREIGN KEY (`codigoEndereco`) REFERENCES `Endereco` (`codigoEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fornecedor`
--

LOCK TABLES `Fornecedor` WRITE;
/*!40000 ALTER TABLE `Fornecedor` DISABLE KEYS */;
INSERT INTO `Fornecedor` VALUES (1,'Sucos Paraiba','65 3268-5566','sucos.paraiba@laranja.com',1),(2,'Elma Chips','66 3261-6655','elmachips@hotmail.com',2),(3,'Coca-cola','33 36268-666','cocacola@cola.com',3),(4,'Prudence','69 36969-696','prupru69@palmito.com',4),(5,'Águas Ceára','32 3268-0809','ceara@seca.com',5),(6,'Santa Clara','45 3265-9896','santaclara@leite.com',6),(7,'Sadia','25 32656-985','sadia@flango.com',7),(8,'Chocolates ChocOco','69 3268-5569','Oco@delicia.com',8),(9,'P&G','69 3268-9515','peg@faustao.com',9),(10,'Friboi','32 3265-6215','friboi@carnedecavalo.com',10);
/*!40000 ALTER TABLE `Fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Funcionario`
--

DROP TABLE IF EXISTS `Funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Funcionario` (
  `codigoFuncionario` int(11) NOT NULL,
  `nomeFuncionario` varchar(256) DEFAULT NULL,
  `emailFuncionario` varchar(256) DEFAULT NULL,
  `telefoneFuncionario` varchar(12) DEFAULT NULL,
  `codigoSecao` int(11) NOT NULL,
  `codigoCategoriaSalario` int(11) NOT NULL,
  `codigoEndereco` int(11) NOT NULL,
  `codigoGerente` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoFuncionario`),
  KEY `fk_Funcionario_Secao1_idx` (`codigoSecao`),
  KEY `fk_Funcionario_CategoriaSalario1_idx` (`codigoCategoriaSalario`),
  KEY `fk_Funcionario_Endereco1_idx` (`codigoEndereco`),
  KEY `fk_Funcionario_idx` (`codigoFuncionario`),
  KEY `fk_Funcionario_Funcionario1_idx` (`codigoGerente`),
  CONSTRAINT `fk_Funcionario_Funcionario1` FOREIGN KEY (`codigoGerente`) REFERENCES `Funcionario` (`codigoFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_CategoriaSalario1` FOREIGN KEY (`codigoCategoriaSalario`) REFERENCES `CategoriaSalario` (`codigoCategoriaSalario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Endereco1` FOREIGN KEY (`codigoEndereco`) REFERENCES `Endereco` (`codigoEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Secao1` FOREIGN KEY (`codigoSecao`) REFERENCES `Secao` (`codigoSecao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Funcionario`
--

LOCK TABLES `Funcionario` WRITE;
/*!40000 ALTER TABLE `Funcionario` DISABLE KEYS */;
INSERT INTO `Funcionario` VALUES (1,'Luiz Gustavo Oliveira','luiz@hothot.com','53 9964-8595',1,1,21,3),(2,'João Jones','jj@kilo.com','54 9958-6823',3,2,22,3),(3,'Kiano Silva','neo@matrix.com','92 3522-9658',4,4,23,NULL),(4,'Morpheus dos Santos','morpheus@nabudonosor.com','54 3326-6475',5,3,24,3),(5,'Nelson Silveira','nelsinho@eu.com.br','87 8554-6193',3,2,25,3),(6,'Thomas Anderson','realneo@matrix.com','95 7888-8887',2,2,26,3),(7,'Jefferson Antunes','jeff@filosofis.com','52 3546-9562',6,3,27,3),(8,'Josnei Udison','blackcat@funky.com','96 9548-8230',7,3,28,3),(9,'Mario Lopes','mario@mario.com','51 3112-2154',8,2,29,3),(10,'Luigi Lopes','luigi@mario.com','51 3112-2153',8,1,30,3);
/*!40000 ALTER TABLE `Funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Produto`
--

DROP TABLE IF EXISTS `Produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Produto` (
  `codigoProduto` int(11) NOT NULL,
  `nomeProduto` varchar(256) DEFAULT NULL,
  `valorUnitario` float DEFAULT NULL,
  `codigoFornecedor` int(11) NOT NULL,
  `codigoSecao` int(11) NOT NULL,
  PRIMARY KEY (`codigoProduto`),
  KEY `fk_Produto_Fornecedor1_idx` (`codigoFornecedor`),
  KEY `fk_Produto_Secao1_idx` (`codigoSecao`),
  CONSTRAINT `fk_Produto_Fornecedor1` FOREIGN KEY (`codigoFornecedor`) REFERENCES `Fornecedor` (`codigoFornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Secao1` FOREIGN KEY (`codigoSecao`) REFERENCES `Secao` (`codigoSecao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto`
--

LOCK TABLES `Produto` WRITE;
/*!40000 ALTER TABLE `Produto` DISABLE KEYS */;
INSERT INTO `Produto` VALUES (1,'Coca-Cola',4,3,3),(2,'Agua Ceara',2.5,5,3),(3,'Suco De Frutas',3.5,1,3),(4,'Leite Santa Clara',3.5,6,2),(5,'Queijo Santa Clara',5,6,2),(6,'Picanhas Friboi',20,10,10),(7,'Barra de Chocolate ChocOco',6,8,1),(8,'Presuntos Sadia',4,7,6),(9,'Preservativo Prudence Star Wars',0.5,4,7),(10,'Head&Shoulders',10,9,7),(11,'Doritos',5,2,1);
/*!40000 ALTER TABLE `Produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Secao`
--

DROP TABLE IF EXISTS `Secao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Secao` (
  `codigoSecao` int(11) NOT NULL,
  `nomeSecao` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`codigoSecao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Secao`
--

LOCK TABLES `Secao` WRITE;
/*!40000 ALTER TABLE `Secao` DISABLE KEYS */;
INSERT INTO `Secao` VALUES (1,'Guloseimas'),(2,'Laticinios'),(3,'Bebidas'),(4,'Alimentaçao'),(5,'Frutas'),(6,'Frios'),(7,'Limpeza'),(8,'Eletrodomesticos'),(9,'Padaria'),(10,'Açougue');
/*!40000 ALTER TABLE `Secao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transportadora`
--

DROP TABLE IF EXISTS `Transportadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Transportadora` (
  `codigoTransportadora` int(11) NOT NULL,
  `nomeTransportadora` varchar(256) DEFAULT NULL,
  `telefoneTransportadora` varchar(12) DEFAULT NULL,
  `emailTransportadora` varchar(256) DEFAULT NULL,
  `codigoEndereco` int(11) NOT NULL,
  PRIMARY KEY (`codigoTransportadora`),
  KEY `fk_Transportadora_Endereco1_idx` (`codigoEndereco`),
  CONSTRAINT `fk_Transportadora_Endereco1` FOREIGN KEY (`codigoEndereco`) REFERENCES `Endereco` (`codigoEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transportadora`
--

LOCK TABLES `Transportadora` WRITE;
/*!40000 ALTER TABLE `Transportadora` DISABLE KEYS */;
INSERT INTO `Transportadora` VALUES (1,'Trans Adão','54 3224 6969','capetinha23mole@bol.com.br',31),(2,'Trans Apeca','57 3225-9856','apeca@trans.com',32),(3,'Trans Ada','51 3365-5970','ada@trans.com',33),(4,'Paula Traz','51 3659-1200','traz@paula.com',34),(5,'Trans Ei','54 3226-6995','ei@trans.com',35),(6,'Trans Artur','54 3225-8550','artur@trans.com',36),(7,'Trans Udo','57 3229-9885','udo@trans.com',37),(8,'Trans X','52 3225-9880','x@trans.com',38),(9,'Trans Plante','57 3226-9000','plante@trans.com',39),(10,'Trans Samantha','54 3225-5890','sam@trans.com',40);
/*!40000 ALTER TABLE `Transportadora` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-18 17:58:59
