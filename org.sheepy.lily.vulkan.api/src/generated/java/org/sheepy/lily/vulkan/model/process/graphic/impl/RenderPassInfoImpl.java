/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Render Pass Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl#getExtraAttachments <em>Extra Attachments</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl#getColorAttachment <em>Color Attachment</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl#getSubpasses <em>Subpasses</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl#getBindPoint <em>Bind Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenderPassInfoImpl extends LilyEObject implements RenderPassInfo
{
	/**
	 * The cached value of the '{@link #getExtraAttachments() <em>Extra Attachments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtraAttachment> extraAttachments;

	/**
	 * The cached value of the '{@link #getColorAttachment() <em>Color Attachment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorAttachment()
	 * @generated
	 * @ordered
	 */
	protected SwapImageAttachment colorAttachment;

	/**
	 * The cached value of the '{@link #getSubpasses() <em>Subpasses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubpasses()
	 * @generated
	 * @ordered
	 */
	protected EList<Subpass> subpasses;

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
	protected RenderPassInfoImpl()
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
	@Override
	public EList<ExtraAttachment> getExtraAttachments()
	{
		if (extraAttachments == null)
		{
			extraAttachments = new EObjectContainmentEList<ExtraAttachment>(ExtraAttachment.class, this, GraphicPackage.RENDER_PASS_INFO__EXTRA_ATTACHMENTS);
		}
		return extraAttachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwapImageAttachment getColorAttachment()
	{
		return colorAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColorAttachment(SwapImageAttachment newColorAttachment, NotificationChain msgs)
	{
		SwapImageAttachment oldColorAttachment = colorAttachment;
		colorAttachment = newColorAttachment;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT, oldColorAttachment, newColorAttachment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorAttachment(SwapImageAttachment newColorAttachment)
	{
		if (newColorAttachment != colorAttachment)
		{
			NotificationChain msgs = null;
			if (colorAttachment != null)
				msgs = ((InternalEObject)colorAttachment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT, null, msgs);
			if (newColorAttachment != null)
				msgs = ((InternalEObject)newColorAttachment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT, null, msgs);
			msgs = basicSetColorAttachment(newColorAttachment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT, newColorAttachment, newColorAttachment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Subpass> getSubpasses()
	{
		if (subpasses == null)
		{
			subpasses = new EObjectContainmentEList<Subpass>(Subpass.class, this, GraphicPackage.RENDER_PASS_INFO__SUBPASSES);
		}
		return subpasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public int getBindPoint()
	{
		return bindPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			case GraphicPackage.RENDER_PASS_INFO__EXTRA_ATTACHMENTS:
				return ((InternalEList<?>)getExtraAttachments()).basicRemove(otherEnd, msgs);
			case GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT:
				return basicSetColorAttachment(null, msgs);
			case GraphicPackage.RENDER_PASS_INFO__SUBPASSES:
				return ((InternalEList<?>)getSubpasses()).basicRemove(otherEnd, msgs);
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
			case GraphicPackage.RENDER_PASS_INFO__EXTRA_ATTACHMENTS:
				return getExtraAttachments();
			case GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT:
				return getColorAttachment();
			case GraphicPackage.RENDER_PASS_INFO__SUBPASSES:
				return getSubpasses();
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
			case GraphicPackage.RENDER_PASS_INFO__EXTRA_ATTACHMENTS:
				getExtraAttachments().clear();
				getExtraAttachments().addAll((Collection<? extends ExtraAttachment>)newValue);
				return;
			case GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT:
				setColorAttachment((SwapImageAttachment)newValue);
				return;
			case GraphicPackage.RENDER_PASS_INFO__SUBPASSES:
				getSubpasses().clear();
				getSubpasses().addAll((Collection<? extends Subpass>)newValue);
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
			case GraphicPackage.RENDER_PASS_INFO__EXTRA_ATTACHMENTS:
				getExtraAttachments().clear();
				return;
			case GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT:
				setColorAttachment((SwapImageAttachment)null);
				return;
			case GraphicPackage.RENDER_PASS_INFO__SUBPASSES:
				getSubpasses().clear();
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
			case GraphicPackage.RENDER_PASS_INFO__EXTRA_ATTACHMENTS:
				return extraAttachments != null && !extraAttachments.isEmpty();
			case GraphicPackage.RENDER_PASS_INFO__COLOR_ATTACHMENT:
				return colorAttachment != null;
			case GraphicPackage.RENDER_PASS_INFO__SUBPASSES:
				return subpasses != null && !subpasses.isEmpty();
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
