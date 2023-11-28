package gti.g55.eventichs_organisation.Domaine.Entités

import android.os.Parcel
import android.os.Parcelable

class Organisation(val id: Int, val idUtilisateur: Int, val idCatégorie: Int, val nom: String, val estPublic: Boolean): Parcelable {

    constructor(parcel: Parcel): this (
        parcel.readInt(),
        parcel.readInt()!!,
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readBoolean()!!
    ) {

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(idUtilisateur)
        parcel.writeInt(idCatégorie)
        parcel.writeString(nom)
        parcel.writeBoolean(estPublic)
    }

    companion object CREATOR: Parcelable.Creator<Organisation> {
        override fun createFromParcel(parcel: Parcel): Organisation {
            return Organisation(parcel)
        }

        override fun newArray(size: Int): Array<Organisation?> {
            return arrayOfNulls(size)
        }
    }
}