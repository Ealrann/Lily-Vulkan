/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attachment Ref Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentRefPkgImpl#getAttachmentRefs <em>Attachment Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttachmentRefPkgImpl extends LilyEObject implements AttachmentRefPkg
{
	/**
	 * The cached value of the '{@link #getAttachmentRefs() <em>Attachment Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachmentRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<AttachmentRef> attachmentRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentRefPkgImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicPackage.Literals.ATTACHMENT_REF_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttachmentRef> getAttachmentRefs()
	{
		if (attachmentRefs == null) {
			attachmentRefs = new EObjectContainmentEList<AttachmentRef>(AttachmentRef.class, this, GraphicPackage.ATTACHMENT_REF_PKG__ATTACHMENT_REFS);
		}
		return attachmentRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case GraphicPackage.ATTACHMENT_REF_PKG__ATTACHMENT_REFS:
				return ((InternalEList<?>)getAttachmentRefs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case GraphicPackage.ATTACHMENT_REF_PKG__ATTACHMENT_REFS:
				return getAttachmentRefs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case GraphicPackage.ATTACHMENT_REF_PKG__ATTACHMENT_REFS:
				getAttachmentRefs().clear();
				getAttachmentRefs().addAll((Collection<? extends AttachmentRef>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case GraphicPackage.ATTACHMENT_REF_PKG__ATTACHMENT_REFS:
				getAttachmentRefs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case GraphicPackage.ATTACHMENT_REF_PKG__ATTACHMENT_REFS:
				return attachmentRefs != null && !attachmentRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AttachmentRefPkgImpl
