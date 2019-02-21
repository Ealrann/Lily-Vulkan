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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.model.enumeration.ELogicOp;

import org.sheepy.lily.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color Blend</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl#getAttachments <em>Attachments</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl#isLogicOpEnable <em>Logic Op Enable</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl#getLogicOp <em>Logic Op</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl#getBlendConstant0 <em>Blend Constant0</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl#getBlendConstant1 <em>Blend Constant1</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl#getBlendConstant2 <em>Blend Constant2</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl#getBlendConstant3 <em>Blend Constant3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColorBlendImpl extends MinimalEObjectImpl.Container implements ColorBlend
{
	/**
	 * The cached value of the '{@link #getAttachments() <em>Attachments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<ColorBlendAttachment> attachments;

	/**
	 * The default value of the '{@link #isLogicOpEnable() <em>Logic Op Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogicOpEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOGIC_OP_ENABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLogicOpEnable() <em>Logic Op Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogicOpEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean logicOpEnable = LOGIC_OP_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogicOp() <em>Logic Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicOp()
	 * @generated
	 * @ordered
	 */
	protected static final ELogicOp LOGIC_OP_EDEFAULT = ELogicOp.COPY;

	/**
	 * The cached value of the '{@link #getLogicOp() <em>Logic Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicOp()
	 * @generated
	 * @ordered
	 */
	protected ELogicOp logicOp = LOGIC_OP_EDEFAULT;

	/**
	 * The default value of the '{@link #getBlendConstant0() <em>Blend Constant0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlendConstant0()
	 * @generated
	 * @ordered
	 */
	protected static final int BLEND_CONSTANT0_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBlendConstant0() <em>Blend Constant0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlendConstant0()
	 * @generated
	 * @ordered
	 */
	protected int blendConstant0 = BLEND_CONSTANT0_EDEFAULT;

	/**
	 * The default value of the '{@link #getBlendConstant1() <em>Blend Constant1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlendConstant1()
	 * @generated
	 * @ordered
	 */
	protected static final int BLEND_CONSTANT1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBlendConstant1() <em>Blend Constant1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlendConstant1()
	 * @generated
	 * @ordered
	 */
	protected int blendConstant1 = BLEND_CONSTANT1_EDEFAULT;

	/**
	 * The default value of the '{@link #getBlendConstant2() <em>Blend Constant2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlendConstant2()
	 * @generated
	 * @ordered
	 */
	protected static final int BLEND_CONSTANT2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBlendConstant2() <em>Blend Constant2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlendConstant2()
	 * @generated
	 * @ordered
	 */
	protected int blendConstant2 = BLEND_CONSTANT2_EDEFAULT;

	/**
	 * The default value of the '{@link #getBlendConstant3() <em>Blend Constant3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlendConstant3()
	 * @generated
	 * @ordered
	 */
	protected static final int BLEND_CONSTANT3_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getBlendConstant3() <em>Blend Constant3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlendConstant3()
	 * @generated
	 * @ordered
	 */
	protected int blendConstant3 = BLEND_CONSTANT3_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorBlendImpl()
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
		return GraphicPackage.Literals.COLOR_BLEND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ColorBlendAttachment> getAttachments()
	{
		if (attachments == null)
		{
			attachments = new EObjectContainmentEList<ColorBlendAttachment>(
					ColorBlendAttachment.class, this, GraphicPackage.COLOR_BLEND__ATTACHMENTS);
		}
		return attachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLogicOpEnable()
	{
		return logicOpEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLogicOpEnable(boolean newLogicOpEnable)
	{
		boolean oldLogicOpEnable = logicOpEnable;
		logicOpEnable = newLogicOpEnable;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.COLOR_BLEND__LOGIC_OP_ENABLE, oldLogicOpEnable, logicOpEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ELogicOp getLogicOp()
	{
		return logicOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLogicOp(ELogicOp newLogicOp)
	{
		ELogicOp oldLogicOp = logicOp;
		logicOp = newLogicOp == null ? LOGIC_OP_EDEFAULT : newLogicOp;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.COLOR_BLEND__LOGIC_OP, oldLogicOp, logicOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBlendConstant0()
	{
		return blendConstant0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlendConstant0(int newBlendConstant0)
	{
		int oldBlendConstant0 = blendConstant0;
		blendConstant0 = newBlendConstant0;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.COLOR_BLEND__BLEND_CONSTANT0, oldBlendConstant0, blendConstant0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBlendConstant1()
	{
		return blendConstant1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlendConstant1(int newBlendConstant1)
	{
		int oldBlendConstant1 = blendConstant1;
		blendConstant1 = newBlendConstant1;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.COLOR_BLEND__BLEND_CONSTANT1, oldBlendConstant1, blendConstant1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBlendConstant2()
	{
		return blendConstant2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlendConstant2(int newBlendConstant2)
	{
		int oldBlendConstant2 = blendConstant2;
		blendConstant2 = newBlendConstant2;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.COLOR_BLEND__BLEND_CONSTANT2, oldBlendConstant2, blendConstant2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBlendConstant3()
	{
		return blendConstant3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlendConstant3(int newBlendConstant3)
	{
		int oldBlendConstant3 = blendConstant3;
		blendConstant3 = newBlendConstant3;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.COLOR_BLEND__BLEND_CONSTANT3, oldBlendConstant3, blendConstant3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case GraphicPackage.COLOR_BLEND__ATTACHMENTS:
			return ((InternalEList<?>) getAttachments()).basicRemove(otherEnd, msgs);
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
		case GraphicPackage.COLOR_BLEND__ATTACHMENTS:
			return getAttachments();
		case GraphicPackage.COLOR_BLEND__LOGIC_OP_ENABLE:
			return isLogicOpEnable();
		case GraphicPackage.COLOR_BLEND__LOGIC_OP:
			return getLogicOp();
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT0:
			return getBlendConstant0();
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT1:
			return getBlendConstant1();
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT2:
			return getBlendConstant2();
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT3:
			return getBlendConstant3();
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
		case GraphicPackage.COLOR_BLEND__ATTACHMENTS:
			getAttachments().clear();
			getAttachments().addAll((Collection<? extends ColorBlendAttachment>) newValue);
			return;
		case GraphicPackage.COLOR_BLEND__LOGIC_OP_ENABLE:
			setLogicOpEnable((Boolean) newValue);
			return;
		case GraphicPackage.COLOR_BLEND__LOGIC_OP:
			setLogicOp((ELogicOp) newValue);
			return;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT0:
			setBlendConstant0((Integer) newValue);
			return;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT1:
			setBlendConstant1((Integer) newValue);
			return;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT2:
			setBlendConstant2((Integer) newValue);
			return;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT3:
			setBlendConstant3((Integer) newValue);
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
		case GraphicPackage.COLOR_BLEND__ATTACHMENTS:
			getAttachments().clear();
			return;
		case GraphicPackage.COLOR_BLEND__LOGIC_OP_ENABLE:
			setLogicOpEnable(LOGIC_OP_ENABLE_EDEFAULT);
			return;
		case GraphicPackage.COLOR_BLEND__LOGIC_OP:
			setLogicOp(LOGIC_OP_EDEFAULT);
			return;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT0:
			setBlendConstant0(BLEND_CONSTANT0_EDEFAULT);
			return;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT1:
			setBlendConstant1(BLEND_CONSTANT1_EDEFAULT);
			return;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT2:
			setBlendConstant2(BLEND_CONSTANT2_EDEFAULT);
			return;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT3:
			setBlendConstant3(BLEND_CONSTANT3_EDEFAULT);
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
		case GraphicPackage.COLOR_BLEND__ATTACHMENTS:
			return attachments != null && !attachments.isEmpty();
		case GraphicPackage.COLOR_BLEND__LOGIC_OP_ENABLE:
			return logicOpEnable != LOGIC_OP_ENABLE_EDEFAULT;
		case GraphicPackage.COLOR_BLEND__LOGIC_OP:
			return logicOp != LOGIC_OP_EDEFAULT;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT0:
			return blendConstant0 != BLEND_CONSTANT0_EDEFAULT;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT1:
			return blendConstant1 != BLEND_CONSTANT1_EDEFAULT;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT2:
			return blendConstant2 != BLEND_CONSTANT2_EDEFAULT;
		case GraphicPackage.COLOR_BLEND__BLEND_CONSTANT3:
			return blendConstant3 != BLEND_CONSTANT3_EDEFAULT;
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
		result.append(" (logicOpEnable: ");
		result.append(logicOpEnable);
		result.append(", logicOp: ");
		result.append(logicOp);
		result.append(", blendConstant0: ");
		result.append(blendConstant0);
		result.append(", blendConstant1: ");
		result.append(blendConstant1);
		result.append(", blendConstant2: ");
		result.append(blendConstant2);
		result.append(", blendConstant3: ");
		result.append(blendConstant3);
		result.append(')');
		return result.toString();
	}

} //ColorBlendImpl
