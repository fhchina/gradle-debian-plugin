package de.gesellix.gradle.debian.tasks.data

import org.gradle.api.tasks.Nested
import org.gradle.util.ConfigureUtil

class Data {

  @Nested
  DataDirectory[] directories = [] as DataDirectory[]
  @Nested
  DataFile[] files = [] as DataFile[]
  @Nested
  DataLink[] links = [] as DataLink[]
  @Nested
  DataDirectory[] conffileDirectories = [] as DataDirectory[]
  @Nested
  DataFile[] conffiles = [] as DataFile[]
  @Nested
  DataTemplate[] templates = [] as DataTemplate[]

  def dir(Closure closure) {
    def directory = new DataDirectory()
    ConfigureUtil.configure(closure, directory)
    directories = directories.toList() + directory
  }

  def file(Closure closure) {
    def file = new DataFile()
    ConfigureUtil.configure(closure, file)
    files = files.toList() + file
  }

  def link(Closure closure) {
    def link = new DataLink()
    ConfigureUtil.configure(closure, link)
    links = links.toList() + link
  }

  def conffileDir(Closure closure) {
    def directory = new DataDirectory()
    ConfigureUtil.configure(closure, directory)
    conffileDirectories = conffileDirectories.toList() + directory
  }

  def conffile(Closure closure) {
    def file = new DataFile()
    ConfigureUtil.configure(closure, file)
    conffiles = conffiles.toList() + file
  }

  def template(Closure closure) {
    def template = new DataTemplate()
    ConfigureUtil.configure(closure, template)
    templates = templates.toList() + template
  }
}
