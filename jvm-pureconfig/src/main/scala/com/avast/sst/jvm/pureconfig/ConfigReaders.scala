package com.avast.sst.jvm.pureconfig

import com.avast.sst.jvm.execution.ForkJoinPoolConfig.TaskPeekingMode
import com.avast.sst.jvm.execution.{ForkJoinPoolConfig, ThreadPoolExecutorConfig}
import pureconfig.ConfigReader
import pureconfig.generic.ProductHint
import pureconfig.generic.semiauto._

trait ConfigReaders {

  implicit protected def hint[T]: ProductHint[T] = ProductHint.default

  implicit val jvmThreadPoolExecutorConfigReader: ConfigReader[ThreadPoolExecutorConfig] = deriveReader[ThreadPoolExecutorConfig]

  implicit val jvmTaskPeekingModeReader: ConfigReader[TaskPeekingMode] = deriveEnumerationReader

  implicit val jvmForkJoinPoolConfigReader: ConfigReader[ForkJoinPoolConfig] = deriveReader[ForkJoinPoolConfig]

}
