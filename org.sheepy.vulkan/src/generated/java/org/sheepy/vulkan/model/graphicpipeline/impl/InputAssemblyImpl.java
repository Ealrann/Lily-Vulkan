/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.enumeration.EPrimitiveTopology;

import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Assembly</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.InputAssemblyImpl#isPrimitiveRestartEnabled <em>Primitive Restart Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.InputAssemblyImpl#getPrimitiveTopology <em>Primitive Topology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputAssemblyImpl extends MinimalEObjectImpl.Container implements InputAssembly
{
	/**
	 * The default value of the '{@link #isPrimitiveRestartEnabled() <em>Primitive Restart Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitiveRestartEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMITIVE_RESTART_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrimitiveRestartEnabled() <em>Primitive Restart Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitiveRestartEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean primitiveRestartEnabled = PRIMITIVE_RESTART_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrimitiveTopology() <em>Primitive Topology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveTopology()
	 * @generated
	 * @ordered
	 */
	protected static final EPrimitiveTopology PRIMITIVE_TOPOLOGY_EDEFAULT = EPrimitiveTopology.TRIANGLE_LIST;

	/**
	 * The cached value of the '{@link #getPrimitiveTopology() <em>Primitive Topology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveTopology()
	 * @generated
	 * @ordered
	 */
	protected EPrimitiveTopology primitiveTopology = PRIMITIVE_TOPOLOGY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputAssemblyImpl()
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
		return GraphicpipelinePackage.Literals.INPUT_ASSEMBLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrimitiveRestartEnabled()
	{
		return primitiveRestartEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitiveRestartEnabled(boolean newPrimitiveRestartEnabled)
	{
		boolean oldPrimitiveRestartEnabled = primitiveRestartEnabled;
		primitiveRestartEnabled = newPrimitiveRestartEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED, oldPrimitiveRestartEnabled, primitiveRestartEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPrimitiveTopology getPrimitiveTopology()
	{
		return primitiveTopology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitiveTopology(EPrimitiveTopology newPrimitiveTopology)
	{
		EPrimitiveTopology oldPrimitiveTopology = primitiveTopology;
		primitiveTopology = newPrimitiveTopology == null ? PRIMITIVE_TOPOLOGY_EDEFAULT : newPrimitiveTopology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY, oldPrimitiveTopology, primitiveTopology));
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
			case GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED:
				return isPrimitiveRestartEnabled();
			case GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY:
				return getPrimitiveTopology();
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
			case GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED:
				setPrimitiveRestartEnabled((Boolean)newValue);
				return;
			case GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY:
				setPrimitiveTopology((EPrimitiveTopology)newValue);
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
			case GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED:
				setPrimitiveRestartEnabled(PRIMITIVE_RESTART_ENABLED_EDEFAULT);
				return;
			case GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY:
				setPrimitiveTopology(PRIMITIVE_TOPOLOGY_EDEFAULT);
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
			case GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED:
				return primitiveRestartEnabled != PRIMITIVE_RESTART_ENABLED_EDEFAULT;
			case GraphicpipelinePackage.INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY:
				return primitiveTopology != PRIMITIVE_TOPOLOGY_EDEFAULT;
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
		result.append(" (primitiveRestartEnabled: ");
		result.append(primitiveRestartEnabled);
		result.append(", primitiveTopology: ");
		result.append(primitiveTopology);
		result.append(')');
		return result.toString();
	}

} //InputAssemblyImpl
