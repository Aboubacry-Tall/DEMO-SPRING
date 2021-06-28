-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2021 at 11:08 AM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `libsysdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `fixe` varchar(255) DEFAULT NULL,
  `domicile` varchar(255) DEFAULT NULL,
  `utilisateurs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `buy`
--

CREATE TABLE `buy` (
  `id` bigint(20) NOT NULL,
  `livre_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `buy`
--

INSERT INTO `buy` (`id`, `livre_id`, `user_id`) VALUES
(1, '25', '2'),
(2, '23', '2');

-- --------------------------------------------------------

--
-- Table structure for table `editeurs`
--

CREATE TABLE `editeurs` (
  `id` int(11) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `historique`
--

CREATE TABLE `historique` (
  `id` bigint(20) NOT NULL,
  `auteur` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `couverture` varchar(255) DEFAULT NULL,
  `dates` varchar(255) DEFAULT NULL,
  `document` varchar(255) DEFAULT NULL,
  `editeur` varchar(255) DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `prix` varchar(255) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `historique`
--

INSERT INTO `historique` (`id`, `auteur`, `categorie`, `couverture`, `dates`, `document`, `editeur`, `etat`, `isbn`, `prix`, `resume`, `statut`, `titre`) VALUES
(9, 'Odile Jacob', 'mathematiques', 'petite-mathematique-du-cerveau.jpg', '2021-05-10', 'petite mathematique.pdf', 'Alpha', NULL, '9782738178626', '20000', NULL, NULL, 'Petite mathématique du cerveau'),
(11, 'Joseph Murphy', 'PNL', 'maitriser-bitcoin-guide-du-debutant-pour-commencer-a-gagner-de-l-argent-avec-bitcoin.jpg', NULL, 'Dans le secret des mathématiques.pdf', 'Les Éditions de l\'Homme', NULL, '9782761955102', '20000', '', NULL, 'La puissance de votre subconscient'),
(12, 'aaa', 'informatique', 'i1.jpg', '2021-05-15', '00-Introduction.pdf', 'aaa', NULL, 'aaa', '3', NULL, NULL, 'aaa'),
(13, 'bbb', 'informatique', 'i1.jpg', '2021-05-15', '00-Introduction.pdf', 'bbb', NULL, 'bbb', '3', NULL, NULL, 'bbb'),
(14, 'dfg', 'PNL', 'maurilib.jpg', '2021-05-15', '00-Introduction.pdf', 'fdg', NULL, 'df', '056', NULL, NULL, 'bbbf'),
(15, 'dfg', 'PNL', 'maurilib.jpg', '2021-05-15', '00-Introduction.pdf', 'fdg', NULL, 'df', '056', NULL, NULL, 'bbbf'),
(16, 'cbng', 'informatique', 'i1.jpg', '2021-05-15', '00-Introduction.pdf', 'bx', NULL, '543', '0585864', NULL, NULL, 'bbbf'),
(17, 'cvbv', 'PNL', '2.jpg', '2021-05-15', '00-Introduction.pdf', 'bvcbcx', NULL, 'vbvbcbbvcx', '0535', NULL, NULL, 'bvvb'),
(18, 'vcbcx', 'PNL', 'WhatsApp Image 2021-05-08 at 04.59.29.jpeg', '2021-05-15', '00-Introduction.pdf', 'cvbxc', NULL, 'cxbvc', '0', NULL, NULL, 'vbxvb'),
(19, 'ccc', 'mathematiques', 'logo.jpg', '2021-05-15', '00-Introduction.pdf', 'ccc', NULL, 'ccc', '3', NULL, NULL, 'cc');

-- --------------------------------------------------------

--
-- Table structure for table `livres`
--

CREATE TABLE `livres` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `prix` varchar(255) DEFAULT NULL,
  `statut` enum('payant','gratuit') DEFAULT NULL,
  `etat` enum('0','1') DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `couverture` varchar(255) DEFAULT NULL,
  `categorie` varchar(50) DEFAULT NULL,
  `auteur` varchar(50) DEFAULT NULL,
  `editeur` varchar(50) DEFAULT NULL,
  `document` varchar(50) DEFAULT NULL,
  `dates` date DEFAULT curdate(),
  `resume` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `livres`
--

INSERT INTO `livres` (`id`, `titre`, `prix`, `statut`, `etat`, `isbn`, `couverture`, `categorie`, `auteur`, `editeur`, `document`, `dates`, `resume`) VALUES
(23, 'Intelligence artificielle', '1', 'gratuit', NULL, '22545526', 'intelligence-artificielle-5.jpg', 'Jeux', 'activision', 'sledghammer', 'Intelligence artificielle.pdf', '2021-06-10', 'c fatiguant'),
(25, 'soniic', '1', 'payant', NULL, '5584445655', 'la-mathematique-du-physicien.jpg', 'Jeux', 'dony', 'sny', 'La Mathématique du physicien.pdf', '2021-06-09', ''),
(26, 'hacking', '255', 'payant', NULL, '5555555555', 'hacking-et-contre-hacking.jpg', 'Informatiques', 'Microsoft', 'google', 'Hacking et contre hacking.pdf', '2021-06-24', 'une introduction importante pour le premier pas en hacking'),
(27, 'Mathematiques', '0', 'gratuit', NULL, '55875462466', 'mathematiques-en-economie-gestion-2.jpg', 'Educations', 'UNA', 'cheikh', 'La Mathématique du physicien.pdf', '2021-06-09', '');

-- --------------------------------------------------------

--
-- Table structure for table `payements`
--

CREATE TABLE `payements` (
  `id` int(11) NOT NULL,
  `dates` date DEFAULT NULL,
  `livres_id` int(11) NOT NULL,
  `utilisateurs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `souhaits`
--

CREATE TABLE `souhaits` (
  `id` int(11) NOT NULL,
  `dates` date DEFAULT NULL,
  `utilisateurs_id` int(11) NOT NULL,
  `livres_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cle` varchar(255) DEFAULT 'client',
  `statut` varchar(255) DEFAULT 'Active',
  `telephone` varchar(50) DEFAULT NULL,
  `fixe` varchar(50) DEFAULT NULL,
  `domicile` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `nom`, `email`, `code`, `cle`, `statut`, `telephone`, `fixe`, `domicile`) VALUES
(1, 'tall', 'tall@gmail.com', '1234', 'client', 'Active', '27278474', NULL, 'basra'),
(2, 'cheikh raby', 'cheikh@yahoo.fr', '1', 'client', 'Active', '49701013', NULL, 'toujinine'),
(3, 'cisse', 'cisse@gmail.com', '1234', 'client', 'Active', '42465158', NULL, 'socogime'),
(55, 'asma mohamed chaddi', 'asma@gmail.com', '1234', 'client', 'Active', '44482009', NULL, 'madrid'),
(59, 'Fatis', 'fatis@gmail.com', '1234', 'client', 'Active', '49701013', NULL, 'arafate'),
(60, 'Mostafa', 'Mostafa@gmail.com', '1234', 'client', 'Active', '225548565', NULL, 'nktt'),
(61, 'med', 'cheikh24@yahoo.fr', '1234', 'client', 'Active', '45585852', NULL, 'basra');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buy`
--
ALTER TABLE `buy`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `livres`
--
ALTER TABLE `livres`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payements`
--
ALTER TABLE `payements`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `souhaits`
--
ALTER TABLE `souhaits`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buy`
--
ALTER TABLE `buy`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `livres`
--
ALTER TABLE `livres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
