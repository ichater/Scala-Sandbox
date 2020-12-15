import level04.WhiteBelt

package object level04 {

  sealed trait BJJ

  case object WhiteBelt extends BJJ

  case object BlueBelt extends BJJ

  case object PurpleBelt extends BJJ

  case object BrownBelt extends BJJ

  case object BlackBelt extends BJJ

}


object Classes extends App {
  type JobId = Int

  type HumanId = Int

  case class Job(name: String, description: String)

  case class Human(name: String, optJobId: Option[JobId])

  val jobsDatabase: Map[JobId, Job] = Map(
    1 -> Job("Teacher", "Expert in their field"),
    2 -> Job("Engineer", "Build things for people")
  )

  val humansDatabase: Map[HumanId, Human] = Map(
    1 -> Human("Sally", None),
    2 -> Human("Jenny", Some(1)),
    3 -> Human("Timmy", Some(1024)) // jobId doesn't exist in jobsDatabase
  )

  def findHumanById(humanId: HumanId): Option[Human] = humansDatabase.get(humanId)

  def logNameById( jobId: JobId)  : Option[String] = {
    val maybeJob = jobsDatabase.get(jobId)
    maybeJob match {
      case Some(value) => Some(value.name)
      case None => None
    }
  }


  println(logNameById(2))

  def mkBJJBeltOrNull(str: String): level04.BJJ =
    str match {
      case "white" => level04.WhiteBelt
      case "blue" => level04.BlueBelt
      case "purple" => level04.PurpleBelt
      case "brown" => level04.BrownBelt
      case "black" => level04.BlackBelt
      case _ => null
    }



  println(s"izaak is a ${mkBJJBeltOrNull("purple")}")

  case class Student(var rollno: Int = 1, var name: String = "Dan", var marks: Int=85){
    def show() = println("Hii")
    def >(s2: Student): Boolean = marks > s2.marks
  }


  val s1 = Student(2, "Izaak", 50)
  println(s1)
  val s2 = Student(4,"JustNameChanged", 66)
  println(s2.>(s1))
}
