package ahmed.sadek.assignment.ui.search

import ahmed.sadek.assignment.data.network.HitObj
import androidx.recyclerview.widget.DiffUtil

class PostsDiffUtilCallback (
private val oldList: List<HitObj>, private
val newList: List<HitObj>) : DiffUtil.Callback()
{
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition]._source!!.studyTitle == newList[newItemPosition]._source!!.studyTitle

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        true // for the sake of simplicity we return true here but it can be changed to reflect a fine-grained control over which part of our views are updated
}