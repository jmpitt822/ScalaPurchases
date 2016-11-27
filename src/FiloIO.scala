import java.io.{File, PrintWriter}

import scala.collection.mutable
import scala.io.Source

/**
  * Created by jeremypitt on 10/18/16.
  */
case class Purchase(customerId: String, date: String, creditCard: String, cvv: String, category: String) {
  override def toString: String = s"$customerId, ${date.substring(0,10)}, $creditCard, $cvv, $category"
}

object FiloIO {
  val purchaseList = mutable.MutableList[Purchase]()

  def main(args: Array[String]) = {
    readFile
    var resp = ""
    while (resp != "Q") {
      resp = menu match {
        case "1" => choiceOne.opt()
        case "2" => choiceTwo.opt()
        case "3" => choiceThree.opt()
        case "4" => choiceFour.opt()
        case "5" => choiceFive.opt()
        case "6" => choiceSix.opt()
        case "Q" => choiceQuit.opt()
      }
    }


  }

  def readFile = {
    val purchases = Source.fromFile("purchases.csv").getLines().drop(1).foreach(line => {
      val Array(customerId, date, creditCard, cvv, category) = line.split(",").map(_.trim)
      purchaseList += new Purchase(customerId, date, creditCard, cvv, category)
    })
  }

  def prompt(s: String) = {
    println(s); io.StdIn.readLine()
  }

  def menu = {
    val seq = Seq(choiceOne, choiceTwo, choiceThree, choiceFour, choiceFive, choiceSix, choiceQuit).mkString("\n")
    prompt(s"\nPlease select a category:\n ${seq}\n")
  }

  case object choiceOne {
    def opt() = {
      val pw = new PrintWriter(new File("filtered_purchases.prn"))
      purchaseList.foreach(x =>
        if (x.category == "Alcohol") {
          val s = s"Customer: ${x.customerId}, Date: ${x.date.substring(0,10)} "
          println(s)
          pw.write(s + "\n")
        })
      pw.close()
      ""
    }

    override def toString: String = "1. Alcohol"
  }

  case object choiceTwo {
    def opt() = {
      val pw = new PrintWriter(new File("filtered_purchases.prn"))
      purchaseList.foreach(x =>
        if (x.category == "Furniture"){
          val s = s"Customer: ${x.customerId}, Date: ${x.date.substring(0,10)} "
          println(s)
        pw.write(s + "\n")
        })
      pw.close()
      ""
    }
    override def toString: String = "2. Furniture"
  }

  case object choiceThree {
    def opt() = {
      val pw = new PrintWriter(new File("filtered_purchases.prn"))
      purchaseList.foreach(x =>
        if (x.category == "Jewelry") {
          val s = s"Customer: ${x.customerId}, Date: ${x.date.substring(0,10)} "
          println(s)
          pw.write(s + "\n")
        })
      pw.close()
      ""
    }
    override def toString: String = "3. Jewelry"
  }

  case object choiceFour {
    def opt() = {
      val pw = new PrintWriter(new File("filtered_purchases.prn"))
      purchaseList.foreach(x =>
        if (x.category == "Toiletries") {
          val s = s"Customer: ${x.customerId}, Date: ${x.date.substring(0,10)} "
          println(s)
          pw.write(s + "\n")
        })
      pw.close()
      ""
    }
    override def toString: String = "4. Toiletries"
  }

  case object choiceFive {
    def opt() = {
      val pw = new PrintWriter(new File("filtered_purchases.prn"))
      purchaseList.foreach(x =>
        if (x.category == "Shoes") {
          val s = s"Customer: ${x.customerId}, Date: ${x.date.substring(0,10)} "
          println(s)
          pw.write(s + "\n")
        })
      pw.close()
      ""
    }
    override def toString: String = "5. Shoes"
  }

  case object choiceSix {
    def opt() = {
      val pw = new PrintWriter(new File("filtered_purchases.prn"))
      purchaseList.foreach(x =>
        if (x.category == "Food") {
          val s = s"Customer: ${x.customerId}, Date: ${x.date.substring(0,10)} "
          println(s)
          pw.write(s + "\n")
        })
      pw.close()
      ""
    }
    override def toString: String = "6. Food"
  }

  case object choiceQuit {
    def opt() = "Q"

    override def toString: String = "Q. Quit"
  }

}
