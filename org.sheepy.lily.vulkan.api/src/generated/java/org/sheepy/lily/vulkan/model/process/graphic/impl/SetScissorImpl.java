/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Scissor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl#getOffsetX <em>Offset X</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl#getOffsetY <em>Offset Y</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetScissorImpl extends LilyEObject implements SetScissor
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffsetX() <em>Offset X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetX()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffsetX() <em>Offset X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetX()
	 * @generated
	 * @ordered
	 */
	protected int offsetX = OFFSET_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffsetY() <em>Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetY()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffsetY() <em>Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetY()
	 * @generated
	 * @ordered
	 */
	protected int offsetY = OFFSET_Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetScissorImpl()
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
		return GraphicPackage.Literals.SET_SCISSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SET_SCISSOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SET_SCISSOR__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOffsetX()
	{
		return offsetX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetX(int newOffsetX)
	{
		int oldOffsetX = offsetX;
		offsetX = newOffsetX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SET_SCISSOR__OFFSET_X, oldOffsetX, offsetX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOffsetY()
	{
		return offsetY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetY(int newOffsetY)
	{
		int oldOffsetY = offsetY;
		offsetY = newOffsetY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SET_SCISSOR__OFFSET_Y, oldOffsetY, offsetY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWidth()
	{
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(int newWidth)
	{
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SET_SCISSOR__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHeight()
	{
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeight(int newHeight)
	{
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SET_SCISSOR__HEIGHT, oldHeight, height));
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
			case GraphicPackage.SET_SCISSOR__NAME:
				return getName();
			case GraphicPackage.SET_SCISSOR__ENABLED:
				return isEnabled();
			case GraphicPackage.SET_SCISSOR__OFFSET_X:
				return getOffsetX();
			case GraphicPackage.SET_SCISSOR__OFFSET_Y:
				return getOffsetY();
			case GraphicPackage.SET_SCISSOR__WIDTH:
				return getWidth();
			case GraphicPackage.SET_SCISSOR__HEIGHT:
				return getHeight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicPackage.SET_SCISSOR__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.SET_SCISSOR__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case GraphicPackage.SET_SCISSOR__OFFSET_X:
				setOffsetX((Integer)newValue);
				return;
			case GraphicPackage.SET_SCISSOR__OFFSET_Y:
				setOffsetY((Integer)newValue);
				return;
			case GraphicPackage.SET_SCISSOR__WIDTH:
				setWidth((Integer)newValue);
				return;
			case GraphicPackage.SET_SCISSOR__HEIGHT:
				setHeight((Integer)newValue);
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
			case GraphicPackage.SET_SCISSOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.SET_SCISSOR__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case GraphicPackage.SET_SCISSOR__OFFSET_X:
				setOffsetX(OFFSET_X_EDEFAULT);
				return;
			case GraphicPackage.SET_SCISSOR__OFFSET_Y:
				setOffsetY(OFFSET_Y_EDEFAULT);
				return;
			case GraphicPackage.SET_SCISSOR__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case GraphicPackage.SET_SCISSOR__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
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
			case GraphicPackage.SET_SCISSOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.SET_SCISSOR__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case GraphicPackage.SET_SCISSOR__OFFSET_X:
				return offsetX != OFFSET_X_EDEFAULT;
			case GraphicPackage.SET_SCISSOR__OFFSET_Y:
				return offsetY != OFFSET_Y_EDEFAULT;
			case GraphicPackage.SET_SCISSOR__WIDTH:
				return width != WIDTH_EDEFAULT;
			case GraphicPackage.SET_SCISSOR__HEIGHT:
				return height != HEIGHT_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", offsetX: ");
		result.append(offsetX);
		result.append(", offsetY: ");
		result.append(offsetY);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} //SetScissorImpl
