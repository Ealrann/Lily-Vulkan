/**
 */
package org.sheepy.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.vulkan.model.process.graphic.SubpassDependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Render Pass Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl#getAttachments <em>Attachments</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl#getBindPoint <em>Bind Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenderPassInfoImpl extends MinimalEObjectImpl.Container implements RenderPassInfo
{
	/**
	 * The cached value of the '{@link #getAttachments() <em>Attachments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<AttachmentDescription> attachments;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<SubpassDependency> dependencies;

	/**
	 * The default value of the '{@link #getBindPoint() <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindPoint()
	 * @generated
	 * @ordered
	 */
	protected static final int BIND_POINT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBindPoint() <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindPoint()
	 * @generated
	 * @ordered
	 */
	protected int bindPoint = BIND_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenderPassInfoImpl()
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
		return GraphicPackage.Literals.RENDER_PASS_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttachmentDescription> getAttachments()
	{
		if (attachments == null)
		{
			attachments = new EObjectContainmentEList<AttachmentDescription>(AttachmentDescription.class, this, GraphicPackage.RENDER_PASS_INFO__ATTACHMENTS);
		}
		return attachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubpassDependency> getDependencies()
	{
		if (dependencies == null)
		{
			dependencies = new EObjectContainmentEList<SubpassDependency>(SubpassDependency.class, this, GraphicPackage.RENDER_PASS_INFO__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBindPoint()
	{
		return bindPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindPoint(int newBindPoint)
	{
		int oldBindPoint = bindPoint;
		bindPoint = newBindPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.RENDER_PASS_INFO__BIND_POINT, oldBindPoint, bindPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.RENDER_PASS_INFO__ATTACHMENTS:
				return ((InternalEList<?>)getAttachments()).basicRemove(otherEnd, msgs);
			case GraphicPackage.RENDER_PASS_INFO__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
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
		switch (featureID)
		{
			case GraphicPackage.RENDER_PASS_INFO__ATTACHMENTS:
				return getAttachments();
			case GraphicPackage.RENDER_PASS_INFO__DEPENDENCIES:
				return getDependencies();
			case GraphicPackage.RENDER_PASS_INFO__BIND_POINT:
				return getBindPoint();
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
		switch (featureID)
		{
			case GraphicPackage.RENDER_PASS_INFO__ATTACHMENTS:
				getAttachments().clear();
				getAttachments().addAll((Collection<? extends AttachmentDescription>)newValue);
				return;
			case GraphicPackage.RENDER_PASS_INFO__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends SubpassDependency>)newValue);
				return;
			case GraphicPackage.RENDER_PASS_INFO__BIND_POINT:
				setBindPoint((Integer)newValue);
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
		switch (featureID)
		{
			case GraphicPackage.RENDER_PASS_INFO__ATTACHMENTS:
				getAttachments().clear();
				return;
			case GraphicPackage.RENDER_PASS_INFO__DEPENDENCIES:
				getDependencies().clear();
				return;
			case GraphicPackage.RENDER_PASS_INFO__BIND_POINT:
				setBindPoint(BIND_POINT_EDEFAULT);
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
		switch (featureID)
		{
			case GraphicPackage.RENDER_PASS_INFO__ATTACHMENTS:
				return attachments != null && !attachments.isEmpty();
			case GraphicPackage.RENDER_PASS_INFO__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case GraphicPackage.RENDER_PASS_INFO__BIND_POINT:
				return bindPoint != BIND_POINT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (bindPoint: ");
		result.append(bindPoint);
		result.append(')');
		return result.toString();
	}

} //RenderPassInfoImpl
